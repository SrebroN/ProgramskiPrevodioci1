package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;


public class ActParsCounter extends VisitorAdaptor {
	List<Struct> finalActParList;
	Stack<List<Struct>> actParList=new Stack<>();

	@Override 
	public void visit(ActParsListBegin actParsListBegin) {
		actParList.push(new ArrayList<>());
	}
	
	@Override
	public void visit(ActPars actPars) {
		actParList.peek().add(actPars.getExpr().struct);
	}
	
	@Override
	public void visit(ActParsList_par actParsList_par) {
		finalActParList=actParList.pop();
	}
	@Override
	public void visit(ActParsList_e actParsList_e) {
		finalActParList=actParList.pop();
	}
}
