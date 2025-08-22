// generated with ast extension for cup
// version 0.8
// 22/7/2025 16:42:39


package rs.ac.bg.etf.pp1.ast;

public class DesignatorRecMore_rec_var extends DesignatorRecMore {

    private DesignatorRecMore DesignatorRecMore;
    private String I2;

    public DesignatorRecMore_rec_var (DesignatorRecMore DesignatorRecMore, String I2) {
        this.DesignatorRecMore=DesignatorRecMore;
        if(DesignatorRecMore!=null) DesignatorRecMore.setParent(this);
        this.I2=I2;
    }

    public DesignatorRecMore getDesignatorRecMore() {
        return DesignatorRecMore;
    }

    public void setDesignatorRecMore(DesignatorRecMore DesignatorRecMore) {
        this.DesignatorRecMore=DesignatorRecMore;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorRecMore!=null) DesignatorRecMore.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorRecMore!=null) DesignatorRecMore.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorRecMore!=null) DesignatorRecMore.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorRecMore_rec_var(\n");

        if(DesignatorRecMore!=null)
            buffer.append(DesignatorRecMore.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorRecMore_rec_var]");
        return buffer.toString();
    }
}
