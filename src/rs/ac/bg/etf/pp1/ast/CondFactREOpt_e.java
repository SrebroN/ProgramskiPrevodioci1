// generated with ast extension for cup
// version 0.8
// 14/7/2025 14:16:26


package rs.ac.bg.etf.pp1.ast;

public class CondFactREOpt_e extends CondFactREOpt {

    public CondFactREOpt_e () {
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
        buffer.append("CondFactREOpt_e(\n");

        buffer.append(tab);
        buffer.append(") [CondFactREOpt_e]");
        return buffer.toString();
    }
}
