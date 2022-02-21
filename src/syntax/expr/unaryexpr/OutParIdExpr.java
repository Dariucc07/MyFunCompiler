package syntax.expr.unaryexpr;

import nodetype.PrimitiveNodeType;
import syntax.Expr;
import syntax.expr.Id;
import visitor.Visitor;

public class OutParIdExpr extends Expr {

    private Id id;


    PrimitiveNodeType NodeType;

    public PrimitiveNodeType getNodeType() {
        return NodeType;
    }

    public void setNodeType(PrimitiveNodeType nodeType) {
        NodeType = nodeType;
    }

    public OutParIdExpr(int leftLocation, int rightLocation, Id id) {
        super(leftLocation, rightLocation);
        this.id = id;
    }

    public Id getId() {
        return id;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
