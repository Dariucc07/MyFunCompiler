package syntax.type;

import nodetype.PrimitiveNodeType;
import syntax.Type;
import visitor.Visitor;

public class PrimitiveType extends Type {

    private String type;

    public PrimitiveType(int leftLocation, int rightLocation, String type) {
        super(leftLocation, rightLocation);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public PrimitiveNodeType typeFactory(){
        switch(type){
            case "INTEGER":
                return PrimitiveNodeType.INT;
            case "REAL":
                return PrimitiveNodeType.REAL;
            case "STRING":
                return PrimitiveNodeType.STRING;
            case "BOOL":
                return PrimitiveNodeType.BOOL;
            default:
                return PrimitiveNodeType.NULL;
        }
    }
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
