// generated with ast extension for cup
// version 0.8
// 10/8/2025 12:17:47


package rs.ac.bg.etf.pp1.ast;

public class ConditionList_cond extends ConditionList {

    private CondList CondList;
    private DesignatorStatement DesignatorStatement;

    public ConditionList_cond (CondList CondList, DesignatorStatement DesignatorStatement) {
        this.CondList=CondList;
        if(CondList!=null) CondList.setParent(this);
        this.DesignatorStatement=DesignatorStatement;
        if(DesignatorStatement!=null) DesignatorStatement.setParent(this);
    }

    public CondList getCondList() {
        return CondList;
    }

    public void setCondList(CondList CondList) {
        this.CondList=CondList;
    }

    public DesignatorStatement getDesignatorStatement() {
        return DesignatorStatement;
    }

    public void setDesignatorStatement(DesignatorStatement DesignatorStatement) {
        this.DesignatorStatement=DesignatorStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondList!=null) CondList.accept(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondList!=null) CondList.traverseTopDown(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondList!=null) CondList.traverseBottomUp(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionList_cond(\n");

        if(CondList!=null)
            buffer.append(CondList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatement!=null)
            buffer.append(DesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionList_cond]");
        return buffer.toString();
    }
}
