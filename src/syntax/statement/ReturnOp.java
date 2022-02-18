package syntax.statement;

import syntax.Expr;
import syntax.Stat;
import visitor.Visitor;

public class ReturnOp extends Stat {

    private Expr expr;

    public ReturnOp(int leftlocation, int rightlocation, Expr expr) {
        super(leftlocation, rightlocation);
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
