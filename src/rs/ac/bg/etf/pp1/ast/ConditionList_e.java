// generated with ast extension for cup
// version 0.8
// 18/7/2025 14:47:0


package rs.ac.bg.etf.pp1.ast;

public class ConditionList_e extends ConditionList {

    public ConditionList_e () {
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
        buffer.append("ConditionList_e(\n");

        buffer.append(tab);
        buffer.append(") [ConditionList_e]");
        return buffer.toString();
    }
}
