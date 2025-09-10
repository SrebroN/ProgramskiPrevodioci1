// generated with ast extension for cup
// version 0.8
// 10/8/2025 12:17:47


package rs.ac.bg.etf.pp1.ast;

public class Expr_term extends Expr {

    private AddOpTerm AddOpTerm;

    public Expr_term (AddOpTerm AddOpTerm) {
        this.AddOpTerm=AddOpTerm;
        if(AddOpTerm!=null) AddOpTerm.setParent(this);
    }

    public AddOpTerm getAddOpTerm() {
        return AddOpTerm;
    }

    public void setAddOpTerm(AddOpTerm AddOpTerm) {
        this.AddOpTerm=AddOpTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddOpTerm!=null) AddOpTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddOpTerm!=null) AddOpTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddOpTerm!=null) AddOpTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr_term(\n");

        if(AddOpTerm!=null)
            buffer.append(AddOpTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expr_term]");
        return buffer.toString();
    }
}
