package visitor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import syntax.*;
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

import java.util.Collections;
import java.util.function.Consumer;

public class ConcreteXMLVisitor implements Visitor<Element, Document> {

    private Consumer<? super AstNode> addParent(Element parent, Document arg){
        return (AstNode node) -> parent.appendChild(node.accept(this, arg));
    }


    @Override
    public Element visit(Program program, Document arg) {
        Element element = arg.createElement("Program");
        program.getVarDeclList().forEach(addParent(element, arg));
        program.getFunList().forEach(addParent(element, arg));
        element.appendChild(program.getMain().accept(this, arg));
        arg.appendChild(element);
        return element;
    }

    @Override
    public Element visit(PlusOp plusOp, Document arg) {
        Element element = arg.createElement("PlusOp");
        element.appendChild(plusOp.getLeftOperand().accept(this, arg));
        element.appendChild(plusOp.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(MinusOp minusOp, Document arg) {
        Element element = arg.createElement("MinusOp");
        element.appendChild(minusOp.getLeftOperand().accept(this, arg));
        element.appendChild(minusOp.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(TimesOp timesOp, Document arg) {
        Element element = arg.createElement("TimesOp");
        element.appendChild(timesOp.getLeftOperand().accept(this, arg));
        element.appendChild(timesOp.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(DivOp divOp, Document arg) {
        Element element = arg.createElement("DivOp");
        element.appendChild(divOp.getLeftOperand().accept(this, arg));
        element.appendChild(divOp.getLeftOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(DivIntOp divIntOp, Document arg) {
        Element element = arg.createElement("DivIntOp");
        element.appendChild(divIntOp.getLeftOperand().accept(this, arg));
        element.appendChild(divIntOp.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(PowOp powOp, Document arg) {
        Element element = arg.createElement("PowOp");
        element.appendChild(powOp.getBaseOperand().accept(this, arg));
        element.appendChild(powOp.getExponentOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(StringConcatOp stringConcatOp, Document arg) {
        Element element= arg.createElement("StringConcatOp");
        element.appendChild(stringConcatOp.getLeftOperand().accept(this, arg));
        element.appendChild(stringConcatOp.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(AndRelop andRelop, Document arg) {
        Element element = arg.createElement("AndRelop");
        element.appendChild(andRelop.getLeftOperand().accept(this, arg));
        element.appendChild(andRelop.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(OrRelop orRelop, Document arg) {
        Element element = arg.createElement("OrRelop");
        element.appendChild(orRelop.getLeftOperand().accept(this, arg));
        element.appendChild(orRelop.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(NotEqualRelop notEqualRelop, Document arg) {
        Element element = arg.createElement("NotEqualRelop");
        element.appendChild(notEqualRelop.getLeftOperand().accept(this, arg));
        element.appendChild(notEqualRelop.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(EqualRelop equalRelop, Document arg) {
        Element element = arg.createElement("EqualRelop");
        element.appendChild(equalRelop.getLeftOperand().accept(this, arg));
        element.appendChild(equalRelop.getRightOperand().accept(this, arg));
        return element;

    }

    @Override
    public Element visit(GreaterThanRelop greaterThanRelop, Document arg) {
        Element element = arg.createElement("GreaterThanRelop");
        element.appendChild(greaterThanRelop.getLeftOperand().accept(this, arg));
        element.appendChild(greaterThanRelop.getRightOperand().accept(this, arg));
        return element;

    }

    @Override
    public Element visit(GreaterEqualRelop greaterEqualRelop, Document arg) {
        Element element = arg.createElement("GreaterEqualRelop");
        element.appendChild(greaterEqualRelop.getLeftOperand().accept(this, arg));
        element.appendChild(greaterEqualRelop.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(LessThanRelop lessThanRelop, Document arg) {
        Element element = arg.createElement("LessThanRelop");
        element.appendChild(lessThanRelop.getLeftOperand().accept(this, arg));
        element.appendChild(lessThanRelop.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(LessEqualRelop lessEqualRelop, Document arg) {
        Element element = arg.createElement("LessEqualRelop");
        element.appendChild(lessEqualRelop.getLeftOperand().accept(this, arg));
        element.appendChild(lessEqualRelop.getRightOperand().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(BoolConst boolConst, Document arg) {

        Element element = arg.createElement("BoolConst");
        element.setAttribute("value", String.valueOf(boolConst.getValue()));
        return element;
    }

    @Override
    public Element visit(IntegerConst integerConst, Document arg) {
        Element element = arg.createElement("IntegerConst");
        element.setAttribute("value", String.valueOf(integerConst.getValue()));
        return element;
    }

    @Override
    public Element visit(RealConst realConst, Document arg) {
            Element element = arg.createElement("RealConst");
        element.setAttribute("value", String.valueOf(realConst.getValue()));
        return element;
    }

    @Override
    public Element visit(StringConst stringConst, Document arg) {
        Element element = arg.createElement("StringConst");
        element.setAttribute("value", stringConst.getValue());
        return element;
    }

    @Override
    public Element visit(Id id, Document arg) {
        Element element = arg.createElement("Id");
        element.setAttribute("lexeme", id.getValue());
        return element;

    }

    @Override
    public Element visit(CallFunction callFunction, Document arg) {
        Element element = arg.createElement("CallFunction");
        element.appendChild(callFunction.getId().accept(this, arg));

            callFunction.getExprList().forEach(addParent(element, arg));

        return element;
    }

    @Override
    public Element visit(MinusExpr minusExpr, Document arg) {
        Element element = arg.createElement("MinusExpr");
        element.appendChild(minusExpr.getExpr().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(NotExpr notExpr, Document arg) {
        Element element = arg.createElement("NotExpr");
        element.appendChild(notExpr.getExpr().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(ParExpr parExpr, Document arg) {
        Element element = arg.createElement("ParExpr");
        element.appendChild(parExpr.getExpr().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(OutParIdExpr outParIdExpr, Document arg) {
        Element element = arg.createElement("OutParIdExpr");
        element.appendChild(outParIdExpr.getId().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(IdInitOp idInitOp, Document arg) {
        Element element = arg.createElement("IdInitOp");
        element.appendChild(idInitOp.getId().accept(this, arg));
        if(idInitOp.getExpr() != null) {
            element.appendChild(idInitOp.getExpr().accept(this, arg));
        }
        return element;
    }

    @Override
    public Element visit(Const constant, Document arg) {
        Element element = arg.createElement("Const");
        element.appendChild(constant.getConst().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(IdInitObblOp idInitObblOp, Document arg) {
        Element element = arg.createElement("IdInitObblOp");
        element.appendChild(idInitObblOp.getId().accept(this, arg));
        element.appendChild(idInitObblOp.getConstant().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(PrimitiveType primitiveType, Document arg) {
        Element element = arg.createElement("PrimitiveType");
        element.setAttribute("type",primitiveType.getType() );
        return element;
    }

    @Override
    public Element visit(ParDecl parDecl, Document arg) {
        Element element = arg.createElement("ParDecl");
        element.setAttribute("out",parDecl.isOut()+"" );
        element.appendChild(parDecl.getType().accept(this, arg));
        element.appendChild(parDecl.getId().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(ElseOp elseOp, Document arg) {
        Element element = arg.createElement("ElseOp");
        elseOp.getVarDeclList().forEach(addParent(element, arg));
        elseOp.getStatList().forEach(addParent(element, arg));
        return element;
    }

    @Override
    public Element visit(IfStat ifStat, Document arg) {
        Element element = arg.createElement("IfStat");
        element.appendChild(ifStat.getExpr().accept(this, arg));
        ifStat.getVarDeclList().forEach(addParent(element, arg));
        ifStat.getStatList().forEach(addParent(element, arg));
        if(ifStat.getElseOp()!=null)
            element.appendChild(ifStat.getElseOp().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(WhileStat whileStat, Document arg) {
        Element element = arg.createElement("WhileStat");
        element.appendChild(whileStat.getExpr().accept(this, arg));
        whileStat.getVarDeclList().forEach(addParent(element, arg));
        whileStat.getStatList().forEach(addParent(element, arg));
        return element;
    }

    @Override
    public Element visit(ForStat forStat, Document arg) {
        Element element = arg.createElement("ForStat");
        element.appendChild(forStat.getVarDecl().accept(this, arg));
        element.appendChild(forStat.getExpr().accept(this, arg));
        forStat.getStatList().forEach(addParent(element, arg));

        forStat.getVarDeclInside().forEach(addParent(element, arg));
        forStat.getStatListInside().forEach(addParent(element, arg));
        return element;
    }

    @Override
    public Element visit(ReadStat readStat, Document arg) {
        Element element = arg.createElement("ReadStat");
        readStat.getIdList().forEach(addParent(element, arg));
        if(readStat.getExpr() != null) {
            element.appendChild(readStat.getExpr().accept(this, arg));
        }
        return element;
    }

    @Override
    public Element visit(AssignStat assignStat, Document arg) {
        Element element = arg.createElement("AssignStat");
        element.appendChild(assignStat.getId().accept(this, arg));
        element.appendChild(assignStat.getExpr().accept(this, arg));
        return element;
    }

    @Override
    public Element visit(ReturnOp returnOp, Document arg) {
        Element element = arg.createElement("ReturnOp");
        element.appendChild(returnOp.getExpr().accept(this,arg));
        return element;
    }

    @Override
    public Element visit(WriteOp writeOp, Document arg) {
        Element element = arg.createElement("WriteOp");
        element.appendChild(writeOp.getExpr().accept(this,arg));
        return element;
    }

    @Override
    public Element visit(WriteLnOp writeLnOp, Document arg) {
        Element element = arg.createElement("WriteLnOp");
        element.appendChild(writeLnOp.getExpr().accept(this,arg));
        return element;
    }

    @Override
    public Element visit(WriteTOp writeTOp, Document arg) {
        Element element = arg.createElement("WriteTOp");
        element.appendChild(writeTOp.getExpr().accept(this,arg));
        return element;
    }

    @Override
    public Element visit(WriteBOp writeBOp, Document arg) {
        Element element = arg.createElement("WriteBOp");
        element.appendChild(writeBOp.getExpr().accept(this,arg));
        return element;
    }

    @Override
    public Element visit(Fun fun, Document arg) {
        Element element = arg.createElement("Fun");
        element.appendChild(fun.getId().accept(this, arg));
        fun.getParamDeclList().forEach(addParent(element, arg));
        if(fun.getType() != null) {
            element.appendChild(fun.getType().accept(this, arg));
        }
        fun.getVarDeclList().forEach(addParent(element, arg));
        fun.getStatList().forEach(addParent(element, arg));
        return element;
    }

    @Override
    public Element visit(Main main, Document arg) {
        Element element = arg.createElement("Main");
        //Collections.reverse(main.getVarDeclList());
        main.getVarDeclList().forEach(addParent(element, arg));
        //Collections.reverse(main.getStatList());
        main.getStatList().forEach(addParent(element, arg));
        return element;
    }



    @Override
    public Element visit(CallFunctionStat callFunctionStat, Document arg) {
        Element element = arg.createElement("CallFunctionStat");
        element.appendChild(callFunctionStat.getCallFunction().accept(this,arg));
        return element;
    }

    @Override
    public Element visit(VarDecl varDecl, Document arg) {
        Element element = arg.createElement("VarDecl");

        element.setAttribute("isVar", String.valueOf(varDecl.isVar()));
        if(!varDecl.isVar()) {
            element.appendChild(varDecl.getType().accept(this, arg));
        }
        if(varDecl.getIdListInitOp() != null) {
            //Collections.reverse(varDecl.getIdListInitOp());
            varDecl.getIdListInitOp().forEach(addParent(element, arg));
        }
        if(varDecl.getIdListInitObblOp() != null) {
            varDecl.getIdListInitObblOp().forEach(addParent(element, arg));
        }
        return element;

    }


}
