// generated with ast extension for cup
// version 0.8
// 18/7/2025 14:47:0


package rs.ac.bg.etf.pp1.ast;

public class Mulop_d extends Mulop {

    public Mulop_d () {
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
        buffer.append("Mulop_d(\n");

        buffer.append(tab);
        buffer.append(") [Mulop_d]");
        return buffer.toString();
    }
}
