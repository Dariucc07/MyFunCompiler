package syntax;

import syntax.expr.VarDecl;
import visitor.Visitor;

import java.util.LinkedList;

public class Program extends AstNode{

    private LinkedList<VarDecl> varDeclList;
    private LinkedList<Fun> funList;
    private Main main;

    public Program(int leftLocation, int rightLocation, LinkedList<VarDecl> varDeclList, LinkedList<Fun> funList, Main main) {
        super(leftLocation, rightLocation);
        this.varDeclList = varDeclList;
        this.funList = funList;
        this.main = main;
    }

    public LinkedList<VarDecl> getVarDeclList() {
        return varDeclList;
    }

    public LinkedList<Fun> getFunList() {
        return funList;
    }

    public Main getMain() {
        return main;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
