package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyzer extends VisitorAdaptor {

	private boolean errorDetected = false;

	Logger log = Logger.getLogger(getClass());

	private Obj currentProgram;

	private Struct currentType;

	private int constant;

	private Struct constantType;
	private Struct boolType = Tab.find("bool").getType();

	private Obj mainMethod;

	private Obj currentMethod;

	// LOG MESSAGES
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0) {
			msg.append(" na liniji ").append(line);
		}
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0) {
			msg.append(" na liniji ").append(line);
		}
		log.info(msg.toString());
	}

	public boolean passed() {
		return !errorDetected;
	}

	// SEMANTIC PASS CODE
	@Override
	public void visit(ProgramName programName) {
		currentProgram = Tab.insert(Obj.Prog, programName.getI1(), Tab.noType);
		Tab.openScope();
	}

	@Override
	public void visit(Program program) {
		Tab.chainLocalSymbols(currentProgram);
		currentProgram = null;
		Tab.closeScope();
		if (mainMethod == null) {
			report_error("Greska, main nije deklarisan", null);
		}
		else if(mainMethod.getLevel()>0) {
			report_error("Greska, main ne sme imati parametre",null);
		}
	}

	// CONST DECL
	@Override
	public void visit(ConDecl conDecl) {
		Obj conObj = Tab.find(conDecl.getI1());
		if (conObj != Tab.noObj) {
			report_error("Dvostruka definicija konstante: " + conDecl.getI1(), conDecl);
		} else {
			if (constantType.assignableTo(currentType)) {
				conObj = Tab.insert(Obj.Con, conDecl.getI1(), currentType);
				conObj.setAdr(constant);
			} else {
				report_error("Neadekvatna dodela konstanti: " + conDecl.getI1(), conDecl);
			}
		}
	}

	@Override
	public void visit(Constant_n constant_n) {
		constant = constant_n.getN1();
		constantType = Tab.intType;

	}

	@Override
	public void visit(Constant_c constant_c) {
		constant = constant_c.getC1();
		constantType = Tab.charType;
	}

	@Override
	public void visit(Constant_b constant_b) {
		constant = constant_b.getB1();
		constantType = boolType;
	}

	// VAR DECLARATIONS
	@Override
	public void visit(VarDec_var varDec_var) {
		Obj varObj = null;
		if (currentMethod == null) {
			varObj = Tab.find(varDec_var.getI1());
		} else {
			varObj = Tab.currentScope().findSymbol(varDec_var.getI1());
		}
		if (varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, varDec_var.getI1(), currentType);
		} else {
			report_error("Dvostruka definicija konstante: " + varDec_var.getI1(), varDec_var);
		}
	}

	@Override
	public void visit(VarDec_arr varDec_arr) {
		Obj varObj = null;
		if (currentMethod == null) {
			varObj = Tab.find(varDec_arr.getI1());
		} else {
			varObj = Tab.currentScope().findSymbol(varDec_arr.getI1());
		}
		if (varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, varDec_arr.getI1(), new Struct(Struct.Array, currentType));
		} else {
			report_error("Dvostruka definicija konstante: " + varDec_arr.getI1(), varDec_arr);
		}
	}

	//FORMAL PARAM DECL
	@Override
	public void visit(FormPars_var formPars_var) {
		Obj varObj = null;
		if (currentMethod == null) {
			report_error("Semanticka greska. [FormPars_var]",formPars_var);
		} else {
			varObj = Tab.currentScope().findSymbol(formPars_var.getI2());
		}
		if (varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, formPars_var.getI2(), currentType);
			varObj.setFpPos(1);
			currentMethod.setLevel(currentMethod.getLevel()+1);
		} else {
			report_error("Dvostruka definicija konstante: " + formPars_var.getI2(), formPars_var);
		}
	}
	
	@Override
	public void visit(FormPars_arr formPars_arr) {
		Obj varObj = null;
		if (currentMethod == null) {
			report_error("Semanticka greska. [FormPars_var]",formPars_arr);
		} else {
			varObj = Tab.currentScope().findSymbol(formPars_arr.getI2());
		}
		if (varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, formPars_arr.getI2(), new Struct(Struct.Array,currentType));
			varObj.setFpPos(1);
			currentMethod.setLevel(currentMethod.getLevel()+1);
		} else {
			report_error("Dvostruka definicija konstante: " + formPars_arr.getI2(), formPars_arr);
		}
	}
	
	// METHOD DECLARATIONS
	@Override
	public void visit(MethodSignAndName_Type methodSignAndName_Type) {
		/*
		 * Obj methObj = Tab.find(methodSignAndName_Type.getI2()); if
		 * (methodSignAndName_Type.equals(methObj)) {
		 * report_error("Dvostruka definicija metode: " +
		 * methodSignAndName_Type.getI2(), methodSignAndName_Type); } else if
		 * (methodSignAndName_Type.getI2().equalsIgnoreCase("main")) {
		 * report_error("Main mora imati type void: " + methodSignAndName_Type,
		 * methodSignAndName_Type); } else { currentMethod = Tab.insert(Obj.Meth,
		 * methodSignAndName_Type.getI2(), currentType); Tab.openScope(); }
		 */
		if (methodSignAndName_Type.getI2().equalsIgnoreCase("main")) {
			report_error("Main mora imati type void: " + methodSignAndName_Type, methodSignAndName_Type);
		}
		currentMethod = Tab.insert(Obj.Meth, methodSignAndName_Type.getI2(), currentType);
		Tab.openScope();
	}

	@Override
	public void visit(MethodSignAndName_Void methodSignAndName_Void) {
		/*
		 * Obj methObj = Tab.find(methodSignAndName_Void.getI1()); if (methObj !=
		 * Tab.noObj && methObj.getType() == Tab.noType) {
		 * report_error("Dvostruka definicija metode: " +
		 * methodSignAndName_Void.getI1(), methodSignAndName_Void); } else {
		 * currentMethod = Tab.insert(Obj.Meth, methodSignAndName_Void.getI1(),
		 * Tab.noType); if (mainHappened == false &&
		 * methodSignAndName_Void.getI1().equalsIgnoreCase("main")) { mainHappened =
		 * true; Tab.openScope(); } }
		 */
		currentMethod = Tab.insert(Obj.Meth, methodSignAndName_Void.getI1(), Tab.noType);
		Tab.openScope();
		if (methodSignAndName_Void.getI1().equalsIgnoreCase("main")) {
			mainMethod=currentMethod;
		}
	}

	@Override
	public void visit(Factor_num factor_num) {
		factor_num.struct=Tab.intType;
	}
	@Override
	public void visit(Factor_char factor_char) {
		factor_char.struct=Tab.charType;
	}	@Override
	public void visit(Factor_bool factor_bool) {
		factor_bool.struct=boolType;
	}
	@Override
	public void visit(MethodDecl methodDecl) {

		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();

		currentMethod = null;
	}

	@Override
	public void visit(Type type) {
		Obj typeObj = Tab.find(type.getI1());
		if (typeObj == Tab.noObj) {
			report_error("Nepostojeci tip podatka: " + type.getI1(), type);
			currentType = Tab.noType;
		} else if (typeObj.getKind() != Obj.Type) {
			report_error("Neadekvatan tip podatka: " + type.getI1(), type);
			currentType = Tab.noType;
		} else {
			currentType = typeObj.getType();
		}
	}

}
