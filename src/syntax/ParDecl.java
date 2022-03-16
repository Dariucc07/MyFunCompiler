package syntax;

import nodetype.NodeType;
import nodetype.OutParPrimitiveNoteType;
import nodetype.PrimitiveNodeType;
import syntax.expr.Id;
import visitor.Visitor;

public class ParDecl extends AstNode{
    private boolean out;
    private Type type;
    private Id id;


    NodeType nodeType;

    public NodeType getNodeType() {
        if(this.nodeType instanceof OutParPrimitiveNoteType){
            return (OutParPrimitiveNoteType) this.nodeType;
        }else{
            return (PrimitiveNodeType) this.nodeType;
        }
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }


    public ParDecl(int leftLocation,int rightLocation, Type type, Id id){
        super(leftLocation, rightLocation);
        this.out = false;
        this.type = type;
        this.id = id;
        nodeType = type.typeFactory();
    }

    public ParDecl(int leftLocation,int rightLocation, boolean out, Type type, Id id){
        super(leftLocation, rightLocation);
        this.out = out;
        this.type = type;
        this.id = id;
        if (this.out){
            nodeType = new OutParPrimitiveNoteType(type.typeFactory());
        }
        else {
            nodeType = type.typeFactory();
        }
    }

    public boolean isOut() {
        return out;
    }

    public Type getType() {
        return type;
    }

    public Id getId() {
        return id;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
