// generated with ast extension for cup
// version 0.8
// 10/8/2025 12:17:47


package rs.ac.bg.etf.pp1.ast;

public class ActParsMore_e extends ActParsMore {

    public ActParsMore_e () {
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
        buffer.append("ActParsMore_e(\n");

        buffer.append(tab);
        buffer.append(") [ActParsMore_e]");
        return buffer.toString();
    }
}
