package syntax.statement;

import syntax.AstNode;
import syntax.Expr;
import visitor.Visitor;

import java.util.LinkedList;

public class For extends AstNode {

    private Expr expr;
    private LinkedList<AssignStat> assignStatList;

    public For(int leftLocation, int rightLocation, Expr expr, LinkedList<AssignStat> assignStatList) {
        super(leftLocation, rightLocation);
        this.expr = expr;
        this.assignStatList = assignStatList;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public LinkedList<AssignStat> getAssignStatList() {
        return assignStatList;
    }

    public void setAssignStatList(LinkedList<AssignStat> assignStatList) {
        this.assignStatList = assignStatList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
