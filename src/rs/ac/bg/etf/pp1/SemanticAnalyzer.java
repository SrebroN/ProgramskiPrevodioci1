package rs.ac.bg.etf.pp1;

import java.util.HashSet;

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
	private boolean returnHappened;
	private HashSet<String> methodsReferenced = new HashSet<>();
	private HashSet<String> intMethodsReferenced = new HashSet<>();

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
		for (String method : methodsReferenced) {
			Obj methObj = Tab.find(method);
			if (methObj.getKind() != Obj.Meth) {
				report_error("Referencirani metod ne postoji: " + method, null);
			}
		}
		for (String meth : intMethodsReferenced) {
			Obj method = Tab.find(meth);
			if (method == Tab.noObj) {
				report_error("Pristup nedefinisanoj promenljivi: "+ meth, null);
			} else if (method.getKind() != Obj.Meth) {
				report_error("Leva strana map mora biti metoda", null);
			} else if (!method.getType().equals(Tab.intType)) {
				report_error("Metoda mora biti tipa int", null);
			} else if (method.getLevel() != 1) {
				report_error("Metoda mora imati tacno jedan parametar", null);
			} else {
				boolean flag = false;
				for (Obj loc : method.getLocalSymbols()) {
					if (loc.getFpPos() == 1 && loc.getType().equals(Tab.intType)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					report_error("Parametar mora biti tipa int", null);
				}
			}
		}
		Tab.chainLocalSymbols(currentProgram);
		currentProgram = null;
		methodsReferenced = null;
		Tab.closeScope();
		if (mainMethod == null) {
			report_error("Greska, main nije deklarisan", null);
		} else if (mainMethod.getLevel() > 0) {
			report_error("Greska, main ne sme imati parametre", null);
		}
	}

	// ---------------------CONST DECL---------------------
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

	// ---------------------VAR DECLARATIONS---------------------
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

	// ---------------------METHOD DECLARATIONS---------------------

	@Override
	public void visit(MethodDecl methodDecl) {
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		if (currentMethod.getType() != Tab.noType && !returnHappened) {
			report_error("Metoda mora imati return:", methodDecl);
		}
		currentMethod = null;
		returnHappened = false;
	}

	@Override
	public void visit(MethodSignAndName_Type methodSignAndName_Type) {
		if (methodSignAndName_Type.getI2().equalsIgnoreCase("main")) {
			report_error("Main mora imati type void: " + methodSignAndName_Type, methodSignAndName_Type);
		}
		currentMethod = Tab.insert(Obj.Meth, methodSignAndName_Type.getI2(), currentType);
		Tab.openScope();
	}

	@Override
	public void visit(MethodSignAndName_Void methodSignAndName_Void) {
		currentMethod = Tab.insert(Obj.Meth, methodSignAndName_Void.getI1(), Tab.noType);
		Tab.openScope();
		if (methodSignAndName_Void.getI1().equalsIgnoreCase("main")) {
			mainMethod = currentMethod;
		}
	}

	// ---------------------FORMAL PARAM DECL---------------------
	@Override
	public void visit(FormPars_var formPars_var) {
		Obj varObj = null;
		if (currentMethod == null) {
			report_error("Semanticka greska. [FormPars_var]", formPars_var);
		} else {
			varObj = Tab.currentScope().findSymbol(formPars_var.getI2());
		}
		if (varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, formPars_var.getI2(), currentType);
			varObj.setFpPos(1);
			currentMethod.setLevel(currentMethod.getLevel() + 1);
		} else {
			report_error("Dvostruka definicija konstante: " + formPars_var.getI2(), formPars_var);
		}
	}

	@Override
	public void visit(FormPars_arr formPars_arr) {
		Obj varObj = null;
		if (currentMethod == null) {
			report_error("Semanticka greska. [FormPars_var]", formPars_arr);
		} else {
			varObj = Tab.currentScope().findSymbol(formPars_arr.getI2());
		}
		if (varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, formPars_arr.getI2(), new Struct(Struct.Array, currentType));
			varObj.setFpPos(1);
			currentMethod.setLevel(currentMethod.getLevel() + 1);
		} else {
			report_error("Dvostruka definicija konstante: " + formPars_arr.getI2(), formPars_arr);
		}
	}

	// ---------------------FACTOR---------------------
	@Override
	public void visit(Factor_num factor_num) {
		factor_num.struct = Tab.intType;
	}

	@Override
	public void visit(Factor_char factor_char) {
		factor_char.struct = Tab.charType;
	}

	@Override
	public void visit(Factor_bool factor_bool) {
		factor_bool.struct = boolType;
	}

	@Override
	public void visit(Factor_des factor_des) {
		if (factor_des.getFactorAct() instanceof FactorAct_e) {
			factor_des.struct = factor_des.getDesignator().obj.getType();
		} else {
			if (factor_des.getDesignator().obj.getKind() != Obj.Meth) {
				report_error("Designator mora biti metoda: " + factor_des, factor_des);
				factor_des.struct = Tab.noType;
			} else {
				factor_des.struct = factor_des.getDesignator().obj.getType();
			}
		}
	}

	@Override
	public void visit(Factor_newexpr factor_newexpr) {
		if (!factor_newexpr.getExpr().struct.equals(Tab.intType)) {
			report_error("Velicina niza nije int: ", factor_newexpr);
			factor_newexpr.struct = Tab.noType;
		} else {
			if (currentType.getKind() != Struct.Enum) {
				factor_newexpr.struct = new Struct(Struct.Array, currentType);
			} else {
				// INICIJALIZOVATI SET
			}
		}

	}

	@Override
	public void visit(Factor_expr factor_expr) {
		factor_expr.struct = Tab.noType;
	}

	// ---------------------TERM---------------------
	@Override
	public void visit(Term term) {
		term.struct = term.getMulopFactor().struct;
	}

	// ---------------------ADDOP---------------------
	@Override
	public void visit(AddOpTerm_op addOpTerm_op) {
		Struct left = addOpTerm_op.getAddOpTerm().struct;
		Struct right = addOpTerm_op.getTerm().struct;
		if (left.equals(Tab.intType) && right.equals(Tab.intType)) {
			addOpTerm_op.struct = Tab.intType;
		} else {
			report_error("Sabiranje sa neint vrednostima: ", addOpTerm_op);
			addOpTerm_op.struct = Tab.noType;
		}
	}

	@Override
	public void visit(AddOpTerm_term addOpTerm_term) {
		addOpTerm_term.struct = addOpTerm_term.getTerm().struct;
	}

	// MULOP
	@Override
	public void visit(MulopFactor_fac mulopFactor_fac) {
		mulopFactor_fac.struct = mulopFactor_fac.getFactor().struct;
	}

	@Override
	public void visit(MulopFactor_mul mulopFactor_mul) {
		Struct left = mulopFactor_mul.getMulopFactor().struct;
		Struct right = mulopFactor_mul.getFactor().struct;
		if (left.equals(Tab.intType) && right.equals(Tab.intType)) {
			mulopFactor_mul.struct = Tab.intType;
		} else {
			report_error("Mnozenje sa neint vrednostima", mulopFactor_mul);
			mulopFactor_mul.struct = Tab.noType;
		}
	}

	// ---------------------EXPR---------------------
	@Override
	public void visit(Expr_term expr_term) {
		expr_term.struct = expr_term.getAddOpTerm().struct;
	}

	@Override
	public void visit(Expr_mint expr_mint) {
		if (!expr_mint.getAddOpTerm().struct.equals(Tab.intType)) {
			report_error("Negacija neint vrednosti: " + expr_mint, expr_mint);
			expr_mint.struct = Tab.noType;
		} else {
			expr_mint.struct = expr_mint.getAddOpTerm().struct;
		}
	}

	@Override
	public void visit(Expr_des expr_des) {
		intMethodsReferenced.add(expr_des.getI1());
		Obj right = Tab.find(expr_des.getDesignator().obj.getName());
		if (right == Tab.noObj) {
			report_error("Pristup nedefinisanoj promenljivi", expr_des);
			expr_des.struct = Tab.noType;
		} else if (right.getType().getKind() != Struct.Array) {
			report_error("Argument mora biti niz", expr_des);
			expr_des.struct = Tab.noType;
		} else if (!right.getType().getElemType().equals(Tab.intType)) {
			report_error("Niz mora biti tipa int", expr_des);
			expr_des.struct = Tab.noType;
		} else {
			expr_des.struct = Tab.intType;
		}
	}

	// ---------------------DESIGNATOR---------------------
	@Override
	public void visit(Designator_var designator_var) {
		Obj varObj = Tab.find(designator_var.getI1());
		if (varObj == Tab.noObj) {
			report_error("Pristup nedefinisanoj promenljivi: " + designator_var.getI1(), designator_var);
			designator_var.obj = Tab.noObj;
		} else if (varObj.getKind() != Obj.Var && varObj.getKind() != Obj.Con && varObj.getKind() != Obj.Meth) {
			report_error("Neadekvatna promenljiva: " + designator_var.getI1(), designator_var);
			designator_var.obj = Tab.noObj;
		} else {
			designator_var.obj = varObj;
		}
	}

	@Override
	public void visit(DesignatorArrayName designatorArrayName) {
		Obj arrObj = Tab.find(designatorArrayName.getI1());
		if (arrObj == Tab.noObj) {
			report_error("Pristup nedefinisanoj promenljivi niza: " + designatorArrayName.getI1(), designatorArrayName);
			designatorArrayName.obj = Tab.noObj;
		} else if (arrObj.getKind() != Obj.Var && arrObj.getKind() != Obj.Con && arrObj.getKind() != Obj.Meth) {
			report_error("Neadekvatna promenljiva niza: " + designatorArrayName.getI1(), designatorArrayName);
			designatorArrayName.obj = Tab.noObj;
		} else {
			designatorArrayName.obj = arrObj;
		}
	}

	@Override
	public void visit(Designator_elem designator_elem) {
		Obj arrObj = designator_elem.getDesignatorArrayName().obj;
		if (arrObj == Tab.noObj) {
			designator_elem.obj = Tab.noObj;
		} else if (!designator_elem.getExpr().struct.equals(Tab.intType)) {
			report_error("Indeksiranje sa neint vrednosti.", designator_elem);
			designator_elem.obj = Tab.noObj;
		} else {
			designator_elem.obj = new Obj(Obj.Elem, arrObj.getName() + "[$]", arrObj.getType().getElemType());
		}
	}

	// ---------------------DESIGNATOR STATEMENT---------------------
	@Override
	public void visit(DesignatorStatement_assigexpr designatorStatement_assigexpr) {
		int kind = designatorStatement_assigexpr.getDesignator().obj.getKind();
		if (kind != Obj.Var && kind != Obj.Elem) {
			report_error("Dodela u neadekvatnu promenljivu: " + designatorStatement_assigexpr.getDesignator(),
					designatorStatement_assigexpr);
		} else if (!designatorStatement_assigexpr.getExpr().struct
				.assignableTo(designatorStatement_assigexpr.getDesignator().obj.getType())) {
			report_error(
					"Neadekvatna dodela vrednosti u promenljivu: "
							+ designatorStatement_assigexpr.getDesignator().obj.getName(),
					designatorStatement_assigexpr);
		}
	}

	@Override
	public void visit(DesignatorStatement_inc designatorStatement_inc) {
		int kind = designatorStatement_inc.getDesignator().obj.getKind();
		if (kind != Obj.Var && kind != Obj.Elem) {
			report_error("INC neadekvatne promenljive: " + designatorStatement_inc.getDesignator(),
					designatorStatement_inc);
		} else if (!designatorStatement_inc.getDesignator().obj.getType().equals(Tab.intType)) {
			report_error("INC neint vrednosti: " + designatorStatement_inc.getDesignator().obj.getName(),
					designatorStatement_inc);
		}
	}

	@Override
	public void visit(DesignatorStatement_dec designatorStatement_dec) {
		int kind = designatorStatement_dec.getDesignator().obj.getKind();
		if (kind != Obj.Var && kind != Obj.Elem) {
			report_error("DEC neadekvatne promenljive: " + designatorStatement_dec.getDesignator(),
					designatorStatement_dec);
		} else if (!designatorStatement_dec.getDesignator().obj.getType().equals(Tab.intType)) {
			report_error("DEC neint vrednosti: " + designatorStatement_dec.getDesignator().obj.getName(),
					designatorStatement_dec);
		}
	}

	@Override
	public void visit(DesignatorMeth designatorMeth) {
		methodsReferenced.add(designatorMeth.getI1());
	}

	@Override
	public void visit(DesignatorStatement_assign designatorStatement_assigndes) {
		int type1 = designatorStatement_assigndes.getDesignator().obj.getType().getKind();
		int type2 = designatorStatement_assigndes.getDesignator1().obj.getType().getKind();
		int type3 = designatorStatement_assigndes.getDesignator2().obj.getType().getKind();
		if (type1 != Struct.Enum || type2 != Struct.Enum || type3 != Struct.Enum) {
			report_error("Union operacija sa neskupovima", designatorStatement_assigndes);
		}
	}

	// ---------------------STATEMENT---------------------
	@Override
	public void visit(Statement_ret statement_ret) {
		returnHappened = true;
	}

	@Override
	public void visit(Statement_rd statement_rd) {
		int kind = statement_rd.getDesignator().obj.getKind();
		Struct type = statement_rd.getDesignator().obj.getType();
		if (kind != Obj.Var && kind != Obj.Elem) {
			report_error("Read neadekvatne promenljive: " + statement_rd.getDesignator(), statement_rd);
		} else if (!type.equals(Tab.intType) && !type.equals(boolType) && !type.equals(Tab.charType)) {
			report_error("Read neint/char/bool vrednosti: " + statement_rd.getDesignator().obj.getName(), statement_rd);
		}
	}

	@Override
	public void visit(Statement_pr statement_pr) {
		Struct type = statement_pr.getExpr().struct;
		if (!type.equals(Tab.intType) && !type.equals(Tab.charType) && !type.equals(boolType)
				&& type.getKind() != Struct.Enum) {
			report_error("Print neadekvatne promenljive", statement_pr);
		}
	}

	// ---------------------TYPE---------------------
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
