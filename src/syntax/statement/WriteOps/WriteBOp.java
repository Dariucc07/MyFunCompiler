package syntax.statement.WriteOps;

import syntax.Expr;
import syntax.statement.WriteStat;
import visitor.Visitor;

public class WriteBOp extends WriteStat {
    private Expr expr;

    public WriteBOp(int leftLocation, int rightLocation, Expr expr) {
        super(leftLocation, rightLocation);
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
