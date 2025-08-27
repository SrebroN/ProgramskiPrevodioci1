// generated with ast extension for cup
// version 0.8
// 27/7/2025 19:31:50


package rs.ac.bg.etf.pp1.ast;

public class CondFact implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Expr Expr;
    private CondFactREOpt CondFactREOpt;

    public CondFact (Expr Expr, CondFactREOpt CondFactREOpt) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.CondFactREOpt=CondFactREOpt;
        if(CondFactREOpt!=null) CondFactREOpt.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public CondFactREOpt getCondFactREOpt() {
        return CondFactREOpt;
    }

    public void setCondFactREOpt(CondFactREOpt CondFactREOpt) {
        this.CondFactREOpt=CondFactREOpt;
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
        if(Expr!=null) Expr.accept(visitor);
        if(CondFactREOpt!=null) CondFactREOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(CondFactREOpt!=null) CondFactREOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(CondFactREOpt!=null) CondFactREOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFact(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFactREOpt!=null)
            buffer.append(CondFactREOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFact]");
        return buffer.toString();
    }
}
