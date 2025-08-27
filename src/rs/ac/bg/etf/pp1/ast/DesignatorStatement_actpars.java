// generated with ast extension for cup
// version 0.8
// 27/7/2025 19:31:50


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatement_actpars extends DesignatorStatement {

    private DesignatorMeth DesignatorMeth;
    private ActParsOpt ActParsOpt;

    public DesignatorStatement_actpars (DesignatorMeth DesignatorMeth, ActParsOpt ActParsOpt) {
        this.DesignatorMeth=DesignatorMeth;
        if(DesignatorMeth!=null) DesignatorMeth.setParent(this);
        this.ActParsOpt=ActParsOpt;
        if(ActParsOpt!=null) ActParsOpt.setParent(this);
    }

    public DesignatorMeth getDesignatorMeth() {
        return DesignatorMeth;
    }

    public void setDesignatorMeth(DesignatorMeth DesignatorMeth) {
        this.DesignatorMeth=DesignatorMeth;
    }

    public ActParsOpt getActParsOpt() {
        return ActParsOpt;
    }

    public void setActParsOpt(ActParsOpt ActParsOpt) {
        this.ActParsOpt=ActParsOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorMeth!=null) DesignatorMeth.accept(visitor);
        if(ActParsOpt!=null) ActParsOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorMeth!=null) DesignatorMeth.traverseTopDown(visitor);
        if(ActParsOpt!=null) ActParsOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorMeth!=null) DesignatorMeth.traverseBottomUp(visitor);
        if(ActParsOpt!=null) ActParsOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatement_actpars(\n");

        if(DesignatorMeth!=null)
            buffer.append(DesignatorMeth.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsOpt!=null)
            buffer.append(ActParsOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatement_actpars]");
        return buffer.toString();
    }
}
