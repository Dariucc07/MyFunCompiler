package syntax.statement;

import syntax.AstNode;
import syntax.Expr;
import syntax.Stat;
import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class WhileStat extends Stat {
    private Expr expr;
    private LinkedList<VarDecl> varDeclList;
    private LinkedList<Stat> statList;

    public ElseLoop getElseLoop() {
        return elseLoop;
    }

    public void setElseLoop(ElseLoop elseLoop) {
        this.elseLoop = elseLoop;
    }

    private ElseLoop elseLoop;
    public WhileStat(int leftLocation, int rightLocation, Expr expr, LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList) {
        super(leftLocation, rightLocation);
        this.expr = expr;
        this.varDeclList = varDeclList;
        this.statList = statList;
    }

    public WhileStat(int leftLocation, int rightLocation, Expr expr, LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList,ElseLoop elseLoop) {
        super(leftLocation, rightLocation);
        this.expr = expr;
        this.varDeclList = varDeclList;
        this.statList = statList;
        this.elseLoop= elseLoop;
    }

    public Expr getExpr() {
        return expr;
    }

    public LinkedList<VarDecl> getVarDeclList() {
        return varDeclList;
    }

    public LinkedList<Stat> getStatList() {
        return statList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
