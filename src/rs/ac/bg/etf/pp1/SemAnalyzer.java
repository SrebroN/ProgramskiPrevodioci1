package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;


public class SemAnalyzer extends VisitorAdaptor {

	private boolean errorDetected=false;
	
	Logger log=Logger.getLogger(getClass());

	private Obj   currentProgram;

	private Struct currentType;

	private int constant;

	private Struct constantType;
	private Struct boolType=Tab.find("bool").getType();
	/*LOG MESSAGES*/
	public void report_error(String message, SyntaxNode info) {
		errorDetected =true;
		StringBuilder msg =new StringBuilder(message);
		int line=(info==null)?0:info.getLine();
		if (line!=0) {
			msg.append(" na liniji ").append(line);
		}
		log.error(msg.toString());
	}
	
	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg= new StringBuilder(message);
		int line=(info==null)?0:info.getLine();
		if(line!=0) {
			msg.append(" na liniji ").append(line);
		}
		log.info(msg.toString());
	}
	
	public boolean passed() {
		return !errorDetected;
	}
	
	/*SEMANTIC PASS CODE*/
	@Override
	public void visit(ProgramName programName) {
	   currentProgram = Tab.insert(Obj.Prog, programName.getI1(), Tab.noType);
		Tab.openScope();
	}
	
	@Override
	public void visit(Program program) {
		Tab.chainLocalSymbols(currentProgram);
		Tab.closeScope();
	}
	
	@Override 
	public void visit(ConDecl conDecl) {
		Obj conObj=Tab.find(conDecl.getI1());
		if(conObj!=Tab.noObj) {
			report_error("Dvostruka definicija konstante: "+conDecl.getI1(),conDecl);
		}
		else {
			if(constantType.assignableTo(currentType)){
				conObj=Tab.insert(Obj.Con,conDecl.getI1(), currentType);
				conObj.setAdr(constant);
			}
			else {
				report_error("Neadekvatna dodela konstanti: "+conDecl.getI1(),conDecl);
			}
		}
	}
	
	@Override
	public void visit(Constant_n constant_n) {
		constant =constant_n.getN1();
		constantType=Tab.intType;
		
	}
	
	@Override
	public void visit(Constant_c constant_c) {
		constant =constant_c.getC1();
		constantType=Tab.charType;
	}
	
	@Override
	public void visit(Constant_b constant_b) {
		constant =constant_b.getB1();
		constantType=boolType;
	}
	
	@Override
	public void visit(Type type) {
		Obj typeObj=Tab.find(type.getI1());
		if(typeObj == Tab.noObj) {
			report_error("Nepostojeci tip podatka: "+type.getI1(),type);
			currentType=Tab.noType;
		}
		else if(typeObj.getKind()!=Obj.Type) {
			report_error("Neadekvatan tip podatka: "+type.getI1(),type);
			currentType=Tab.noType;
		}
		else {
			currentType=typeObj.getType();
		}
	}
	
}
