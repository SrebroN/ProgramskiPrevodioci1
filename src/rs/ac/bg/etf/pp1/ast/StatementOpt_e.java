// generated with ast extension for cup
// version 0.8
// 27/7/2025 19:31:49


package rs.ac.bg.etf.pp1.ast;

public class StatementOpt_e extends StatementOpt {

    public StatementOpt_e () {
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
        buffer.append("StatementOpt_e(\n");

        buffer.append(tab);
        buffer.append(") [StatementOpt_e]");
        return buffer.toString();
    }
}
