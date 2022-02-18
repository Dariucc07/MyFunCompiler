package syntax.expr.binaryexpr.relop;

import syntax.Expr;
import syntax.expr.BinaryOp;
import visitor.Visitor;

public class LessThanRelop extends BinaryOp {

    private Expr leftOperand;
    private Expr rightOperand;

    public LessThanRelop(int leftLocation, int rightLocation, Expr leftOperand, Expr rightOperand) {
        super(leftLocation, rightLocation);
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
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
