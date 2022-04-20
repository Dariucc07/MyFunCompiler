package syntax.expr;

import syntax.AstNode;
import syntax.Expr;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.LinkedList;

public class IdInitMore extends AstNode {

     LinkedList<Id> idList;
     LinkedList<Expr> ExprList;

    public LinkedList<Id> getIdList() {
        return idList;
    }

    public void setIdList(LinkedList<Id> idList) {
        this.idList = idList;
    }

    public LinkedList<Expr> getExprList() {
        return ExprList;
    }

    public void setExprList(LinkedList<Expr> exprList) {
        ExprList = exprList;
    }

    public IdInitMore(int leftLocation, int rightLocation, LinkedList<Id> idList, LinkedList<Expr> exprList) {
        super(leftLocation, rightLocation);
        this.idList = idList;
        ExprList = exprList;
    }
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
