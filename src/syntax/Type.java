package syntax;

import nodetype.NodeType;
import nodetype.PrimitiveNodeType;

public abstract class Type extends AstNode {

    public Type(int leftLocation, int rightLocation) {
        super(leftLocation, rightLocation);
    }

    public NodeType typeFactory() {
        return null;
    }
}
