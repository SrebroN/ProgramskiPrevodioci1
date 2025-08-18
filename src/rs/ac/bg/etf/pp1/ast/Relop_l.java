// generated with ast extension for cup
// version 0.8
// 18/7/2025 14:21:48


package rs.ac.bg.etf.pp1.ast;

public class Relop_l extends Relop {

    public Relop_l () {
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
        buffer.append("Relop_l(\n");

        buffer.append(tab);
        buffer.append(") [Relop_l]");
        return buffer.toString();
    }
}
