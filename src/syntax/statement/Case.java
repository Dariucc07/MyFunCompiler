package syntax.statement;

import syntax.AstNode;
import syntax.Stat;
import syntax.expr.Const;
import visitor.Visitor;

import java.util.LinkedList;

public class Case extends AstNode {
    Const constant;
    LinkedList<Stat> StatList;

    public Const getConstant() {
        return constant;
    }

    public void setConstant(Const constant) {
        this.constant = constant;
    }

    public LinkedList<Stat> getStatList() {
        return StatList;
    }

    public void setStatList(LinkedList<Stat> statList) {
        StatList = statList;
    }

    public Case(int leftLocation, int rightLocation, Const constant, LinkedList<Stat> statList) {
        super(leftLocation, rightLocation);
        this.constant = constant;
        StatList = statList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
