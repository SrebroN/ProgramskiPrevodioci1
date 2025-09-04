// generated with ast extension for cup
// version 0.8
// 2/8/2025 20:47:24


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatement_actpars extends DesignatorStatement {

    private DesignatorMeth DesignatorMeth;
    private ActParsList ActParsList;

    public DesignatorStatement_actpars (DesignatorMeth DesignatorMeth, ActParsList ActParsList) {
        this.DesignatorMeth=DesignatorMeth;
        if(DesignatorMeth!=null) DesignatorMeth.setParent(this);
        this.ActParsList=ActParsList;
        if(ActParsList!=null) ActParsList.setParent(this);
    }

    public DesignatorMeth getDesignatorMeth() {
        return DesignatorMeth;
    }

    public void setDesignatorMeth(DesignatorMeth DesignatorMeth) {
        this.DesignatorMeth=DesignatorMeth;
    }

    public ActParsList getActParsList() {
        return ActParsList;
    }

    public void setActParsList(ActParsList ActParsList) {
        this.ActParsList=ActParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorMeth!=null) DesignatorMeth.accept(visitor);
        if(ActParsList!=null) ActParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorMeth!=null) DesignatorMeth.traverseTopDown(visitor);
        if(ActParsList!=null) ActParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorMeth!=null) DesignatorMeth.traverseBottomUp(visitor);
        if(ActParsList!=null) ActParsList.traverseBottomUp(visitor);
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

        if(ActParsList!=null)
            buffer.append(ActParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatement_actpars]");
        return buffer.toString();
    }
}
