package syntax.expr;

import nodetype.PrimitiveNodeType;
import syntax.Expr;
import syntax.Leaf;
import visitor.Visitor;

public class RealConst extends Expr implements Leaf<Double> {

    private double value;
    PrimitiveNodeType NodeType;
    public PrimitiveNodeType getNodeType() {
        return NodeType;
    }

    public RealConst(int leftLocation, int rightLocation, String value) {
        super(leftLocation, rightLocation);
        this.value = Double.parseDouble(value);
        setNodeType(PrimitiveNodeType.REAL);
    }

    @Override
    public Double getValue() {
        return this.value;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
