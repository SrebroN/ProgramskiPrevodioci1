// generated with ast extension for cup
// version 0.8
// 14/7/2025 14:16:26


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodSignature MethodSignature;
    private VarDecOpt VarDecOpt;
    private StatementOpt StatementOpt;

    public MethodDecl (MethodSignature MethodSignature, VarDecOpt VarDecOpt, StatementOpt StatementOpt) {
        this.MethodSignature=MethodSignature;
        if(MethodSignature!=null) MethodSignature.setParent(this);
        this.VarDecOpt=VarDecOpt;
        if(VarDecOpt!=null) VarDecOpt.setParent(this);
        this.StatementOpt=StatementOpt;
        if(StatementOpt!=null) StatementOpt.setParent(this);
    }

    public MethodSignature getMethodSignature() {
        return MethodSignature;
    }

    public void setMethodSignature(MethodSignature MethodSignature) {
        this.MethodSignature=MethodSignature;
    }

    public VarDecOpt getVarDecOpt() {
        return VarDecOpt;
    }

    public void setVarDecOpt(VarDecOpt VarDecOpt) {
        this.VarDecOpt=VarDecOpt;
    }

    public StatementOpt getStatementOpt() {
        return StatementOpt;
    }

    public void setStatementOpt(StatementOpt StatementOpt) {
        this.StatementOpt=StatementOpt;
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
        if(MethodSignature!=null) MethodSignature.accept(visitor);
        if(VarDecOpt!=null) VarDecOpt.accept(visitor);
        if(StatementOpt!=null) StatementOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodSignature!=null) MethodSignature.traverseTopDown(visitor);
        if(VarDecOpt!=null) VarDecOpt.traverseTopDown(visitor);
        if(StatementOpt!=null) StatementOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodSignature!=null) MethodSignature.traverseBottomUp(visitor);
        if(VarDecOpt!=null) VarDecOpt.traverseBottomUp(visitor);
        if(StatementOpt!=null) StatementOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodSignature!=null)
            buffer.append(MethodSignature.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecOpt!=null)
            buffer.append(VarDecOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementOpt!=null)
            buffer.append(StatementOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
