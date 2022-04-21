package syntax.statement;

import syntax.AstNode;
import syntax.Stat;
import syntax.expr.Id;
import visitor.Visitor;

import java.util.LinkedList;

public class SwitchStat extends Stat {
    Id id;
    LinkedList<Case> caseList;

    public SwitchStat(int leftLocation, int rightLocation, Id id, LinkedList<Case> caseList) {
        super(leftLocation, rightLocation);
        this.id = id;
        this.caseList = caseList;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public LinkedList<Case> getCaseList() {
        return caseList;
    }

    public void setCaseList(LinkedList<Case> caseList) {
        this.caseList = caseList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
