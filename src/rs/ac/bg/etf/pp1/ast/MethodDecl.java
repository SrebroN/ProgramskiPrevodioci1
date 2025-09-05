// generated with ast extension for cup
// version 0.8
// 5/8/2025 23:43:36


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodSignAndName MethodSignAndName;
    private FormParsOpt FormParsOpt;
    private VarDecOpt VarDecOpt;
    private StatementOpt StatementOpt;

    public MethodDecl (MethodSignAndName MethodSignAndName, FormParsOpt FormParsOpt, VarDecOpt VarDecOpt, StatementOpt StatementOpt) {
        this.MethodSignAndName=MethodSignAndName;
        if(MethodSignAndName!=null) MethodSignAndName.setParent(this);
        this.FormParsOpt=FormParsOpt;
        if(FormParsOpt!=null) FormParsOpt.setParent(this);
        this.VarDecOpt=VarDecOpt;
        if(VarDecOpt!=null) VarDecOpt.setParent(this);
        this.StatementOpt=StatementOpt;
        if(StatementOpt!=null) StatementOpt.setParent(this);
    }

    public MethodSignAndName getMethodSignAndName() {
        return MethodSignAndName;
    }

    public void setMethodSignAndName(MethodSignAndName MethodSignAndName) {
        this.MethodSignAndName=MethodSignAndName;
    }

    public FormParsOpt getFormParsOpt() {
        return FormParsOpt;
    }

    public void setFormParsOpt(FormParsOpt FormParsOpt) {
        this.FormParsOpt=FormParsOpt;
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
        if(MethodSignAndName!=null) MethodSignAndName.accept(visitor);
        if(FormParsOpt!=null) FormParsOpt.accept(visitor);
        if(VarDecOpt!=null) VarDecOpt.accept(visitor);
        if(StatementOpt!=null) StatementOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodSignAndName!=null) MethodSignAndName.traverseTopDown(visitor);
        if(FormParsOpt!=null) FormParsOpt.traverseTopDown(visitor);
        if(VarDecOpt!=null) VarDecOpt.traverseTopDown(visitor);
        if(StatementOpt!=null) StatementOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodSignAndName!=null) MethodSignAndName.traverseBottomUp(visitor);
        if(FormParsOpt!=null) FormParsOpt.traverseBottomUp(visitor);
        if(VarDecOpt!=null) VarDecOpt.traverseBottomUp(visitor);
        if(StatementOpt!=null) StatementOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodSignAndName!=null)
            buffer.append(MethodSignAndName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsOpt!=null)
            buffer.append(FormParsOpt.toString("  "+tab));
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
