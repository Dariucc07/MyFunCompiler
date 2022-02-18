package syntax.statement;

import syntax.Stat;
import syntax.expr.CallFunction;
import visitor.Visitor;

public class CallFunctionStat extends Stat {

    private CallFunction callFunction;

    public CallFunctionStat(int leftlocation, int rightlocation, CallFunction callFunction) {
        super(leftlocation, rightlocation);
        this.callFunction = callFunction;
    }

    public CallFunction getCallFunction() {
        return callFunction;
    }

    @Override
    public <T, P> T accept(Visitor<T, P> visitor, P arg) {
        return visitor.visit(this, arg);
    }
}
