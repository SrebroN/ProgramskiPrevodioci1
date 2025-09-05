package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;

public class Compiler {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}

	public static void main(String[] args) throws Exception {

		Logger log = Logger.getLogger(Compiler.class);

		Reader br = null;
		try {
			File sourceCode = new File("test/program.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());

			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			/*Formiranje AST*/
			MJParser p = new MJParser(lexer);
			Symbol s = p.parse(); // pocetak parsiranja

			Program prog = (Program) (s.value);
			/*Ispis AST*/
			log.info(prog.toString(""));
			log.info("===================================");

			/*Inicijalizacija tebele simbola*/
			Tab.init();
			//Bool
			Struct boolType=new Struct(Struct.Bool);
			Obj boolObj =Tab.insert(Obj.Type, "bool", boolType);
			boolObj.setAdr(-1);
			boolObj.setLevel(-1);
			//SET
			Struct setType=new Struct(Struct.Enum);
		//	 Tab.insert(Obj.Type, "set", setType);
			Obj setObj = Tab.insert(Obj.Type,"set", setType);
			setObj.setAdr(-1);
			setObj.setLevel(-1);
			//add(a,b);
			Scope universe = Tab.currentScope;
			universe.addToLocals(Tab.ordObj = new Obj(Obj.Meth, "add", Tab.noType, 0, 2));
			{
				Tab.openScope();
				Tab.currentScope.addToLocals(new Obj(Obj.Var, "a", setType, 0, 1));
				Tab.currentScope.addToLocals(new Obj(Obj.Var, "b", Tab.intType, 0, 1));
				Tab.ordObj.setLocals(Tab.currentScope.getLocals());
				for(Obj local :Tab.ordObj.getLocalSymbols()) {
					local.setFpPos(1);
				}
				Tab.closeScope();
			} 
			//addAll(a,b);
			universe.addToLocals(Tab.ordObj = new Obj(Obj.Meth, "addAll", Tab.noType, 0, 2));
			{
				Tab.openScope();
				Tab.currentScope.addToLocals(new Obj(Obj.Var, "a", setType, 0, 1));
				Tab.currentScope.addToLocals(new Obj(Obj.Var, "b", new Struct(Struct.Array, Tab.intType), 0, 1));
				Tab.ordObj.setLocals(Tab.currentScope.getLocals());
				for(Obj local :Tab.ordObj.getLocalSymbols()) {
					local.setFpPos(1);
				}
				Tab.closeScope();
			} 
			String meths[]={"chr","ord","len"};
			for(String currMeth : meths) {
				for(Obj local:Tab.find(currMeth).getLocalSymbols()) {
					local.setFpPos(1);
				}
			}
				
			/*Semanticka analiza*/
			SemanticAnalyzer sa= new SemanticAnalyzer();
			prog.traverseBottomUp(sa);
			
			
			/*Ispis tabele simbola*/
			log.info("===================================");
			Tab.dump();
			
			if (!p.errorDetected && sa.passed()) {
				//Generisanje koda
				File objFile=new File("test/program.obj");
				if (objFile.exists())objFile.delete();
				CodeGenerator cg=new CodeGenerator();
				prog.traverseBottomUp(cg);
				Code.dataSize=sa.nVars;
				Code.mainPc=cg.getMainPc();
				Code.write(new FileOutputStream(objFile));
				
				log.info("Parsiranje uspesno zavrseno!");
			} else {
				log.error("Parsiranje NIJE uspesno zavrseno");
			}
			// ispis prepoznatih programskih konstrukcija
			// RuleVisitor v = new RuleVisitor();
			// prog.traverseBottomUp(v);

			// log.info(" Print count calls = " + v.printCallCount);

			// log.info(" Deklarisanih promenljivih ima = " + v.varDeclCount);

		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e1) {

					log.error(e1.getMessage(), e1);
				}
		}

	}

}
