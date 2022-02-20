package syntax;

import nodetype.CompositeNodeType;
import nodetype.NodeType;
import syntax.expr.Id;
import syntax.expr.VarDecl;
import syntax.type.PrimitiveType;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.LinkedList;

/*This is the class relative to a function definition:
    Fun ::= FUN ID LPAR ParamDeclList RPAR COLON Type
		VarDeclList StatList END FUN SEMI
	| FUN ID LPAR ParamDeclList RPAR
		VarDeclList StatList END FUN SEMI;
     */

public class Fun extends AstNode{
    private Id id;
    private LinkedList<ParDecl> paramDeclList;
    private Type type;
    private LinkedList<VarDecl> varDeclList;
    private LinkedList<Stat> statList;

    public Fun(int leftLocation, int rightLocation, Id id, LinkedList<ParDecl> paramDeclList, Type type, LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList) {
        super(leftLocation, rightLocation);
        this.id=id;
        this.paramDeclList = paramDeclList;
        this.type = type;
        this.varDeclList = varDeclList;
        this.statList = statList;
    }

    public Fun(int leftLocation, int rightLocation,Id id,  LinkedList<ParDecl> paramDeclList, LinkedList<VarDecl> varDeclList, LinkedList<Stat> statList) {
        super(leftLocation, rightLocation);
        this.id = id;
        this.paramDeclList = paramDeclList;
        this.varDeclList = varDeclList;
        this.statList = statList;
        this.type= new PrimitiveType(leftLocation,rightLocation,"NULL");
    }

    public Id getId() {
        return id;
    }

    public LinkedList<ParDecl> getParamDeclList() {
        return paramDeclList;
    }

    public Type getType() {
        return type;
    }

    public LinkedList<VarDecl> getVarDeclList() {
        return varDeclList;
    }

    public LinkedList<Stat> getStatList() {
        return statList;
    }

    public CompositeNodeType getParamNodeType() {
        CompositeNodeType compositeNodeType = new CompositeNodeType(new ArrayList<>());
        this.getParamDeclList().forEach(parDecl -> {
            compositeNodeType.addNodeType(parDecl.getType().typeFactory());
        });
        return compositeNodeType;
    }

    public NodeType getFunctionNodeType() {
        return this.getType().typeFactory();
    }
    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }

}
