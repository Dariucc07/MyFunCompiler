package syntax.statement;

import syntax.AstNode;
import syntax.Expr;
import syntax.Stat;
import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class DoForStat extends Stat {
    private VarDecl varDecl;
    private Stat stat;
    private Expr expr;

    private LinkedList<Stat> commaStatList;



    public DoForStat(int leftLocation, int rightLocation, VarDecl varDecl, Stat stat, Expr expr, LinkedList<Stat> commaStatList) {
        super(leftLocation, rightLocation);
        this.varDecl = varDecl;
        this.stat = stat;
        this.expr = expr;
        this.commaStatList = commaStatList;
    }

    public LinkedList<Stat> getCommaStatList() {
        return commaStatList;
    }
    public VarDecl getVarDecl() {
        return varDecl;
    }

    public void setVarDecl(VarDecl varDecl) {
        this.varDecl = varDecl;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }
    public void setCommaStatList(LinkedList<Stat> commaStatList) {
        this.commaStatList = commaStatList;
    }










    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
