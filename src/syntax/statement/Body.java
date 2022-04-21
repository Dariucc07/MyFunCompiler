package syntax.statement;

import syntax.AstNode;
import syntax.Expr;
import visitor.Visitor;

import java.util.LinkedList;

public class Body extends AstNode {

    private LinkedList<Expr> exprList;

    public Body(int leftLocation, int rightLocation, LinkedList<Expr> exprList) {
        super(leftLocation, rightLocation);
        this.exprList = exprList;
    }

    public LinkedList<Expr> getExprList() {
        return exprList;
    }

    public void setExprList(LinkedList<Expr> exprList) {
        this.exprList = exprList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
