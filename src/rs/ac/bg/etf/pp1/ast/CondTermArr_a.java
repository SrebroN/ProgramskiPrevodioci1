// generated with ast extension for cup
// version 0.8
// 22/7/2025 16:42:39


package rs.ac.bg.etf.pp1.ast;

public class CondTermArr_a extends CondTermArr {

    private CondTermArr CondTermArr;
    private CondTerm CondTerm;

    public CondTermArr_a (CondTermArr CondTermArr, CondTerm CondTerm) {
        this.CondTermArr=CondTermArr;
        if(CondTermArr!=null) CondTermArr.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public CondTermArr getCondTermArr() {
        return CondTermArr;
    }

    public void setCondTermArr(CondTermArr CondTermArr) {
        this.CondTermArr=CondTermArr;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTermArr!=null) CondTermArr.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermArr!=null) CondTermArr.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermArr!=null) CondTermArr.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermArr_a(\n");

        if(CondTermArr!=null)
            buffer.append(CondTermArr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermArr_a]");
        return buffer.toString();
    }
}
