// generated with ast extension for cup
// version 0.8
// 18/7/2025 14:21:48


package rs.ac.bg.etf.pp1.ast;

public class Factor_new extends Factor {

    private Type Type;
    private FactorExprPars FactorExprPars;

    public Factor_new (Type Type, FactorExprPars FactorExprPars) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FactorExprPars=FactorExprPars;
        if(FactorExprPars!=null) FactorExprPars.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FactorExprPars getFactorExprPars() {
        return FactorExprPars;
    }

    public void setFactorExprPars(FactorExprPars FactorExprPars) {
        this.FactorExprPars=FactorExprPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FactorExprPars!=null) FactorExprPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FactorExprPars!=null) FactorExprPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FactorExprPars!=null) FactorExprPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factor_new(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorExprPars!=null)
            buffer.append(FactorExprPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factor_new]");
        return buffer.toString();
    }
}
