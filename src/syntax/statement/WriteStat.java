package syntax.statement;

import syntax.AstNode;
import syntax.Stat;
import visitor.Visitor;

public abstract class WriteStat extends Stat {

    public WriteStat(int leftLocation, int rightLocation) {
        super(leftLocation, rightLocation);
    }
}
