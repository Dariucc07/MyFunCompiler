package syntax.expr.unaryexpr;

import syntax.Expr;
import syntax.expr.Id;
import visitor.Visitor;

public class OutParIdExpr extends Expr {

    private Id id;

    public OutParIdExpr(int leftLocation, int rightLocation, Id id) {
        super(leftLocation, rightLocation);
        this.id = id;
    }
    public Id getId() {
        return id;
    }
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
