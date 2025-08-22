// generated with ast extension for cup
// version 0.8
// 22/7/2025 16:42:39


package rs.ac.bg.etf.pp1.ast;

public class VarDecMore_m extends VarDecMore {

    private VarDec VarDec;
    private VarDecMore VarDecMore;

    public VarDecMore_m (VarDec VarDec, VarDecMore VarDecMore) {
        this.VarDec=VarDec;
        if(VarDec!=null) VarDec.setParent(this);
        this.VarDecMore=VarDecMore;
        if(VarDecMore!=null) VarDecMore.setParent(this);
    }

    public VarDec getVarDec() {
        return VarDec;
    }

    public void setVarDec(VarDec VarDec) {
        this.VarDec=VarDec;
    }

    public VarDecMore getVarDecMore() {
        return VarDecMore;
    }

    public void setVarDecMore(VarDecMore VarDecMore) {
        this.VarDecMore=VarDecMore;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDec!=null) VarDec.accept(visitor);
        if(VarDecMore!=null) VarDecMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDec!=null) VarDec.traverseTopDown(visitor);
        if(VarDecMore!=null) VarDecMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDec!=null) VarDec.traverseBottomUp(visitor);
        if(VarDecMore!=null) VarDecMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecMore_m(\n");

        if(VarDec!=null)
            buffer.append(VarDec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecMore!=null)
            buffer.append(VarDecMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecMore_m]");
        return buffer.toString();
    }
}
