package syntax.expr.binaryexpr.relop;

import nodetype.PrimitiveNodeType;
import syntax.Expr;
import syntax.expr.BinaryOp;
import visitor.Visitor;

public class NotEqualRelop extends BinaryOp {

    private Expr leftOperand;
    private Expr rightOperand;
    PrimitiveNodeType NodeType;

    public PrimitiveNodeType getNodeType() {
        return NodeType;
    }

    public void setNodeType(PrimitiveNodeType nodeType) {
        NodeType = nodeType;
    }

    @Override
    public PrimitiveNodeType getType(){
        return getNodeType();
    }
    public NotEqualRelop(int leftLocation, int rightLocation, Expr leftOperand, Expr rightOperand){
        super(leftLocation, rightLocation);
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.NodeType=PrimitiveNodeType.BOOL;
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
