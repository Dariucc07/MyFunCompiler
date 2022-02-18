package syntax.type;

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

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
