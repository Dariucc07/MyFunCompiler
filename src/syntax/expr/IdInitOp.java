package syntax.expr;

import nodetype.PrimitiveNodeType;
import syntax.AstNode;
import syntax.Expr;
import visitor.Visitor;

public class IdInitOp extends AstNode {

    private Id id;
    private Expr expr;

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


    public IdInitOp(int leftLocation, int rightLocation, Id id, Expr expr) {
        super(leftLocation, rightLocation);
        this.id = id;
        this.expr = expr;
    }

    public IdInitOp(int leftLocation, int rightLocation, Id id){
        super(leftLocation, rightLocation);
        this.id = id;
    }

    public Id getId() {
        return id;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
