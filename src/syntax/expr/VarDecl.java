package syntax.expr;

import syntax.AstNode;
import syntax.Type;
import visitor.Visitor;

import java.util.LinkedList;

public class VarDecl extends AstNode {

    private Type type;
    private LinkedList<IdInitOp> idListInitOp;
    private LinkedList<IdInitObblOp> idListInitObblOp;


    private IdInitMore idInitMore;
    private boolean var;

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
    public VarDecl(int leftLocation, int rightLocation, IdInitMore idInitMore, boolean var) {
        super(leftLocation, rightLocation);
        this.idInitMore = idInitMore;
        this.var = var;
    }

    public IdInitMore getIdInitMore() {
        return idInitMore;
    }

    public void setIdListInitMore(IdInitMore idListInitMore) {
        this.idInitMore = idListInitMore;
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

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
