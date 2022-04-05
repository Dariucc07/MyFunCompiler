package syntax.statement;

import syntax.Expr;
import syntax.Stat;
import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class ElseLoopOp extends Stat {
    //per ottenere la condizione del while e riportarla nella traduzione di elseLoop in C
    private String condition;

    private LinkedList<VarDecl> varDeclList;
    private LinkedList<Stat> staList;
    public ElseLoopOp(int leftlocation, int rightlocation, LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList) {
        super(leftlocation, rightlocation);
        this.varDeclList = varDeclList;
        this.staList = statList;
        this.condition = null;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }

    public LinkedList<VarDecl> getVarDeclList() {
        return varDeclList;
    }

    public void setVarDeclList(LinkedList<VarDecl> varDeclList) {
        this.varDeclList = varDeclList;
    }

    public LinkedList<Stat> getStaList() {
        return staList;
    }

    public void setStaList(LinkedList<Stat> staList) {
        this.staList = staList;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
