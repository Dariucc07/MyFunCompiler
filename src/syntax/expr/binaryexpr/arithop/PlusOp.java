package syntax.expr.binaryexpr.arithop;

import syntax.Expr;
import syntax.expr.BinaryOp;
import visitor.Visitor;

public class PlusOp extends BinaryOp {

    private Expr leftOperand;
    private Expr rightOperand;

    public PlusOp(int leftLocation, int rightLocation, Expr leftOperand, Expr rightOpeand) {
        super(leftLocation, rightLocation);
        this.leftOperand = leftOperand;
        this.rightOperand = rightOpeand;
    }

    public Expr getLeftOperand(){
        return leftOperand;
    }

    public Expr getRightOperand(){
        return rightOperand;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
