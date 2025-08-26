// generated with ast extension for cup
// version 0.8
// 26/7/2025 17:8:31


package rs.ac.bg.etf.pp1.ast;

public class CondFactArr_c extends CondFactArr {

    private CondFactArr CondFactArr;
    private CondFact CondFact;

    public CondFactArr_c (CondFactArr CondFactArr, CondFact CondFact) {
        this.CondFactArr=CondFactArr;
        if(CondFactArr!=null) CondFactArr.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
    }

    public CondFactArr getCondFactArr() {
        return CondFactArr;
    }

    public void setCondFactArr(CondFactArr CondFactArr) {
        this.CondFactArr=CondFactArr;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFactArr!=null) CondFactArr.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactArr!=null) CondFactArr.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactArr!=null) CondFactArr.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactArr_c(\n");

        if(CondFactArr!=null)
            buffer.append(CondFactArr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactArr_c]");
        return buffer.toString();
    }
}
