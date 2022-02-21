package syntax.expr.unaryexpr;

import nodetype.PrimitiveNodeType;
import syntax.Expr;
import syntax.expr.UnaryOp;
import visitor.Visitor;

public class NotExpr extends UnaryOp {

    private Expr expr;
    PrimitiveNodeType NodeType;

    public PrimitiveNodeType getNodeType() {
        return NodeType;
    }

    public void setNodeType(PrimitiveNodeType nodeType) {
        NodeType = nodeType;
    }
    public NotExpr(int leftLocation, int rightLocation, Expr expr) {
        super(leftLocation, rightLocation);
        this.expr = expr;
    }

    public Expr getExpr(){
        return expr;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
