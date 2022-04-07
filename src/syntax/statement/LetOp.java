package syntax.statement;

import syntax.Stat;
import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class LetOp extends Stat {

    private LinkedList<VarDecl> varDeclList;
    private LinkedList<Stat> statList;

    public LetOp(int leftlocation, int rightlocation, LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList) {
        super(leftlocation, rightlocation);
        this.varDeclList = varDeclList;
        this.statList = statList;
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

    public LinkedList<Stat> getStatList() {
        return statList;
    }

    public void setStatList(LinkedList<Stat> statList) {
        this.statList = statList;
    }
}