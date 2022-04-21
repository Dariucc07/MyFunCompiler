package syntax.statement;

import syntax.AstNode;
import syntax.Expr;
import syntax.expr.Id;
import visitor.Visitor;

import java.util.LinkedList;

public class Mapsum extends Expr {

    private Id id;
    private LinkedList<Body> bodyList;

    public Mapsum(int leftLocation, int rightLocation, Id id, LinkedList<Body> bodyList) {
        super(leftLocation, rightLocation);
        this.id = id;
        this.bodyList = bodyList;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public LinkedList<Body> getBodyList() {
        return bodyList;
    }

    public void setBodyList(LinkedList<Body> bodyList) {
        this.bodyList = bodyList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
