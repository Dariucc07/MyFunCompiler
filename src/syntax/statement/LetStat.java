package syntax.statement;

import syntax.AstNode;
import syntax.Stat;
import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class LetStat extends Stat {



    private LinkedList<VarDecl> varDeclList;
    private LinkedList<Stat> statList;



    public LetStat(int leftLocation, int rightLocation, LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList) {
        super(leftLocation, rightLocation);
        this.varDeclList = varDeclList;
        this.statList = statList;
    }

    public LinkedList<VarDecl> getVarDeclList() {
        return varDeclList;
    }

    public void setVarDeclList(LinkedList<VarDecl> varDeclList) {
        this.varDeclList = varDeclList;
    }

    public LinkedList<Stat> getStatList() {
        return statList;
    }

    public void setStatList(LinkedList<Stat> statList) {
        this.statList = statList;
    }
    //TODO
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
