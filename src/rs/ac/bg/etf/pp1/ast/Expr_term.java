// generated with ast extension for cup
// version 0.8
// 22/7/2025 16:42:39


package rs.ac.bg.etf.pp1.ast;

public class Expr_term extends Expr {

    private Term Term;
    private AddOpTerm AddOpTerm;

    public Expr_term (Term Term, AddOpTerm AddOpTerm) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.AddOpTerm=AddOpTerm;
        if(AddOpTerm!=null) AddOpTerm.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
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
        if(Term!=null) Term.accept(visitor);
        if(AddOpTerm!=null) AddOpTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(AddOpTerm!=null) AddOpTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(AddOpTerm!=null) AddOpTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr_term(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
