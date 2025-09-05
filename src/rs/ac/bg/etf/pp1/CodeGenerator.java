package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

public class CodeGenerator extends VisitorAdaptor {

	
	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}
	
	@Override
	public void visit(MethodSignAndName_Void methodSignAndName_Void) {
		Code.put(Code.enter);
		Code.put(methodSignAndName_Void.obj.getLevel());
		Code.put(methodSignAndName_Void.obj.getLocalSymbols().size());
	}
	@Override
	public void visit(MethodSignAndName_Type methodSignAndName_Type) {
		Code.put(Code.enter);
		Code.put(methodSignAndName_Type.obj.getLevel());
		Code.put(methodSignAndName_Type.obj.getLocalSymbols().size());
	}
	
	@Override
	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(Statement_pr statement_pr) {
		Code.loadConst(0);
		if(statement_pr.getExpr().struct.equals(Tab.charType)) {
			Code.put(Code.bprint);
		}
		else {
			Code.put(Code.print);
		}
	}
	
	@Override
	public void visit(AddOpTerm_op addOpTerm_op) {
		if (addOpTerm_op.getAddop() instanceof Addop_p) {
			Code.put(Code.add);
		}
		else if(addOpTerm_op.getAddop() instanceof Addop_m) {
			Code.put(Code.sub);
		}
	}
	
	@Override
	public void visit(MulopFactor_mul mulopFactor_mul) {
		if (mulopFactor_mul.getMulop() instanceof Mulop_m) {
			Code.put(Code.mul);
		}
		else if(mulopFactor_mul.getMulop() instanceof Mulop_d) {
			Code.put(Code.div);
		}
		else {
			Code.put(Code.rem);
		}
	}
	@Override
	public void visit(Factor_des factor_des) {
		Code.load(factor_des.getDesignator().obj);
	}
	@Override
	public void visit(Factor_num factor_num) {
		Code.loadConst(factor_num.getN1());
	}
	@Override
	public void visit(Factor_char Factor_char) {
		Code.loadConst(Factor_char.getC1());
	}
	@Override
	public void visit(Factor_bool Factor_bool) {
		Code.loadConst(Factor_bool.getB1());
	}

	@Override
	public void visit(Factor_newexpr factor_newexpr) {
		Code.put(Code.newarray);
		if(factor_newexpr.getType().struct.equals(Tab.charType)) {
			Code.put(0);
		}
		else {
			Code.put(1);
		}
	}

	@Override
	public void visit(DesignatorArrayName designatorArrayName) {
		Code.load(designatorArrayName.obj);
	}
	@Override
	public void visit(DesignatorStatement_assigexpr designatorStatement_assigexpr) {
		Code.store(designatorStatement_assigexpr.getDesignator().obj);
	}
}
