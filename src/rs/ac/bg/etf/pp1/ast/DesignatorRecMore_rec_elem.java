// generated with ast extension for cup
// version 0.8
// 18/7/2025 14:21:48


package rs.ac.bg.etf.pp1.ast;

public class DesignatorRecMore_rec_elem extends DesignatorRecMore {

    private DesignatorRecMore DesignatorRecMore;
    private DesignatorRecordArrayName DesignatorRecordArrayName;
    private Expr Expr;

    public DesignatorRecMore_rec_elem (DesignatorRecMore DesignatorRecMore, DesignatorRecordArrayName DesignatorRecordArrayName, Expr Expr) {
        this.DesignatorRecMore=DesignatorRecMore;
        if(DesignatorRecMore!=null) DesignatorRecMore.setParent(this);
        this.DesignatorRecordArrayName=DesignatorRecordArrayName;
        if(DesignatorRecordArrayName!=null) DesignatorRecordArrayName.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorRecMore getDesignatorRecMore() {
        return DesignatorRecMore;
    }

    public void setDesignatorRecMore(DesignatorRecMore DesignatorRecMore) {
        this.DesignatorRecMore=DesignatorRecMore;
    }

    public DesignatorRecordArrayName getDesignatorRecordArrayName() {
        return DesignatorRecordArrayName;
    }

    public void setDesignatorRecordArrayName(DesignatorRecordArrayName DesignatorRecordArrayName) {
        this.DesignatorRecordArrayName=DesignatorRecordArrayName;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorRecMore!=null) DesignatorRecMore.accept(visitor);
        if(DesignatorRecordArrayName!=null) DesignatorRecordArrayName.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorRecMore!=null) DesignatorRecMore.traverseTopDown(visitor);
        if(DesignatorRecordArrayName!=null) DesignatorRecordArrayName.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorRecMore!=null) DesignatorRecMore.traverseBottomUp(visitor);
        if(DesignatorRecordArrayName!=null) DesignatorRecordArrayName.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorRecMore_rec_elem(\n");

        if(DesignatorRecMore!=null)
            buffer.append(DesignatorRecMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorRecordArrayName!=null)
            buffer.append(DesignatorRecordArrayName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorRecMore_rec_elem]");
        return buffer.toString();
    }
}
