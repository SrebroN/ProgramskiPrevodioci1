// generated with ast extension for cup
// version 0.8
// 10/8/2025 12:17:47


package rs.ac.bg.etf.pp1.ast;

public class ConditionList_con extends ConditionList {

    private CondList CondList;

    public ConditionList_con (CondList CondList) {
        this.CondList=CondList;
        if(CondList!=null) CondList.setParent(this);
    }

    public CondList getCondList() {
        return CondList;
    }

    public void setCondList(CondList CondList) {
        this.CondList=CondList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondList!=null) CondList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondList!=null) CondList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondList!=null) CondList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionList_con(\n");

        if(CondList!=null)
            buffer.append(CondList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionList_con]");
        return buffer.toString();
    }
}
