package syntax.expr;

import nodetype.PrimitiveNodeType;
import syntax.Expr;
import syntax.Leaf;
import visitor.Visitor;

public class CharConst extends Expr implements Leaf<Character> {
    private char value;

    PrimitiveNodeType nodeType;

    public CharConst(int leftLocation, int rightLocation, String value) {
        super(leftLocation, rightLocation);
        this.value = value.charAt(0);
        setNodeType(PrimitiveNodeType.CHAR);
    }

    @Override
    public Character getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public PrimitiveNodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(PrimitiveNodeType nodeType) {
        this.nodeType = nodeType;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {

        return visitor.visit(this, arg);
    }
}
