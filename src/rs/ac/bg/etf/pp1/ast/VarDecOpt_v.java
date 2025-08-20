// generated with ast extension for cup
// version 0.8
// 18/7/2025 14:47:0


package rs.ac.bg.etf.pp1.ast;

public class VarDecOpt_v extends VarDecOpt {

    private VarDecOpt VarDecOpt;
    private VarDecList VarDecList;

    public VarDecOpt_v (VarDecOpt VarDecOpt, VarDecList VarDecList) {
        this.VarDecOpt=VarDecOpt;
        if(VarDecOpt!=null) VarDecOpt.setParent(this);
        this.VarDecList=VarDecList;
        if(VarDecList!=null) VarDecList.setParent(this);
    }

    public VarDecOpt getVarDecOpt() {
        return VarDecOpt;
    }

    public void setVarDecOpt(VarDecOpt VarDecOpt) {
        this.VarDecOpt=VarDecOpt;
    }

    public VarDecList getVarDecList() {
        return VarDecList;
    }

    public void setVarDecList(VarDecList VarDecList) {
        this.VarDecList=VarDecList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDecOpt!=null) VarDecOpt.accept(visitor);
        if(VarDecList!=null) VarDecList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDecOpt!=null) VarDecOpt.traverseTopDown(visitor);
        if(VarDecList!=null) VarDecList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDecOpt!=null) VarDecOpt.traverseBottomUp(visitor);
        if(VarDecList!=null) VarDecList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecOpt_v(\n");

        if(VarDecOpt!=null)
            buffer.append(VarDecOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecList!=null)
            buffer.append(VarDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecOpt_v]");
        return buffer.toString();
    }
}
