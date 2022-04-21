package syntax.statement;

import syntax.Stat;
import syntax.expr.Id;
import visitor.Visitor;

import java.util.LinkedList;

public class Switch extends Stat {
    private Id id;
    private LinkedList<Body> bodyList;

    public Switch(int leftlocation, int rightlocation, Id id, LinkedList<Body> bodyList) {
        super(leftlocation, rightlocation);
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
