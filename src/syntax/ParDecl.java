package syntax;

import syntax.expr.Id;
import visitor.Visitor;

public class ParDecl extends AstNode{
    private boolean out;
    private Type type;
    private Id id;


    public ParDecl(int leftLocation,int rightLocation, Type type, Id id){
        super(leftLocation, rightLocation);
        this.out = false;
        this.type = type;
        this.id = id;
    }

    public ParDecl(int leftLocation,int rightLocation, boolean out, Type type, Id id){
        super(leftLocation, rightLocation);
        this.out = out;
        this.type = type;
        this.id = id;
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
