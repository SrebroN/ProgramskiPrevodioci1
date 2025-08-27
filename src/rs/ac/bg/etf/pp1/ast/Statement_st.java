// generated with ast extension for cup
// version 0.8
// 27/7/2025 19:31:50


package rs.ac.bg.etf.pp1.ast;

public class Statement_st extends Statement {

    private StatementOpt StatementOpt;

    public Statement_st (StatementOpt StatementOpt) {
        this.StatementOpt=StatementOpt;
        if(StatementOpt!=null) StatementOpt.setParent(this);
    }

    public StatementOpt getStatementOpt() {
        return StatementOpt;
    }

    public void setStatementOpt(StatementOpt StatementOpt) {
        this.StatementOpt=StatementOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementOpt!=null) StatementOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementOpt!=null) StatementOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementOpt!=null) StatementOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_st(\n");

        if(StatementOpt!=null)
            buffer.append(StatementOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_st]");
        return buffer.toString();
    }
}
