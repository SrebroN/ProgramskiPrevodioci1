// generated with ast extension for cup
// version 0.8
// 6/7/2025 19:6:28


package src.rs.ac.bg.etf.pp1.ast;

public class ConDeclMore_e extends ConDeclMore {

    public ConDeclMore_e () {
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
        buffer.append("ConDeclMore_e(\n");

        buffer.append(tab);
        buffer.append(") [ConDeclMore_e]");
        return buffer.toString();
    }
}
