package syntax.statement;

import nodetype.NodeType;
import nodetype.PrimitiveNodeType;
import syntax.Expr;
import syntax.Stat;
import visitor.Visitor;

public class ReturnOp extends Stat {

    private Expr expr;

    NodeType nodeType;

    public ReturnOp(int leftlocation, int rightlocation, Expr expr) {
        super(leftlocation, rightlocation);
        this.expr = expr;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }


    public Expr getExpr() {
        return expr;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
