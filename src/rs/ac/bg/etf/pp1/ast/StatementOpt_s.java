// generated with ast extension for cup
// version 0.8
// 22/7/2025 16:42:39


package rs.ac.bg.etf.pp1.ast;

public class StatementOpt_s extends StatementOpt {

    private StatementOpt StatementOpt;
    private Statement Statement;

    public StatementOpt_s (StatementOpt StatementOpt, Statement Statement) {
        this.StatementOpt=StatementOpt;
        if(StatementOpt!=null) StatementOpt.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public StatementOpt getStatementOpt() {
        return StatementOpt;
    }

    public void setStatementOpt(StatementOpt StatementOpt) {
        this.StatementOpt=StatementOpt;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementOpt!=null) StatementOpt.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementOpt!=null) StatementOpt.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementOpt!=null) StatementOpt.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementOpt_s(\n");

        if(StatementOpt!=null)
            buffer.append(StatementOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementOpt_s]");
        return buffer.toString();
    }
}
