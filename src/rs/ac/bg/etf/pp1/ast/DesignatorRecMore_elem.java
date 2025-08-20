// generated with ast extension for cup
// version 0.8
// 18/7/2025 14:47:0


package rs.ac.bg.etf.pp1.ast;

public class DesignatorRecMore_elem extends DesignatorRecMore {

    private DesignatorRecordArrayName DesignatorRecordArrayName;
    private Expr Expr;

    public DesignatorRecMore_elem (DesignatorRecordArrayName DesignatorRecordArrayName, Expr Expr) {
        this.DesignatorRecordArrayName=DesignatorRecordArrayName;
        if(DesignatorRecordArrayName!=null) DesignatorRecordArrayName.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
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
        if(DesignatorRecordArrayName!=null) DesignatorRecordArrayName.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorRecordArrayName!=null) DesignatorRecordArrayName.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorRecordArrayName!=null) DesignatorRecordArrayName.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorRecMore_elem(\n");

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
        buffer.append(") [DesignatorRecMore_elem]");
        return buffer.toString();
    }
}
