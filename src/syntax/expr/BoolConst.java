package syntax.expr;

import syntax.Expr;
import syntax.Leaf;
import visitor.Visitor;

public class BoolConst extends Expr implements Leaf<Boolean> {

    private boolean value;

    public BoolConst(int leftLocation, int rightLocation, String value) {
        super(leftLocation, rightLocation);
        this.value = Boolean.parseBoolean(value);
    }

    @Override
    public Boolean getValue() {
        return this.value;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
