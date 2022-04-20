package syntax.expr;

import syntax.AstNode;
import syntax.type.PrimitiveType;
import visitor.Visitor;
import syntax.Expr;
public class Const extends AstNode {

    private IntegerConst integerConst;
    private StringConst stringConst;
    private RealConst realConst;
    private BoolConst boolConst;
    private CharConst charConst;
    private PrimitiveType type;


    public Const(int leftLocation, int rightLocation, CharConst charConst) {
        super(leftLocation, rightLocation);
        type = new PrimitiveType(leftLocation,rightLocation,"CHAR");
        this.charConst = charConst;
    }

    public Const(int leftLocation, int rightLocation, IntegerConst integerConst){
        super(leftLocation, rightLocation);
        type = new PrimitiveType(leftLocation,rightLocation,"INTEGER");
        this.integerConst = integerConst;
    }

    public Const(int leftLocation, int rightLocation, StringConst stringConst){
        super(leftLocation, rightLocation);
        type = new PrimitiveType(leftLocation,rightLocation,"STRING");
        this.stringConst = stringConst;
    }

    public Const(int leftLocation, int rightLocation, RealConst realConst){
        super(leftLocation, rightLocation);
        type = new PrimitiveType(leftLocation,rightLocation,"REAL");
        this.realConst = realConst;
    }

    public Const(int leftLocation, int rightLocation, BoolConst boolConst){
        super(leftLocation, rightLocation);
        type = new PrimitiveType(leftLocation,rightLocation,"BOOL");
        this.boolConst = boolConst;
    }

    public PrimitiveType getType() {
        return type;
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
        if(charConst!=null){
            return charConst;
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

    public CharConst getCharConst() {
        return charConst;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
