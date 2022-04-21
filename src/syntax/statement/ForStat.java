package syntax.statement;

import syntax.Expr;
import syntax.Stat;
import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class ForStat extends Stat {
    private VarDecl varDecl;
    private Expr expr;
    private Stat stat;

    private LinkedList<VarDecl> varDeclList;
    private LinkedList<Stat> statList;

    public ForStat(int leftlocation, int rightlocation, VarDecl varDecl, Expr expr, Stat stat, LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList) {
        super(leftlocation, rightlocation);
        this.varDecl = varDecl;
        this.expr = expr;
        this.stat = stat;
        this.varDeclList = varDeclList;
        this.statList = statList;
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

    public LinkedList<VarDecl> getVarDeclList() {
        return varDeclList;
    }

    public void setVarDeclList(LinkedList<VarDecl> varDeclList) {
        this.varDeclList = varDeclList;
    }

    public LinkedList<Stat> getStatList() {
        return statList;
    }

    public void setStatList(LinkedList<Stat> statList) {
        this.statList = statList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
