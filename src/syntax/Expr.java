package syntax;

import nodetype.NodeType;

public abstract class Expr extends AstNode{
    NodeType type;
    public Expr(int leftLocation, int rightLocation) {
        super(leftLocation, rightLocation);
    }

    public NodeType getType() {
        return type;
    }
    
    public void setNodeType(NodeType nodeType){
        this.type = nodeType;
    }
}
