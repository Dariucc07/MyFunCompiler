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
            case "CHAR":
                return PrimitiveNodeType.CHAR;
            default:
                return PrimitiveNodeType.NULL;
        }
    }
    public String typeConverterC(){
        switch(type){
            case "INTEGER":
                return "int";
            case "REAL":
                return "float";
            case "STRING":
                return "char";
            case "BOOL":
                return "int";
            case "CHAR":
                return "char";
            default:
                return "void";
        }
    }
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
