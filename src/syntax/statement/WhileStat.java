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
    private ElseLoopOp elseLoopOp;

    public WhileStat(int leftLocation, int rightLocation, Expr expr, LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList, ElseLoopOp elseLoopOp) {
        super(leftLocation, rightLocation);
        this.expr = expr;
        this.varDeclList = varDeclList;
        this.statList = statList;
        this.elseLoopOp = elseLoopOp;
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

    public ElseLoopOp getElseLoopOp(){
        return elseLoopOp;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
