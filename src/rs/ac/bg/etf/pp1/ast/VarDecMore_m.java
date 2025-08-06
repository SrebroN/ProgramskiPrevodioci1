// generated with ast extension for cup
// version 0.8
// 6/7/2025 19:6:28


package src.rs.ac.bg.etf.pp1.ast;

public class VarDecMore_m extends VarDecMore {

    private String I1;
    private VarDecListBracket VarDecListBracket;
    private VarDecMore VarDecMore;

    public VarDecMore_m (String I1, VarDecListBracket VarDecListBracket, VarDecMore VarDecMore) {
        this.I1=I1;
        this.VarDecListBracket=VarDecListBracket;
        if(VarDecListBracket!=null) VarDecListBracket.setParent(this);
        this.VarDecMore=VarDecMore;
        if(VarDecMore!=null) VarDecMore.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public VarDecListBracket getVarDecListBracket() {
        return VarDecListBracket;
    }

    public void setVarDecListBracket(VarDecListBracket VarDecListBracket) {
        this.VarDecListBracket=VarDecListBracket;
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
        if(VarDecListBracket!=null) VarDecListBracket.accept(visitor);
        if(VarDecMore!=null) VarDecMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDecListBracket!=null) VarDecListBracket.traverseTopDown(visitor);
        if(VarDecMore!=null) VarDecMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDecListBracket!=null) VarDecListBracket.traverseBottomUp(visitor);
        if(VarDecMore!=null) VarDecMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecMore_m(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(VarDecListBracket!=null)
            buffer.append(VarDecListBracket.toString("  "+tab));
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
