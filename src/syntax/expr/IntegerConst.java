package syntax.expr;

import syntax.Expr;
import syntax.Leaf;
import visitor.Visitor;

public class IntegerConst extends Expr implements Leaf<Integer> {

    private int value;

    public IntegerConst(int leftLocation, int rightLocation, String value) {
        super(leftLocation, rightLocation);
        this.value = Integer.parseInt(value);
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
