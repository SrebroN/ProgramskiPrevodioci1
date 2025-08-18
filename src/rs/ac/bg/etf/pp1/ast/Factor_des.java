// generated with ast extension for cup
// version 0.8
// 18/7/2025 14:21:48


package rs.ac.bg.etf.pp1.ast;

public class Factor_des extends Factor {

    private Designator Designator;
    private FactorAct FactorAct;

    public Factor_des (Designator Designator, FactorAct FactorAct) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.FactorAct=FactorAct;
        if(FactorAct!=null) FactorAct.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public FactorAct getFactorAct() {
        return FactorAct;
    }

    public void setFactorAct(FactorAct FactorAct) {
        this.FactorAct=FactorAct;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(FactorAct!=null) FactorAct.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(FactorAct!=null) FactorAct.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(FactorAct!=null) FactorAct.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factor_des(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorAct!=null)
            buffer.append(FactorAct.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factor_des]");
        return buffer.toString();
    }
}
