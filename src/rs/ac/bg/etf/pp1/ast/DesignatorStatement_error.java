// generated with ast extension for cup
// version 0.8
// 13/8/2025 0:10:55


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatement_error extends DesignatorStatement {

    public DesignatorStatement_error () {
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
        buffer.append("DesignatorStatement_error(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatement_error]");
        return buffer.toString();
    }
}
