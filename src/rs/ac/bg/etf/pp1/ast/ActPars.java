// generated with ast extension for cup
// version 0.8
// 27/7/2025 19:31:50


package rs.ac.bg.etf.pp1.ast;

public class ActPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Expr Expr;
    private ActParsExprOpt ActParsExprOpt;

    public ActPars (Expr Expr, ActParsExprOpt ActParsExprOpt) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.ActParsExprOpt=ActParsExprOpt;
        if(ActParsExprOpt!=null) ActParsExprOpt.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public ActParsExprOpt getActParsExprOpt() {
        return ActParsExprOpt;
    }

    public void setActParsExprOpt(ActParsExprOpt ActParsExprOpt) {
        this.ActParsExprOpt=ActParsExprOpt;
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
        if(ActParsExprOpt!=null) ActParsExprOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(ActParsExprOpt!=null) ActParsExprOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(ActParsExprOpt!=null) ActParsExprOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActPars(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsExprOpt!=null)
            buffer.append(ActParsExprOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActPars]");
        return buffer.toString();
    }
}
