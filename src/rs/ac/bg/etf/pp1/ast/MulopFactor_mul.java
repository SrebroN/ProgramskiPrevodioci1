// generated with ast extension for cup
// version 0.8
// 10/8/2025 12:17:47


package rs.ac.bg.etf.pp1.ast;

public class MulopFactor_mul extends MulopFactor {

    private MulopFactor MulopFactor;
    private Mulop Mulop;
    private FactorNeg FactorNeg;

    public MulopFactor_mul (MulopFactor MulopFactor, Mulop Mulop, FactorNeg FactorNeg) {
        this.MulopFactor=MulopFactor;
        if(MulopFactor!=null) MulopFactor.setParent(this);
        this.Mulop=Mulop;
        if(Mulop!=null) Mulop.setParent(this);
        this.FactorNeg=FactorNeg;
        if(FactorNeg!=null) FactorNeg.setParent(this);
    }

    public MulopFactor getMulopFactor() {
        return MulopFactor;
    }

    public void setMulopFactor(MulopFactor MulopFactor) {
        this.MulopFactor=MulopFactor;
    }

    public Mulop getMulop() {
        return Mulop;
    }

    public void setMulop(Mulop Mulop) {
        this.Mulop=Mulop;
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
        if(MulopFactor!=null) MulopFactor.accept(visitor);
        if(Mulop!=null) Mulop.accept(visitor);
        if(FactorNeg!=null) FactorNeg.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulopFactor!=null) MulopFactor.traverseTopDown(visitor);
        if(Mulop!=null) Mulop.traverseTopDown(visitor);
        if(FactorNeg!=null) FactorNeg.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulopFactor!=null) MulopFactor.traverseBottomUp(visitor);
        if(Mulop!=null) Mulop.traverseBottomUp(visitor);
        if(FactorNeg!=null) FactorNeg.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopFactor_mul(\n");

        if(MulopFactor!=null)
            buffer.append(MulopFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Mulop!=null)
            buffer.append(Mulop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorNeg!=null)
            buffer.append(FactorNeg.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulopFactor_mul]");
        return buffer.toString();
    }
}
