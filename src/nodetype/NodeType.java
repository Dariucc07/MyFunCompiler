package nodetype;

public interface NodeType {

    PrimitiveNodeType checkAdd(PrimitiveNodeType type);
    PrimitiveNodeType checkSub(PrimitiveNodeType type);
    PrimitiveNodeType checkMul(PrimitiveNodeType type);
    PrimitiveNodeType checkDiv(PrimitiveNodeType type);
    PrimitiveNodeType checkRel(PrimitiveNodeType type);
    PrimitiveNodeType checkDivInt(PrimitiveNodeType type);
    PrimitiveNodeType checkPow(PrimitiveNodeType type);
    PrimitiveNodeType checkStrConcat(PrimitiveNodeType type);
    PrimitiveNodeType checkOpType(PrimitiveNodeType type);

}