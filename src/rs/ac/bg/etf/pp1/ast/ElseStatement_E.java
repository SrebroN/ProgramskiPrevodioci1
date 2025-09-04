// generated with ast extension for cup
// version 0.8
// 2/8/2025 20:47:24


package rs.ac.bg.etf.pp1.ast;

public class ElseStatement_E extends ElseStatement {

    public ElseStatement_E () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ElseStatement_E(\n");

        buffer.append(tab);
        buffer.append(") [ElseStatement_E]");
        return buffer.toString();
    }
}
