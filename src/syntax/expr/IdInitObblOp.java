package syntax.expr;

import nodetype.PrimitiveNodeType;
import syntax.AstNode;
import visitor.Visitor;

public class IdInitObblOp extends AstNode {

    private Id id;
    private Const constant;

    private PrimitiveNodeType NodeType;
    public PrimitiveNodeType getNodeType() {
        return NodeType;
    }

    public void setNodeType(PrimitiveNodeType nodeType) {
        NodeType = nodeType;
    }


    public IdInitObblOp(int leftLocation, int rightLocation, Id id, Const constant) {
        super(leftLocation, rightLocation);
        this.id = id;
        this.constant = constant;
    }

    public Id getId() {
        return id;
    }

    public Const getConstant() {
        return constant;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
