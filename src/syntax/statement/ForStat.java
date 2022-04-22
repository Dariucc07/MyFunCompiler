package syntax.statement;

import syntax.Stat;
import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class ForStat extends Stat{

    private VarDecl varDecl;
    private LinkedList<Stat> statList;
    private For forStat;

    public ForStat(int leftlocation, int rightlocation, VarDecl varDecl, LinkedList<Stat> statList, For forStat) {
        super(leftlocation, rightlocation);
        this.varDecl = varDecl;
        this.statList = statList;
        this.forStat = forStat;
    }


    public VarDecl getVarDecl() {
        return varDecl;
    }

    public void setVarDecl(VarDecl varDecl) {
        this.varDecl = varDecl;
    }

    public LinkedList<Stat> getStatList() {
        return statList;
    }

    public void setStatList(LinkedList<Stat> statList) {
        this.statList = statList;
    }

    public For getForStat() {
        return forStat;
    }

    public void setForStat(For forStat) {
        this.forStat = forStat;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
