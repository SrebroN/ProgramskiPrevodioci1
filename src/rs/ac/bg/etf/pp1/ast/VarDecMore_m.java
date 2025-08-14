// generated with ast extension for cup
// version 0.8
// 14/7/2025 14:16:26


package rs.ac.bg.etf.pp1.ast;

public class VarDecMore_m extends VarDecMore {

    private String I1;
    private Brackets Brackets;
    private VarDecMore VarDecMore;

    public VarDecMore_m (String I1, Brackets Brackets, VarDecMore VarDecMore) {
        this.I1=I1;
        this.Brackets=Brackets;
        if(Brackets!=null) Brackets.setParent(this);
        this.VarDecMore=VarDecMore;
        if(VarDecMore!=null) VarDecMore.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Brackets getBrackets() {
        return Brackets;
    }

    public void setBrackets(Brackets Brackets) {
        this.Brackets=Brackets;
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
        if(Brackets!=null) Brackets.accept(visitor);
        if(VarDecMore!=null) VarDecMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Brackets!=null) Brackets.traverseTopDown(visitor);
        if(VarDecMore!=null) VarDecMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Brackets!=null) Brackets.traverseBottomUp(visitor);
        if(VarDecMore!=null) VarDecMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecMore_m(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Brackets!=null)
            buffer.append(Brackets.toString("  "+tab));
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
