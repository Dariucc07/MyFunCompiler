package syntax.statement;

import syntax.Expr;
import syntax.Stat;
import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class ForStat extends Stat {
    private VarDecl varDecl;
    private Expr expr;
    private LinkedList<Stat> statList;

    private LinkedList<VarDecl> varDeclInside;
    private LinkedList<Stat> statListInside;

    public ForStat(int leftlocation, int rightlocation, VarDecl varDecl, Expr expr, LinkedList<Stat> statList, LinkedList<VarDecl> varDeclInside, LinkedList<Stat> statListInside) {
        super(leftlocation, rightlocation);
        this.varDecl = varDecl;
        this.expr = expr;
        this.statList = statList;
        this.varDeclInside = varDeclInside;
        this.statListInside = statListInside;
    }

    public LinkedList<VarDecl> getVarDeclInside() {
        return varDeclInside;
    }

    public void setVarDeclInside(LinkedList<VarDecl> varDeclInside) {
        this.varDeclInside = varDeclInside;
    }

    public LinkedList<Stat> getStatListInside() {
        return statListInside;
    }

    public void setStatListInside(LinkedList<Stat> statListInside) {
        this.statListInside = statListInside;
    }

    public VarDecl getVarDecl() {
        return varDecl;
    }

    public void setVarDecl(VarDecl varDecl) {
        this.varDecl = varDecl;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public LinkedList<Stat> getStatList() {
        return statList;
    }

    public void setStatList(LinkedList<Stat> statList) {
        this.statList = statList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
