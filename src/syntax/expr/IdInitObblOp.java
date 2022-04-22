package syntax.expr;

import nodetype.PrimitiveNodeType;
import syntax.AstNode;
import visitor.Visitor;

public class IdInitObblOp extends AstNode {

    private Id id;
    private Const constant;
    public boolean isFor_flag() {
        return for_flag;
    }



    public void setFor_flag(boolean for_flag) {
        this.for_flag = for_flag;
    }

    private boolean for_flag = false;
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
