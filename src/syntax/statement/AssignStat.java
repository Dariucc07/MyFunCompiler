package syntax.statement;

import syntax.AstNode;
import syntax.Expr;
import syntax.Stat;
import syntax.expr.Id;
import visitor.Visitor;

public class AssignStat extends Stat {
    private Id id;
    private Expr expr;

    public AssignStat(int leftLocation, int rightLocation, Id id, Expr expr) {
        super(leftLocation, rightLocation);
        this.id = id;
        this.expr = expr;
    }

    public Id getId() {
        return id;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
