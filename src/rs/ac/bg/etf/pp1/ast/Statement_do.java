// generated with ast extension for cup
// version 0.8
// 2/8/2025 20:47:24


package rs.ac.bg.etf.pp1.ast;

public class Statement_do extends Statement {

    private DoNonterm DoNonterm;
    private Statement Statement;
    private ConditionList ConditionList;

    public Statement_do (DoNonterm DoNonterm, Statement Statement, ConditionList ConditionList) {
        this.DoNonterm=DoNonterm;
        if(DoNonterm!=null) DoNonterm.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ConditionList=ConditionList;
        if(ConditionList!=null) ConditionList.setParent(this);
    }

    public DoNonterm getDoNonterm() {
        return DoNonterm;
    }

    public void setDoNonterm(DoNonterm DoNonterm) {
        this.DoNonterm=DoNonterm;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public ConditionList getConditionList() {
        return ConditionList;
    }

    public void setConditionList(ConditionList ConditionList) {
        this.ConditionList=ConditionList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DoNonterm!=null) DoNonterm.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(ConditionList!=null) ConditionList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoNonterm!=null) DoNonterm.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ConditionList!=null) ConditionList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoNonterm!=null) DoNonterm.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ConditionList!=null) ConditionList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_do(\n");

        if(DoNonterm!=null)
            buffer.append(DoNonterm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionList!=null)
            buffer.append(ConditionList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_do]");
        return buffer.toString();
    }
}
