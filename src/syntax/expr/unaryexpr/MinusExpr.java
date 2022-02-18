package syntax.expr.unaryexpr;

import syntax.Expr;
import syntax.expr.UnaryOp;
import visitor.Visitor;

public class MinusExpr extends UnaryOp {

    private Expr expr;

    public MinusExpr(int leftLocation, int rightLocation, Expr expr) {
        super(leftLocation, rightLocation);
        this.expr = expr;
    }

    public Expr getExpr(){
        return expr;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
