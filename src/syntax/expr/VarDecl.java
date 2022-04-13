package syntax.expr;

import syntax.AstNode;
import syntax.Expr;
import syntax.Type;
import visitor.Visitor;

import java.util.LinkedList;

public class VarDecl extends AstNode {

    private Type type;
    private LinkedList<IdInitOp> idListInitOp;
    private LinkedList<IdInitObblOp> idListInitObblOp;
    private boolean var;

    private LinkedList<Id> idList;
    private Id id;
    private LinkedList<Expr> exprList;

    public VarDecl(int leftLocation, int rightLocation, Type type, LinkedList<IdInitOp> idListInitOp) {
        super(leftLocation, rightLocation);
        this.var = false;
        this.type = type;
        this.idListInitOp = idListInitOp;
    }

    public VarDecl(int leftLocation, int rightLocation,boolean var, LinkedList<IdInitObblOp> idListInitObblOp){
        super(leftLocation, rightLocation);
        this.var = var;
        this.idListInitObblOp = idListInitObblOp;
    }

    public VarDecl(int leftLocation, int rightLocation, boolean var, LinkedList<Id> idList, Id id, LinkedList<Expr> exprList) {
        super(leftLocation, rightLocation);
        this.var = var;
        this.idList = idList;
        this.id = id;
        this.exprList = exprList;
    }

    public Type getType() {
        return type;
    }

    public LinkedList<IdInitOp> getIdListInitOp() {
        return idListInitOp;
    }

    public LinkedList<IdInitObblOp> getIdListInitObblOp() {
        return idListInitObblOp;
    }

    public boolean isVar() {
        return var;
    }

    public LinkedList<Id> getIdList() {
        return idList;
    }

    public void setIdList(LinkedList<Id> idList) {
        this.idList = idList;
    }

    public LinkedList<Expr> getExprList() {
        return exprList;
    }

    public void setExprList(LinkedList<Expr> exprList) {
        this.exprList = exprList;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
