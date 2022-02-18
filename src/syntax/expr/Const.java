package syntax.expr;

import syntax.AstNode;
import visitor.Visitor;
import syntax.Expr;
public class Const extends AstNode {

    private IntegerConst integerConst;
    private StringConst stringConst;
    private RealConst realConst;
    private BoolConst boolConst;

    public Const(int leftLocation, int rightLocation, IntegerConst integerConst){
        super(leftLocation, rightLocation);
        this.integerConst = integerConst;
    }

    public Const(int leftLocation, int rightLocation, StringConst stringConst){
        super(leftLocation, rightLocation);
        this.stringConst = stringConst;
    }

    public Const(int leftLocation, int rightLocation, RealConst realConst){
        super(leftLocation, rightLocation);
        this.realConst = realConst;
    }

    public Const(int leftLocation, int rightLocation, BoolConst boolConst){
        super(leftLocation, rightLocation);
        this.boolConst = boolConst;
    }

    public Expr getConst(){
        if(integerConst!=null){
            return integerConst;
        }
        if(stringConst!=null){
            return stringConst;
        }
        if(realConst!=null){
            return realConst;
        }
        if(boolConst!=null){
            return boolConst;
        }
        return integerConst;
    }

    public IntegerConst getIntegerConst() {
        return integerConst;
    }

    public StringConst getStringConst() {
        return stringConst;
    }

    public RealConst getRealConst() {
        return realConst;
    }

    public BoolConst getBoolConst() {
        return boolConst;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
