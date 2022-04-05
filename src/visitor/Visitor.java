package visitor;

import syntax.Fun;
import syntax.Main;
import syntax.ParDecl;
import syntax.Program;

import syntax.expr.*;
import syntax.expr.binaryexpr.arithop.*;
import syntax.expr.binaryexpr.relop.*;
import syntax.expr.binaryexpr.stringop.StringConcatOp;
import syntax.expr.unaryexpr.MinusExpr;
import syntax.expr.unaryexpr.NotExpr;
import syntax.expr.unaryexpr.OutParIdExpr;
import syntax.expr.unaryexpr.ParExpr;
import syntax.statement.*;
import syntax.statement.WriteOps.WriteBOp;
import syntax.statement.WriteOps.WriteLnOp;
import syntax.statement.WriteOps.WriteOp;
import syntax.statement.WriteOps.WriteTOp;
import syntax.type.PrimitiveType;

public interface Visitor<T, P> {
    //to addd: Program, VarDecl ecc.
    T visit(Program program, P arg);

    //T visit(Id id, P arg);

    /* Signature for binaryexpr.arithop */
    T visit(PlusOp plusOp, P arg);

    T visit(MinusOp minusOp, P arg);

    T visit(TimesOp timesOp, P arg);

    T visit(DivOp divOp, P arg);

    T visit(DivIntOp divIntOp, P arg);

    T visit(PowOp powOp, P arg);

    /* Signature for binaryexpr.stringop */

    T visit(StringConcatOp stringConcatOp, P arg);

    /* Signature for binaryexpr.relop */

    T visit(AndRelop andRelop, P arg);

    T visit(OrRelop orRelop, P arg);

    T visit(NotEqualRelop notEqualRelop, P arg);

    T visit(EqualRelop equalRelop, P arg);

    T visit(GreaterThanRelop greaterThanRelop, P arg);

    T visit(GreaterEqualRelop greaterEqualRelop, P arg);

    T visit(LessThanRelop lessThanRelop, P arg);

    T visit(LessEqualRelop lessEqualRelop, P arg);

    /* Signature for Const value */

    T visit(BoolConst boolConst, P arg);

    T visit(IntegerConst integerConst, P arg);

    T visit(RealConst realConst, P arg);

    T visit(StringConst stringConst, P arg);

    /* Signature for Id class */

    T visit(Id id, P arg);

    /* Signature for CallFunction */

    T visit(CallFunction callFunction, P arg);

    /*Signature for UnaryOp elements */

    T visit(MinusExpr minusExpr, P arg);

    T visit(NotExpr notExpr, P arg);

    T visit(ParExpr parExpr, P arg);

    T visit(OutParIdExpr outParIdExpr, P arg);

    /* Signature for Expression */

    T visit(IdInitOp idInitOp, P arg);

    T visit(Const constant, P arg);

    T visit(IdInitObblOp idInitObblOp, P arg);

    /*Signature for type*/

    T visit(PrimitiveType primitiveType, P arg);

    /* Signature for ParDecl*/

    T visit(ParDecl parDecl, P arg);
    /* Signature for ElseOp*/
    T visit(ElseOp elseOp, P arg);

    T visit(IfStat ifStat, P arg);

    T visit(WhileStat whileStat,P arg);

    T visit(ReadStat readStat, P arg);

    T visit(AssignStat assignStat, P arg);

    T visit(ReturnOp returnOp,P arg);

    T visit(WriteOp writeOp, P arg);

    T visit(WriteLnOp writeLnOp, P arg);

    T visit(WriteTOp writeTOp, P arg);

    T visit(WriteBOp writeBOp, P arg);

    T visit(Fun fun, P arg);

    T visit(Main main, P arg);

    T visit(CallFunctionStat callFunctionStat, P arg);

    T visit(VarDecl varDecl, P arg);

    //added for simulation of the exam
    T visit(ElseLoopOp elseLoopOp, P arg);


}
