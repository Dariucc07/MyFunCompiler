package nodetype;

import java.util.Objects;

public class OutParPrimitiveNoteType implements NodeType{

    private NodeType nodeType;



    public OutParPrimitiveNoteType(NodeType nodeType) {
        this.nodeType = nodeType;
    }


    public NodeType getNodeType() {
        return nodeType;
    }

    @Override
    public PrimitiveNodeType checkAdd(PrimitiveNodeType type) {
        return nodeType.checkAdd(type);
    }

    @Override
    public PrimitiveNodeType checkSub(PrimitiveNodeType type) {
        return nodeType.checkSub(type);
    }

    @Override
    public PrimitiveNodeType checkMul(PrimitiveNodeType type) {
        return nodeType.checkMul(type);
    }

    @Override
    public PrimitiveNodeType checkDiv(PrimitiveNodeType type) {
        return nodeType.checkDiv(type);
    }

    @Override
    public PrimitiveNodeType checkRel(PrimitiveNodeType type) {
        return nodeType.checkRel(type);
    }

    @Override
    public PrimitiveNodeType checkDivInt(PrimitiveNodeType type) {
        return nodeType.checkDivInt(type);
    }

    @Override
    public PrimitiveNodeType checkPow(PrimitiveNodeType type) {
        return nodeType.checkPow(type);
    }

    @Override
    public PrimitiveNodeType checkStrConcat(PrimitiveNodeType type) {
        return nodeType.checkStrConcat(type);
    }

    @Override
    public String toString() {
        return nodeType.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.nodeType);
        return hash;
    }
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutParPrimitiveNoteType that = (OutParPrimitiveNoteType) o;
        return Objects.equals(nodeType, that.nodeType);
    }

     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutParPrimitiveNoteType that = (OutParPrimitiveNoteType) o;
        return nodeType.equals(that.nodeType);
    }
}
