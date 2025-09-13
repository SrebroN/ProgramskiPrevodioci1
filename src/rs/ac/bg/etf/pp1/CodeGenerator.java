package rs.ac.bg.etf.pp1;

import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private final Struct setType=Tab.find("set").getType();
	private int mainPc;

	public int getMainPc() {
		return mainPc;
	}

	public void initMethods() {
		Obj ordMeth=Tab.find("ord");
		Obj charMeth=Tab.find("chr");
		ordMeth.setAdr(Code.pc);
		charMeth.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		Obj lenMeth =Tab.find("len");
		lenMeth.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.arraylength);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		int offset1;
		Obj addMeth=Tab.find("add"); //add(set skup,int a)
		addMeth.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(2);
		Code.put(2);
		//provera da li je set pun//a,adr
		Code.put(Code.load_1);
		Code.put(Code.load_n);
		Code.put(Code.dup);			//a,adr,adr
		Code.loadConst(0);			//a,adr,adr,0
		Code.put(Code.aload);		//a,adr,currNumb
		Code.put(Code.dup2);		//a,adr,currNumb,adr,currNumbr
		Code.put(Code.dup_x1);		//a,adr,currNumb,currNumbr,adr,currNumbr
		Code.put(Code.pop);			//a,adr,currNumb,currNumbr,adr
		Code.put(Code.arraylength);	//a,adr,currNumb,currNumbr,arrLen
		Code.loadConst(1);			
		Code.put(Code.sub);			//a,adr,curNumb,currNUmb,arrLen-1
		Code.putFalseJump(Code.ne, Code.pc+56);//a,adr,currNumb
		//Ako je popunjen set preskaci sledeci kod:
									//a,adr,currNumb
		Code.put(Code.pop);			//,a,adr
		Code.put(Code.dup_x1);		//,adr,a,adr
		Code.loadConst(0);			//,adr,a,adr,i=0
		//skok3
		offset1=Code.pc;
		Code.loadConst(1);			//adr,a,adr,i,1
		Code.put(Code.add);			//adr,a,adr,i++
		Code.put(Code.dup_x2);		//,adr,i,a,adr,i
		Code.put(Code.aload);		//,adr,i,a,set[i]
		Code.put(Code.dup2);		//,adr,i,a,set[i],a,set[i]
		Code.putFalseJump(Code.ne, Code.pc+44);//vrednost vec postoji, preskaci
									//,adr,i,a,set[i]
		Code.put(Code.pop);			//,adr,i,a,
		Code.put(Code.dup_x2);		//,a,adr,i,a,
		Code.put(Code.pop);			//,a,adr,i,
		Code.put(Code.dup_x1);		//a,i,adr,i,
		Code.put(Code.dup_x1);		//a,i,i,adr,i,
		Code.put(Code.pop);			//a,i,i,adr,
		Code.put(Code.dup_x1);		//a,i,adr,i,adr
		Code.loadConst(0); 			//a,i,adr,i,adr,0
		Code.put(Code.aload);		//a,i,adr,i,currnumb  
		Code.loadConst(1);
		Code.put(Code.add);
		Code.putFalseJump(Code.ne, Code.pc+9);
									//a,i,adr, 
		Code.put(Code.dup_x2);		//adr,a,i,adr
		Code.put(Code.dup_x1);		//adr,a,adr,i,adr
		Code.put(Code.pop);			//adr,a,adr,i
		Code.putJump(offset1);
									//a,i,adr ->i,a,adr
		Code.put(Code.dup_x2);		//adr,a,i,adr
		Code.put(Code.pop);			//adr,a,i
		Code.put(Code.dup_x1);		//adr,i,a,i
		Code.put(Code.pop);			//adr,i,a
		Code.put(Code.dup_x2);		//a,adr,i,a
		Code.put(Code.pop);			//a,adr,i
		Code.put(Code.dup_x2);		//i,a,adr,i
		Code.put(Code.pop);			//i,a,adr		
		
		Code.put(Code.dup_x2);		//,adr,i,a,adr,
		Code.put(Code.dup_x2);		//,adr,adr,i,a,adr,
		Code.put(Code.pop);			//,adr,adr,i,a,
		Code.put(Code.astore);		//,adr
		Code.put(Code.dup);			//,adr,adr,
		Code.loadConst(0); 			//,adr,adr,0
		Code.put(Code.dup_x1);		//,adr,0,adr,0
		Code.put(Code.aload);		//,adr,0,currnumber
		Code.loadConst(1); 			//,adr,0,currNumber,1
		Code.put(Code.add); 		//,adr,0,currNumber+1
		Code.put(Code.astore);		//
		Code.put(Code.exit);
		Code.put(Code.return_);
		Code.put(Code.pop);//skok2
		Code.put(Code.pop);//skok1
		Code.put(Code.pop);
		Code.put(Code.pop);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		Obj addAllMeth=Tab.find("addAll"); //add(set skup,int niz[])
		int offset2;
		addAllMeth.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(2);
		Code.put(2);
		Code.put(Code.load_1);
		Code.put(Code.load_n); //niz,adr     niz[i],adr
		Code.put(Code.dup_x1);			//adr,niz,adr
		Code.put(Code.pop);				//adr,niz
		Code.put(Code.dup);				//adr,niz,niz
		Code.put(Code.arraylength);		//adr,niz,len(niz)
		Code.loadConst(0);				//adr,niz,len(niz),0
		//pocetak petlje:				//adr,niz,len(niz),i
		offset2=Code.pc;
		Code.put(Code.dup_x1);			//adr,niz,i,len(niz),0
		Code.putFalseJump(Code.ne, Code.pc+29);
										//adr,niz,i
		Code.put(Code.dup_x2);			//i,adr,niz,i
		Code.put(Code.dup2);			//i,adr,niz,i,niz,i
		Code.put(Code.aload);			//i,adr,niz,i,niz[i]
		Code.put(Code.dup_x2);			//i,adr,niz[i],niz,i,niz[i]
		Code.put(Code.pop);				//i,adr,niz[i],niz,i
		Code.put(Code.pop);				//i,adr,niz[i],niz,
		Code.put(Code.dup_x2);			//i,niz,adr,niz[i],niz,
		Code.put(Code.pop);				//i,niz,adr,niz[i]
		Code.put(Code.dup2);			//i,niz,adr,niz[i],adr,niz[i],
	//	Code.put(Code.pop);				//i,niz,adr,niz[i],adr,
		Code.put(Code.call);			
		Code.put2(addMeth.getAdr()-Code.pc+1);
										//i,niz,adr,niz[i],
		Code.put(Code.pop);				//i,niz,adr,
		Code.put(Code.dup_x2);			//adr,i,niz,adr,
		Code.put(Code.pop);				//adr,i,niz,
		Code.put(Code.dup_x1);			//adr,niz,i,niz,
		Code.put(Code.arraylength);		//adr,niz,i,len(niz)
		Code.put(Code.dup_x1);			//adr,niz,len(niz),i,len(niz)
		Code.put(Code.pop);				//adr,niz,len(niz),i
		Code.loadConst(1);				//adr,niz,len(niz),i,1
		Code.put(Code.add);				//adr,niz,len(niz),i++
		Code.put(Code.dup2);			//adr,niz,len(niz),i,len(niz),i,
		Code.putFalseJump(Code.eq, offset2);
										//adr,niz,len(niz),i
		Code.put(Code.pop);
		Code.put(Code.pop);
		Code.put(Code.pop);
		Code.put(Code.pop);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		
	}
	
	CodeGenerator(){
		this.initMethods();
	}
	// ---------------------METHOD---------------------
	@Override
	public void visit(MethodSignAndName_Void methodSignAndName_Void) {
		methodSignAndName_Void.obj.setAdr(Code.pc);
		if (methodSignAndName_Void.getI1().equalsIgnoreCase("main")) {
			this.mainPc = Code.pc;
		}
		Code.put(Code.enter);
		Code.put(methodSignAndName_Void.obj.getLevel());
		Code.put(methodSignAndName_Void.obj.getLocalSymbols().size());
	}

	@Override
	public void visit(MethodSignAndName_Type methodSignAndName_Type) {
		methodSignAndName_Type.obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(methodSignAndName_Type.obj.getLevel());
		Code.put(methodSignAndName_Type.obj.getLocalSymbols().size());
	}

	@Override
	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	// ---------------------STATEMENTS---------------------
	@Override
	public void visit(Statement_pr statement_pr) {
		if(statement_pr.getExpr().struct.equals(setType)) {
			int label;
								//adr
			Code.put(Code.dup);			//adr,adr
			Code.loadConst(0); 			//adr,adr,0
			Code.put(Code.aload);		//adr,currNum
			Code.put(Code.dup2);		//adr,currNum,adr,currNUmb
			Code.loadConst(0);			//adr,currNumb,adr,currNumb,0
			Code.putFalseJump(Code.ne, Code.pc+31);
										//adr,curNumb,adr
			Code.loadConst(0);			//adr,currNumb,adr,i
			label=Code.pc;							//adr,curN,adr,i,
			Code.loadConst(1); 			//adr,curN,adr,i,1
			Code.put(Code.add);			//adr,curN,adr,i++
			Code.put(Code.dup_x2);		//adr,i,curN,adr,i
			Code.put(Code.aload);		//adr,i,curN,set[i]
			Code.loadConst(1); 			//adr,i,curN,set[i],1
			Code.put(Code.print); 		//adr,i,curN,
			Code.loadConst(' ');
			Code.loadConst(0);
			Code.put(Code.bprint);
			Code.put(Code.dup2);		//adr,i,curN,i,curN,
			Code.putFalseJump(Code.ne, Code.pc+13);//adr,i,curN,
			
			Code.put(Code.dup_x2);		//curN,adr,i,curN,
			Code.put(Code.pop);			//curN,adr,i,
			Code.put(Code.dup_x1);		//curN,i,adr,i,
			Code.put(Code.pop);			//curN,i,adr
			Code.put(Code.dup_x2);		//adr,curN,i,adr
			Code.put(Code.dup_x1);		//adr,cuN,adr,i,adr
			Code.put(Code.pop);			//adr,cuN,adr,i
			Code.putJump(label);
			Code.put(Code.pop);
			Code.put(Code.pop);
			Code.put(Code.pop);
		}
		else if (statement_pr.getExpr().struct.equals(Tab.charType)) {
			Code.loadConst(0);
			Code.put(Code.bprint);
		} else {
			Code.loadConst(0);
			Code.put(Code.print);
		}
	}

	@Override
	public void visit(Statement_prnum statement_prnum) {
		if(statement_prnum.getExpr().struct.equals(setType)) {
			int label;
			Code.loadConst(' ');
			Code.loadConst(statement_prnum.getN2());
			Code.put(Code.bprint);
								//adr
			Code.put(Code.dup);			//adr,adr
			Code.loadConst(0); 			//adr,adr,0
			Code.put(Code.aload);		//adr,currNum
			Code.put(Code.dup2);		//adr,currNum,adr,currNUmb
			Code.loadConst(0);			//adr,currNumb,adr,currNumb,0
			Code.putFalseJump(Code.ne, Code.pc+31);
										//adr,curNumb,adr
			Code.loadConst(0);			//adr,currNumb,adr,i
			label=Code.pc;							//adr,curN,adr,i,
			Code.loadConst(1); 			//adr,curN,adr,i,1
			Code.put(Code.add);			//adr,curN,adr,i++
			Code.put(Code.dup_x2);		//adr,i,curN,adr,i
			Code.put(Code.aload);		//adr,i,curN,set[i]
			Code.loadConst(1); 			//adr,i,curN,set[i],1
			Code.put(Code.print); 		//adr,i,curN,
			Code.loadConst(' ');
			Code.loadConst(0);
			Code.put(Code.bprint);
			Code.put(Code.dup2);		//adr,i,curN,i,curN,
			Code.putFalseJump(Code.ne, Code.pc+13);//adr,i,curN,
			
			Code.put(Code.dup_x2);		//curN,adr,i,curN,
			Code.put(Code.pop);			//curN,adr,i,
			Code.put(Code.dup_x1);		//curN,i,adr,i,
			Code.put(Code.pop);			//curN,i,adr
			Code.put(Code.dup_x2);		//adr,curN,i,adr
			Code.put(Code.dup_x1);		//adr,cuN,adr,i,adr
			Code.put(Code.pop);			//adr,cuN,adr,i
			Code.putJump(label);
			Code.put(Code.pop);
			Code.put(Code.pop);
			Code.put(Code.pop);
		}
		else if (statement_prnum.getExpr().struct.equals(Tab.charType)) {
			Code.loadConst(statement_prnum.getN2());
			Code.put(Code.bprint);
		} else {
			Code.loadConst(statement_prnum.getN2());
			Code.put(Code.print);
		}
	}

	@Override
	public void visit(Statement_ret statement_ret) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(Statement_retexpr statement_retexpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(Statement_rd statement_rd) {
		if (statement_rd.getDesignator().obj.getType().equals(Tab.charType)) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}
		Code.store(statement_rd.getDesignator().obj);
	}
	private Stack<Integer> doBegin = new Stack<>();
	private Stack<List<Integer>> breakJump = new Stack<>();
	private Stack<List<Integer>> continueJumps = new Stack<>();
	@Override
	public void visit(DoNonterm DoNonterm) {
		doBegin.push(Code.pc);
		breakJump.push(new ArrayList<Integer>());
		continueJumps.push(new ArrayList<Integer>());
	}
	@Override
	public void visit(Statement_do statement_do) {
		Code.putJump(doBegin.pop());
		Code.fixup(skipThen.pop());
		while(!breakJump.peek().isEmpty())
			Code.fixup(breakJump.peek().remove(0));
		breakJump.pop();
	}
	
	@Override
	public void visit(Statement_br statement_br) {
		Code.putJump(0);
		breakJump.peek().add(Code.pc - 2);
	}
	
	@Override
	public void visit(Statement_cont statement_cont) {
		Code.putJump(0);
		continueJumps.peek().add(Code.pc - 2);
	}
	
	@Override
	public void visit(While while_) {
		while(!continueJumps.peek().isEmpty())
			Code.fixup(continueJumps.peek().remove(0));
		continueJumps.pop();
	}
	
	@Override
	public void visit(ConditionList_e conditionList_e) {//NE RADI, IMPLEMENTIRATI !!!!!!
		Code.putJump(doBegin.peek());
		skipThen.push(Code.pc);
		}
	
	// ---------------------CONDITIONS---------------------
	private Stack<Integer> skipCondFact = new Stack<>();
	private Stack<Integer> skipCond = new Stack<>();
	private Stack<Integer> skipThen= new Stack<>();
	private Stack<Integer> skipElse= new Stack<>();
	@Override
	public void visit(CondFact_single condFact_single) {
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, 0);// ako je netacno skace
		skipCondFact.push(Code.pc - 2);
	}

	@Override
	public void visit(CondFact_rel condFact_rel) {
		Code.putFalseJump(returnRelop(condFact_rel.getRelop()), 0);// ako je netacno skace
		skipCondFact.push(Code.pc - 2);
	}

	@Override
	public void visit(ConditionTerm conditionTerm) {
		Code.putJump(0);// tacno ide na then
		skipCond.push(Code.pc-2);
		while (!skipCondFact.empty()) {
			Code.fixup(skipCondFact.pop());
		}
	}

	@Override
	public void visit(CondList_cond condList_cond) {
		Code.putJump(0);// tacno ide na then
		skipThen.push(Code.pc-2);
		while (!skipCond.empty()) {
			Code.fixup(skipCond.pop());
		}
	}

	@Override
	public void visit(ElseStatement_E elseStatement_E) {
		Code.fixup(skipThen.pop());
	}
	
	@Override
	public void visit(Else else_) {
		Code.putJump(0);
		skipElse.push(Code.pc-2);
		Code.fixup(skipThen.pop());
	}
	
	@Override
	public void visit(ElseStatement_else elseStatement_else) {
		Code.fixup(skipElse.pop());
	}
	
	private int returnRelop(Relop relop) {
		if (relop instanceof Relop_eq) {
			return Code.eq;
		} else if (relop instanceof Relop_neq) {
			return Code.ne;
		} else if (relop instanceof Relop_gr) {
			return Code.gt;
		} else if (relop instanceof Relop_greq) {
			return Code.ge;
		} else if (relop instanceof Relop_l) {
			return Code.lt;
		} else {
			return Code.le;
		}
	}

	// ---------------------ADDOP---------------------
	@Override
	public void visit(AddOpTerm_op addOpTerm_op) {
		if (addOpTerm_op.getAddop() instanceof Addop_p) {
			Code.put(Code.add);
		} else if (addOpTerm_op.getAddop() instanceof Addop_m) {
			Code.put(Code.sub);
		}
	}

	// ---------------------MULOP---------------------
	@Override
	public void visit(MulopFactor_mul mulopFactor_mul) {
		if (mulopFactor_mul.getMulop() instanceof Mulop_m) {
			Code.put(Code.mul);
		} else if (mulopFactor_mul.getMulop() instanceof Mulop_d) {
			Code.put(Code.div);
		} else {
			Code.put(Code.rem);
		}
	}
	// ---------------------EXPR---------------------
	@Override
	public void visit(Expr_des expr_des) {

		Code.load(expr_des.getDesignator1().obj);  //stack: adr
		Code.put(Code.arraylength);					//stack: arrLen
		Code.loadConst(0); 							//arrLen,0
//		Code.load(expr_des.getDesignator1().obj);	//arrLen,0,adr
//		Code.loadConst(0);							//arrrLen,0,adr,i
//		Code.putFalseJump(Code.ne,Code.pc+35);		//arrLen,0
		
		//labela1:

		Code.load(expr_des.getDesignator1().obj);	//arrLen,0,adr
		Code.loadConst(0);							//arrLen,0,adr,i
		Code.put(Code.dup2);						//arrLen,0,adr,i,adr,i
		Code.put(Code.aload);						//arrLen,0,adr,i,niz[i]
		//poziv funkcije
		int offset = expr_des.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		//povratak iz funkcije		
												//arrLen,0,adr,i,foo(niz[i])
		Code.put(Code.dup_x2);					//arrLen,0,foo(niz[i]),adr,i,foo(niz[i])
		Code.put(Code.pop);						//arrLen,0,foo(niz[i]),adr,i,
		Code.loadConst(1);						//arrLen,0,foo(niz[i]),adr,i,1
		Code.put(Code.add);						//arrLen,0,foo(niz[i]),adr,i++
		Code.put(Code.dup);						//arrLen,0,foo(niz[i]),adr,i,i
		Code.load(expr_des.getDesignator1().obj); //arrLen,0,foo(niz[i]),adr,i,i,adr
		Code.put(Code.arraylength);				//arrLen,0,foo(niz[i]),adr,i,i,arrLen
		//skok na labelu1
		Code.putFalseJump(Code.eq,Code.pc-14);	//arrLen,0,foo(niz[i]),adr,i,
		//kraj mapa, sad ide sabiranje vrednosti
		Code.put(Code.dup_x1);					//arrLen,0,...foo(niz[i-1]),foo(niz[i]),i,adr,i
		Code.put(Code.pop);						//arrLen,0,...foo(niz[i-1]),foo(niz[i]),i,adr
		Code.put(Code.pop);						//arrLen,0,...foo(niz[i-1]),foo(niz[i]),i
		//labela2:
		Code.put(Code.dup_x2); 					//arrLen,0,...i,foo(niz[i-1]),foo(niz[i]),i
		Code.put(Code.pop);						//arrLen,0,...i,foo(niz[i-1]),foo(niz[i])
		Code.put(Code.add);						//arrLen,0,...i,foo(niz[i-1])+foo(niz[i])
		Code.put(Code.dup_x1);					//arrLen,0,...,foo(niz[i-1])+foo(niz[i]),i,foo(niz[i-1])+foo(niz[i])
		Code.put(Code.pop);						//arrLen,0,...,foo(niz[i-1])+foo(niz[i]),i
		Code.loadConst(1); 						//arrLen,0,...,foo(niz[i-1])+foo(niz[i]),i,1
		Code.put(Code.sub);						//arrLen,0,...,foo(niz[i-1])+foo(niz[i]),i--
		Code.put(Code.dup);						//arrLen,0,...,foo(niz[i-1])+foo(niz[i]),i,i
		Code.loadConst(0);						//arrLen,0,...,foo(niz[i-1])+foo(niz[i]),i,i,0
		//skok na labelu2
		Code.putFalseJump(Code.eq, Code.pc-9);//arrLen,0,...,foo(niz[i-1])+foo(niz[i]),i
												//arrLen,sum,i
		//izlazak iz petlje
		Code.put(Code.pop);						//arrLen,sum
		Code.put(Code.dup_x1);					//sum,arrLen,sum
		Code.put(Code.pop);						//sum,arrLen
		Code.put(Code.pop);						//sum
		
	}
	
	// ---------------------FACTOR---------------------
	@Override
	public void visit(FactorNeg_neg factorNeg_neg) {
		Code.put(Code.neg);
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
		if (factor_newexpr.getType().struct.equals(setType)) {
			Code.loadConst(1);// ...curr number of elements in the set
			Code.put(Code.add);
			Code.put(Code.newarray);
			Code.put(1);
			Code.put(Code.dup);
			Code.loadConst(0);
			Code.loadConst(0);
			Code.put(Code.astore);// set[0]=set.currentNumbers
		} else {
			Code.put(Code.newarray);
			if (factor_newexpr.getType().struct.equals(Tab.charType)) {
				Code.put(0);
			} else {
				Code.put(1);
			}
		}
	}

	@Override
	public void visit(Factor_meth factor_meth) {
		int offset = factor_meth.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
	}

	// ---------------------DESIGNATOR---------------------
	@Override
	public void visit(DesignatorArrayName designatorArrayName) {
		Code.load(designatorArrayName.obj);
	}

	// ---------------------DESIGNATOR STATEMENT---------------------
	@Override
	public void visit(DesignatorStatement_assigexpr designatorStatement_assigexpr) {
		Code.store(designatorStatement_assigexpr.getDesignator().obj);
	}

	@Override
	public void visit(DesignatorStatement_actpars designatorStatement_actpars) {
		int offset = designatorStatement_actpars.getDesignatorMeth().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		if (designatorStatement_actpars.getDesignatorMeth().obj.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
	}

	@Override
	public void visit(DesignatorStatement_inc designatorStatement_inc) {
		if (designatorStatement_inc.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(designatorStatement_inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(designatorStatement_inc.getDesignator().obj);
	}

	@Override
	public void visit(DesignatorStatement_dec designatorStatement_dec) {
		if (designatorStatement_dec.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(designatorStatement_dec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(designatorStatement_dec.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorStatement_assign designatorStatement_assign) {
		Code.load(designatorStatement_assign.getDesignator().obj);
		Code.load(designatorStatement_assign.getDesignator1().obj); 		//set0,set1
		Code.put(Code.dup_x1);								//set1,set0,set1
		Code.put(Code.dup);									//set1,set0,set1,set1
		Code.loadConst(0);									//set1,set0,set1,set1,0
		Code.put(Code.aload);								//set1,set0,set1,curN1
		Code.loadConst(0); 									//set1,set0,set1,curN1,0
		Code.put(Code.dup_x1);
		Code.putFalseJump(Code.ne,Code.pc+31);				//set1,set0,set1,i
		int offset=Code.pc;
		
		Code.loadConst(1);
		Code.put(Code.add);									//set1,set0,set1,i++
		
		Code.put(Code.dup2);								//set1,set0,set1,i,set1,i
		Code.put(Code.aload);								//set1,set0,set1,i,set1[i]
		Code.put(Code.dup_x2);								//set1,set0,set1[i],set1,i,set1[i]
		Code.put(Code.pop);									//set1,set0,set1[i],set1,i,
		Code.put(Code.dup_x2);								//set1,set0,i,set1[i],set1,i,
		Code.put(Code.pop);									//set1,set0,i,set1[i],set1
		Code.put(Code.dup_x2);								//set1,set0,set1,i,set1[i],set1
		Code.put(Code.pop);									//set1,set0,set1,i,set1[i],
		Code.load(designatorStatement_assign.getDesignator().obj);
															//set1,set0,set1,i,set1[i],set0
		Code.put(Code.dup_x1);								//set1,set0,set1,i,set0,set1[i],set0
		Code.put(Code.pop);									//set1,set0,set1,i,set0,set1[i],
		Code.put(Code.call);
		Code.put2(Tab.find("add").getAdr()-Code.pc+1); 		//set1,set0,set1,i
		
		Code.put(Code.dup2);								//set1,set0,set1,i,set1,i,
		Code.put(Code.pop);									//set1,set0,set1,i,set1,
		Code.loadConst(0); 									//set1,set0,set1,i,set1,0
		Code.put(Code.aload);								//set1,set0,set1,i,curN1
		Code.put(Code.dup_x1);								//set1,set0,set1,curN1,i,curN1
		Code.put(Code.pop);									//set1,set0,set1,curN1,i

		Code.put(Code.dup_x1);								//set1,set0,set1,i,curN1,i						
		Code.putFalseJump(Code.eq,offset);					//set1,set0,set1,i,
		//skok2
		Code.put(Code.pop);
		Code.put(Code.pop);
		Code.put(Code.pop);
		Code.put(Code.pop);
		//-------SET2:------
		Code.load(designatorStatement_assign.getDesignator().obj);
		Code.load(designatorStatement_assign.getDesignator2().obj);		//set0,set2
		Code.put(Code.dup_x1);								//set1,set0,set1
		Code.put(Code.dup);									//set1,set0,set1,set1
		Code.loadConst(0);									//set1,set0,set1,set1,0
		Code.put(Code.aload);								//set1,set0,set1,curN1
		Code.loadConst(0); 									//set1,set0,set1,curN1,0
		Code.put(Code.dup_x1);
		Code.putFalseJump(Code.ne,Code.pc+31);				//set1,set0,set1,i
		offset=Code.pc;
		
		Code.loadConst(1);
		Code.put(Code.add);									//set1,set0,set1,i++
		
		Code.put(Code.dup2);								//set1,set0,set1,i,set1,i
		Code.put(Code.aload);								//set1,set0,set1,i,set1[i]
		Code.put(Code.dup_x2);								//set1,set0,set1[i],set1,i,set1[i]
		Code.put(Code.pop);									//set1,set0,set1[i],set1,i,
		Code.put(Code.dup_x2);								//set1,set0,i,set1[i],set1,i,
		Code.put(Code.pop);									//set1,set0,i,set1[i],set1
		Code.put(Code.dup_x2);								//set1,set0,set1,i,set1[i],set1
		Code.put(Code.pop);									//set1,set0,set1,i,set1[i],
		Code.load(designatorStatement_assign.getDesignator().obj);
															//set1,set0,set1,i,set1[i],set0
		Code.put(Code.dup_x1);								//set1,set0,set1,i,set0,set1[i],set0
		Code.put(Code.pop);									//set1,set0,set1,i,set0,set1[i],
		Code.put(Code.call);
		Code.put2(Tab.find("add").getAdr()-Code.pc+1); 		//set1,set0,set1,i
		
		Code.put(Code.dup2);								//set1,set0,set1,i,set1,i,
		Code.put(Code.pop);									//set1,set0,set1,i,set1,
		Code.loadConst(0); 									//set1,set0,set1,i,set1,0
		Code.put(Code.aload);								//set1,set0,set1,i,curN1
		Code.put(Code.dup_x1);								//set1,set0,set1,curN1,i,curN1
		Code.put(Code.pop);									//set1,set0,set1,curN1,i

		Code.put(Code.dup_x1);								//set1,set0,set1,i,curN1,i						
		Code.putFalseJump(Code.eq,offset);					//set1,set0,set1,i,
		//skok2
		Code.put(Code.pop);
		Code.put(Code.pop);
		Code.put(Code.pop);
		Code.put(Code.pop);
		
	}
	
}
