package syntax.statement;

import syntax.Stat;
import syntax.expr.Const;
import visitor.Visitor;

import java.util.LinkedList;

public class Body extends Stat {

    private Const constant;
    private LinkedList<Stat> staList;

    public Body(int leftlocation, int rightlocation, Const constant, LinkedList<Stat> staList) {
        super(leftlocation, rightlocation);
        this.constant = constant;
        this.staList = staList;
    }

    public Const getConstant() {
        return constant;
    }

    public void setConstant(Const constant) {
        this.constant = constant;
    }

    public LinkedList<Stat> getStaList() {
        return staList;
    }

    public void setStaList(LinkedList<Stat> staList) {
        this.staList = staList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
