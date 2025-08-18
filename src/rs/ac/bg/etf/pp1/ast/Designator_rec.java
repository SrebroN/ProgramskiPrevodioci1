// generated with ast extension for cup
// version 0.8
// 18/7/2025 14:21:48


package rs.ac.bg.etf.pp1.ast;

public class Designator_rec extends Designator {

    private DesignatorRecordName DesignatorRecordName;
    private DesignatorRecMore DesignatorRecMore;

    public Designator_rec (DesignatorRecordName DesignatorRecordName, DesignatorRecMore DesignatorRecMore) {
        this.DesignatorRecordName=DesignatorRecordName;
        if(DesignatorRecordName!=null) DesignatorRecordName.setParent(this);
        this.DesignatorRecMore=DesignatorRecMore;
        if(DesignatorRecMore!=null) DesignatorRecMore.setParent(this);
    }

    public DesignatorRecordName getDesignatorRecordName() {
        return DesignatorRecordName;
    }

    public void setDesignatorRecordName(DesignatorRecordName DesignatorRecordName) {
        this.DesignatorRecordName=DesignatorRecordName;
    }

    public DesignatorRecMore getDesignatorRecMore() {
        return DesignatorRecMore;
    }

    public void setDesignatorRecMore(DesignatorRecMore DesignatorRecMore) {
        this.DesignatorRecMore=DesignatorRecMore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorRecordName!=null) DesignatorRecordName.accept(visitor);
        if(DesignatorRecMore!=null) DesignatorRecMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorRecordName!=null) DesignatorRecordName.traverseTopDown(visitor);
        if(DesignatorRecMore!=null) DesignatorRecMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorRecordName!=null) DesignatorRecordName.traverseBottomUp(visitor);
        if(DesignatorRecMore!=null) DesignatorRecMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator_rec(\n");

        if(DesignatorRecordName!=null)
            buffer.append(DesignatorRecordName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorRecMore!=null)
            buffer.append(DesignatorRecMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator_rec]");
        return buffer.toString();
    }
}
