package syntax.statement;

import syntax.AstNode;
import syntax.Expr;
import syntax.Stat;
import syntax.expr.Id;
import visitor.Visitor;

import java.util.LinkedList;

public class ReadStat extends Stat {
    private LinkedList<Id> idList;
    private Expr expr;

    public ReadStat(int leftLocation, int rightLocation, LinkedList<Id> idList, Expr expr) {
        super(leftLocation, rightLocation);
        this.idList = idList;
        this.expr = expr;
    }

    public ReadStat(int leftLocation, int rightLocation, LinkedList<Id> idList) {
        super(leftLocation, rightLocation);
        this.idList = idList;
    }

    public LinkedList<Id> getIdList() {
        return idList;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
