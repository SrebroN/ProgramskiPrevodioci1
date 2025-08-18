// generated with ast extension for cup
// version 0.8
// 18/7/2025 14:21:48


package rs.ac.bg.etf.pp1.ast;

public class Designator_rec_elem extends Designator {

    private DesignatorArrayName DesignatorArrayName;
    private Expr Expr;
    private DesignatorRecMore DesignatorRecMore;

    public Designator_rec_elem (DesignatorArrayName DesignatorArrayName, Expr Expr, DesignatorRecMore DesignatorRecMore) {
        this.DesignatorArrayName=DesignatorArrayName;
        if(DesignatorArrayName!=null) DesignatorArrayName.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.DesignatorRecMore=DesignatorRecMore;
        if(DesignatorRecMore!=null) DesignatorRecMore.setParent(this);
    }

    public DesignatorArrayName getDesignatorArrayName() {
        return DesignatorArrayName;
    }

    public void setDesignatorArrayName(DesignatorArrayName DesignatorArrayName) {
        this.DesignatorArrayName=DesignatorArrayName;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
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
        if(DesignatorArrayName!=null) DesignatorArrayName.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(DesignatorRecMore!=null) DesignatorRecMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorArrayName!=null) DesignatorArrayName.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(DesignatorRecMore!=null) DesignatorRecMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorArrayName!=null) DesignatorArrayName.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(DesignatorRecMore!=null) DesignatorRecMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator_rec_elem(\n");

        if(DesignatorArrayName!=null)
            buffer.append(DesignatorArrayName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorRecMore!=null)
            buffer.append(DesignatorRecMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator_rec_elem]");
        return buffer.toString();
    }
}
