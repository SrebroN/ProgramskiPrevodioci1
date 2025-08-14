// generated with ast extension for cup
// version 0.8
// 14/7/2025 14:16:26


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementList_dec extends DesignatorStatementList {

    public DesignatorStatementList_dec () {
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
        buffer.append("DesignatorStatementList_dec(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementList_dec]");
        return buffer.toString();
    }
}
