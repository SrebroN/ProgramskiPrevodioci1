// generated with ast extension for cup
// version 0.8
// 6/7/2025 19:6:28


package src.rs.ac.bg.etf.pp1.ast;

public class VarDecList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String I2;
    private VarDecListBracket VarDecListBracket;
    private VarDecMore VarDecMore;

    public VarDecList (Type Type, String I2, VarDecListBracket VarDecListBracket, VarDecMore VarDecMore) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.VarDecListBracket=VarDecListBracket;
        if(VarDecListBracket!=null) VarDecListBracket.setParent(this);
        this.VarDecMore=VarDecMore;
        if(VarDecMore!=null) VarDecMore.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
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

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarDecListBracket!=null) VarDecListBracket.accept(visitor);
        if(VarDecMore!=null) VarDecMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDecListBracket!=null) VarDecListBracket.traverseTopDown(visitor);
        if(VarDecMore!=null) VarDecMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDecListBracket!=null) VarDecListBracket.traverseBottomUp(visitor);
        if(VarDecMore!=null) VarDecMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecList(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
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
        buffer.append(") [VarDecList]");
        return buffer.toString();
    }
}
