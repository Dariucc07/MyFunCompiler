package syntax;

import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class Main extends AstNode{

    private LinkedList<VarDecl> varDeclList;
    private LinkedList<Stat> statList;

    public Main(int leftLocation, int rightLocation, LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList) {
        super(leftLocation, rightLocation);
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
        return visitor.visit(this, arg);
    }
}
