package syntax.expr.binaryexpr.arithop;

import nodetype.PrimitiveNodeType;
import syntax.Expr;
import syntax.expr.BinaryOp;
import visitor.Visitor;

public class PowOp extends BinaryOp {

    private Expr baseOperand;
    private Expr exponentOperand;

    PrimitiveNodeType NodeType;

    public PrimitiveNodeType getType() {
        return NodeType;
    }

    public void setNodeType(PrimitiveNodeType nodeType) {
        NodeType = nodeType;
    }

    public PowOp(int leftLocation, int rightLocation, Expr baseOperand, Expr exponentOperand){
        super(leftLocation, rightLocation);
        this.baseOperand = baseOperand;
        this.exponentOperand = exponentOperand;
    }

    public Expr getBaseOperand(){
        return baseOperand;
    }

    public Expr getExponentOperand(){
        return exponentOperand;
    }


    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
