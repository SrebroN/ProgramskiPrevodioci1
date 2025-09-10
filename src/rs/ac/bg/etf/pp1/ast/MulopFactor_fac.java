// generated with ast extension for cup
// version 0.8
// 10/8/2025 12:17:47


package rs.ac.bg.etf.pp1.ast;

public class MulopFactor_fac extends MulopFactor {

    private FactorNeg FactorNeg;

    public MulopFactor_fac (FactorNeg FactorNeg) {
        this.FactorNeg=FactorNeg;
        if(FactorNeg!=null) FactorNeg.setParent(this);
    }

    public FactorNeg getFactorNeg() {
        return FactorNeg;
    }

    public void setFactorNeg(FactorNeg FactorNeg) {
        this.FactorNeg=FactorNeg;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactorNeg!=null) FactorNeg.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorNeg!=null) FactorNeg.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorNeg!=null) FactorNeg.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopFactor_fac(\n");

        if(FactorNeg!=null)
            buffer.append(FactorNeg.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulopFactor_fac]");
        return buffer.toString();
    }
}
