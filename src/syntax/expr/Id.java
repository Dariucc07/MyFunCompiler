package syntax.expr;

import nodetype.PrimitiveNodeType;
import syntax.Expr;
import syntax.Leaf;
import visitor.Visitor;

public class Id extends Expr implements Leaf<String> {

    private String value;
    private boolean isParDecl = false;
    private boolean isFunction = false;
    PrimitiveNodeType NodeType;
    public PrimitiveNodeType getNodeType() {
        return NodeType;
    }



    public void setNodeType(PrimitiveNodeType nodeType) {
        NodeType = nodeType;
    }

    public Id(int leftLocation, int rightLocation, String value) {
        super(leftLocation, rightLocation);
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Id{" +
                "value='" + value + '\'' +
                '}';
    }

    public boolean isParDecl() {
        return isParDecl;
    }

    public void setParDecl(boolean parDecl) {
        isParDecl = parDecl;
    }

    public boolean isFunction() {
        return isFunction;
    }

    public void setFunction(boolean function) {
        isFunction = function;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
