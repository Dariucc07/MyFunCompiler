package syntax.statement;

import syntax.AstNode;
import syntax.Stat;
import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class ElseOp extends Stat {
    LinkedList<VarDecl> varDeclList;
    LinkedList<Stat> statList;


    public ElseOp(int leftLocation,int rightLocation,LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList) {
        super(leftLocation,rightLocation);
        this.varDeclList = varDeclList;
        this.statList = statList;
    }

    public LinkedList<VarDecl> getVarDeclList() {
        return varDeclList;
    }

    public LinkedList<Stat> getStatList() {
        return statList;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this,arg);
    }
}
