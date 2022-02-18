package syntax.expr;

import syntax.Expr;
import syntax.Stat;
import visitor.Visitor;

import java.util.LinkedList;

public class CallFunction extends Expr {

    private Id id;
    private LinkedList<Expr> exprList;

    public CallFunction(int leftLocation, int rightLocation, Id id, LinkedList<Expr> exprList) {
        super(leftLocation, rightLocation);
        this.id = id;
        this.exprList = exprList;
    }

    public CallFunction(int leftLocation, int rightLocation, Id id){
        super(leftLocation, rightLocation);
        this. id = id;
    }

    public Id getId() {
        return id;
    }

    public LinkedList<Expr> getExprList(){
        return exprList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
