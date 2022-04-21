package syntax;

import nodetype.NodeType;
import syntax.expr.Id;
import visitor.Visitor;

import java.util.LinkedList;

public class MapSum extends AstNode{
    NodeType nodeType;
    Id id;




    LinkedList<LinkedList<Expr>> actualParList;

    public MapSum(int leftLocation, int rightLocation, Id id, LinkedList<LinkedList<Expr>> actualParList) {
        super(leftLocation, rightLocation);
        this.id = id;
        this.actualParList = actualParList;

    }
    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public LinkedList<LinkedList<Expr>> getActualParList() {
        return actualParList;
    }

    public void setActualParList(LinkedList<LinkedList<Expr>> actualParList) {
        this.actualParList = actualParList;
    }
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
