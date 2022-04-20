package visitor;

import nodekind.NodeKind;
import nodetype.CompositeNodeType;
import nodetype.FunctionNodeType;
import nodetype.NodeType;
import nodetype.OutParPrimitiveNoteType;
import semantic.SymbolTable;
import semantic.SymbolTableRecord;
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

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

public class ScopeCheckerVisitor implements Visitor<Boolean, SymbolTable>{



    private boolean checkContext(List<? extends AstNode> nodes, SymbolTable arg) {
        if((nodes==null) || nodes.isEmpty()){
            return true;
        }
        else { //return nodes.stream().allMatch(node ->node.accept(this, arg));
            boolean valid=true;
            for(AstNode node : nodes){
                if(!node.accept(this,arg)){
                    valid=false;
                }
            }
            return valid;

        }
    }



    private AstNode signalContext(List<? extends AstNode> nodes, SymbolTable arg) {
        if((nodes==null) || nodes.isEmpty()){
            return null;
        }
        else {
            boolean valid=true;
            for(AstNode node : nodes){
                if(!node.accept(this,arg)){
                    return node;
                }
            }
            return null;

        }
    }

    /*Program ::= VarDeclList:varDeclList FunList:funList Main:main  */
    @Override
    public Boolean visit(Program program, SymbolTable arg) {
        arg.enterScope();

        boolean areVarDeclListvalid = this.checkContext(program.getVarDeclList(),arg);
        for (Fun f : program.getFunList()){
            f.getParamNodeType();
            arg.addEntry(f.getId().getValue(), new SymbolTableRecord( f.getId().getValue(),new FunctionNodeType(f.getParamNodeType(), f.getFunctionNodeType()),NodeKind.FUNCTION));
        }
        boolean areFunListValid = this.checkContext(program.getFunList(),arg);

        boolean isMainValid = (program.getMain() != null) ? program.getMain().accept(this, arg) : true;
        boolean isProgramValid = areVarDeclListvalid && areFunListValid && isMainValid;
        arg.exitScope();
        return isProgramValid;
    }

    @Override
    public Boolean visit(PlusOp plusOp, SymbolTable arg) {
        return binaryExprVisitation(plusOp.getLeftOperand(), plusOp.getRightOperand(), arg);
    }

    @Override
    public Boolean visit(MinusOp minusOp, SymbolTable arg) {
        return binaryExprVisitation(minusOp.getLeftOperand(), minusOp.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(TimesOp timesOp, SymbolTable arg) {
        return binaryExprVisitation(timesOp.getLeftOperand(), timesOp.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(DivOp divOp, SymbolTable arg) {
        return binaryExprVisitation(divOp.getLeftOperand(), divOp.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(DivIntOp divIntOp, SymbolTable arg) {
        return binaryExprVisitation(divIntOp.getLeftOperand(), divIntOp.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(PowOp powOp, SymbolTable arg) {
        return binaryExprVisitation(powOp.getBaseOperand(), powOp.getExponentOperand(), arg);

    }

    @Override
    public Boolean visit(StringConcatOp stringConcatOp, SymbolTable arg) {
        return binaryExprVisitation(stringConcatOp.getLeftOperand(), stringConcatOp.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(AndRelop andRelop, SymbolTable arg) {
        return binaryExprVisitation(andRelop.getLeftOperand(), andRelop.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(OrRelop orRelop, SymbolTable arg) {
        return binaryExprVisitation(orRelop.getLeftOperand(), orRelop.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(NotEqualRelop notEqualRelop, SymbolTable arg) {
        return binaryExprVisitation(notEqualRelop.getLeftOperand(), notEqualRelop.getRightOperand(), arg);
    }

    @Override
    public Boolean visit(EqualRelop equalRelop, SymbolTable arg) {
        return binaryExprVisitation(equalRelop.getLeftOperand(), equalRelop.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(GreaterThanRelop greaterThanRelop, SymbolTable arg) {
        return binaryExprVisitation(greaterThanRelop.getLeftOperand(), greaterThanRelop.getRightOperand(), arg);
    }

    @Override
    public Boolean visit(GreaterEqualRelop greaterEqualRelop, SymbolTable arg) {
        return binaryExprVisitation(greaterEqualRelop.getLeftOperand(), greaterEqualRelop.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(LessThanRelop lessThanRelop, SymbolTable arg) {
        return binaryExprVisitation(lessThanRelop.getLeftOperand(), lessThanRelop.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(LessEqualRelop lessEqualRelop, SymbolTable arg) {
        return binaryExprVisitation(lessEqualRelop.getLeftOperand(), lessEqualRelop.getRightOperand(), arg);

    }

    @Override
    public Boolean visit(BoolConst boolConst, SymbolTable arg) {
        return true;
    }

    @Override
    public Boolean visit(IntegerConst integerConst, SymbolTable arg) {
        return true;
    }

    @Override
    public Boolean visit(RealConst realConst, SymbolTable arg) {
        return true;
    }

    @Override
    public Boolean visit(StringConst stringConst, SymbolTable arg) {
        return true;
    }
    
    @Override
    public Boolean visit(Id id, SymbolTable arg) {
        if(id.isParDecl() == true){
            return arg.lookupKind(id.getValue(), NodeKind.VARIABLE).isPresent();
        }
        if(id.isFunction() == true){
            return arg.lookupKind(id.getValue(), NodeKind.FUNCTION).isPresent();
        }
        return arg.lookup(id.getValue()).isPresent();
    }


    @Override
    public Boolean visit(CallFunction callFunction, SymbolTable arg) {
        boolean isIdValid = callFunction.getId().accept(this, arg);

        boolean areExprListValid = this.checkContext(callFunction.getExprList(),arg);
        Optional<SymbolTableRecord> str = arg.lookup(callFunction.getId().getValue());
        FunctionNodeType fnt = (FunctionNodeType) str.get().getNodeType();
        CompositeNodeType cnt = fnt.getParamsType();
        boolean isCallFunctionValid = isIdValid && areExprListValid;
        if(!isIdValid){
            throw new RuntimeException("Function with id:"+callFunction.getId().getValue() +"doesn't exists!");
        }
        if(str.get().getKind() == NodeKind.FUNCTION){
            if(callFunction.getExprList().size() != cnt.getTypes().size()){
                throw new RuntimeException("Trying to call " + callFunction.getId().getValue() +"()" +  " with " + callFunction.getExprList().size() + " parameter/s but it was defined with " + cnt.getTypes().size());
            }
            /*
            for(Expr parameter : callFunction.getExprList().){
                if(parameter.getType() == ( str.get().getNodeType())
            }

             */
        }
        return isCallFunctionValid;
    }

    @Override
    public Boolean visit(MinusExpr minusExpr, SymbolTable arg) {
        boolean isExprValid = minusExpr.getExpr().accept(this, arg);
        if(!isExprValid){
            throw new RuntimeException("Id:"+minusExpr.getExpr().toString()+" doesn't exists!");
        }
        return isExprValid;
    }

    @Override
    public Boolean visit(NotExpr notExpr, SymbolTable arg) {
        boolean isExprValid = notExpr.getExpr().accept(this, arg);
        if(!isExprValid){
            throw new RuntimeException("Id:"+notExpr.getExpr().toString()+" doesn't exists!");
        }
        return isExprValid;
    }

    @Override
    public Boolean visit(ParExpr parExpr, SymbolTable arg) {
        boolean isExprValid = parExpr.getExpr().accept(this, arg);
        if(!isExprValid){
            throw new RuntimeException("Id:"+parExpr.getExpr().toString()+" doesn't exists!");
        }
        return isExprValid;
    }

    @Override
    public Boolean visit(OutParIdExpr outParIdExpr, SymbolTable arg) {
        boolean isExprValid = outParIdExpr.getId().accept(this, arg);
        if(!isExprValid){
            throw new RuntimeException("Id:"+outParIdExpr.getId().toString()+" doesn't exists!");
        }
        return isExprValid;
    }

    /*IdList: ID:id
	| IdListInit:idInitOpList COMMA ID:id                                 {:idInitOpList.add(new IdInitOp(idleft,idright, new Id(idleft, idright, id))); RESULT = idInitOpList;:}
	| ID:id ASSIGN Expr:expr
	| IdListInit:idListInit COMMA ID:id ASSIGN Expr:expr*/
    @Override
    public Boolean visit(IdInitOp idInitOp, SymbolTable arg) {
        boolean isIdValid = idInitOp.getId().accept(this, arg);
        boolean isExprValid = (idInitOp.getExpr() != null) ? idInitOp.getExpr().accept(this, arg) : true;
        boolean isIdInitOpValid = !isIdValid && isExprValid;
        if(isIdValid){
            throw new RuntimeException("Id:"+idInitOp.getId().getValue() +" already exists");
        }
        return isIdInitOpValid;
    }

    @Override
    public Boolean visit(Const constant, SymbolTable arg) {
        return true;
    }

    /* */
    @Override
    public Boolean visit(IdInitObblOp idInitObblOp, SymbolTable arg) {
        boolean isIdValid = (idInitObblOp.getId() != null) ? idInitObblOp.getId().accept(this, arg) : true;
        boolean isConstantValid = idInitObblOp.getConstant().accept(this, arg);
        boolean isIdInitObblOpValid = !isIdValid && isConstantValid;
        if(isIdValid){
            throw new RuntimeException("Id:"+idInitObblOp.getId().getValue() +" already exists");
        }
        return isIdInitObblOpValid;
    }

    @Override
    public Boolean visit(PrimitiveType primitiveType, SymbolTable arg) {
        return true;
    }

    @Override
    public Boolean visit(ParDecl parDecl, SymbolTable arg) {
        if(parDecl.getId() != null){
            parDecl.getId().setParDecl(true);
            parDecl.getId().setFunction(false);
        }
        boolean isIdValid = (parDecl.getId() != null) ?  parDecl.getId().accept(this, arg) : true;
        boolean isTypeValid = (parDecl.getType() != null) ? parDecl.getType().accept(this, arg) : true;
        boolean isParDeclValid = !isIdValid && isTypeValid;
        if(isIdValid){
            throw new RuntimeException("Id:"+parDecl.getId().getValue() +" already exists");
        }
        if(parDecl.isOut())
            arg.addEntry(parDecl.getId().getValue(), new SymbolTableRecord(parDecl.getId().getValue(), new OutParPrimitiveNoteType(parDecl.getType().typeFactory()), NodeKind.OUTVARIABLE));
        else
            arg.addEntry(parDecl.getId().getValue(), new SymbolTableRecord(parDecl.getId().getValue(), parDecl.getType().typeFactory(), NodeKind.VARIABLE));
        return isParDeclValid;
    }

    @Override
    public Boolean visit(ElseOp elseOp, SymbolTable arg) {
        arg.enterScope();
        boolean areVarDeclListValid = this.checkContext(elseOp.getVarDeclList(),arg);
        boolean areStatListValid = this.checkContext(elseOp.getStatList(),arg);
        boolean isElseValid = areVarDeclListValid &areStatListValid;
        arg.exitScope();
        return isElseValid;
    }

    @Override
    public Boolean visit(IfStat ifStat, SymbolTable arg) {
        arg.enterScope();
        boolean isExprValid = (ifStat.getExpr() != null) ? ifStat.getExpr().accept(this, arg) : true;
        boolean areVarDeclListValid = this.checkContext(ifStat.getVarDeclList(),arg);
        boolean areStatListValid = this.checkContext(ifStat.getStatList(),arg);

        arg.exitScope();
        boolean isElseValid = (ifStat.getElseOp() != null) ? ifStat.getElseOp().accept(this, arg) : true;
        boolean isIfValid = isExprValid && areVarDeclListValid && areStatListValid && isElseValid;
        if(!isExprValid){
            throw new RuntimeException("Id:"+ifStat.getExpr().toString()+" doesn't exists!");
        }

        return isIfValid;
    }

    @Override
    public Boolean visit(WhileStat whileStat, SymbolTable arg) {
        arg.enterScope();
        boolean isExprValid = (whileStat.getExpr() != null) ? whileStat.getExpr().accept(this, arg) : true;
        boolean areVarDeclListValid = this.checkContext(whileStat.getVarDeclList(),arg);
        boolean areStatListValid = this.checkContext(whileStat.getStatList(),arg);
        boolean isWhileValid = isExprValid && areVarDeclListValid && areStatListValid;
        if(!isExprValid){
            throw new RuntimeException("Id:"+whileStat.getExpr().toString()+" doesn't exists!");
        }
        arg.exitScope();
        return isWhileValid;
    }

    @Override
    public Boolean visit(ReadStat readStat, SymbolTable arg) {

        boolean isExprValid = (readStat.getExpr() != null) ? readStat.getExpr().accept(this, arg) : true;
        boolean areIdListValid = this.checkContext(readStat.getIdList(),arg);
        boolean isWhileValid = isExprValid && areIdListValid;
        if(!areIdListValid){
            throw new RuntimeException("Id:"+this.signalContext(readStat.getIdList(),arg).toString() +"doesn't exists");
        }
        return isWhileValid;
    }

    @Override
    public Boolean visit(AssignStat assignStat, SymbolTable arg) {
        boolean isIdValid = (assignStat.getId() != null) ? assignStat.getId().accept(this, arg) : true;
        boolean isExprValid = (assignStat.getExpr() != null) ? assignStat.getExpr().accept(this, arg) : true;
        boolean isAssignValid = isExprValid && isIdValid;
        if(!isIdValid){
            throw new RuntimeException("Id:"+assignStat.getId().toString()+" doesn't exists!");
        }
        if(!isExprValid){
            throw new RuntimeException("Id:"+assignStat.getExpr().toString()+" doesn't exists!");
        }
        return isAssignValid;
    }

    @Override
    public Boolean visit(ReturnOp returnOp, SymbolTable arg) {
        boolean isExprValid = (returnOp.getExpr() != null) ? returnOp.getExpr().accept(this, arg) : true;
        if(!isExprValid){
            throw new RuntimeException("Id:"+returnOp.getExpr().toString()+" doesn't exists!");
        }
        return isExprValid;
    }

    @Override
    public Boolean visit(WriteOp writeOp, SymbolTable arg) {
        boolean isExprValid = (writeOp.getExpr() != null) ? writeOp.getExpr().accept(this, arg) : true;
        if(!isExprValid){
            throw new RuntimeException("Id:"+writeOp.getExpr().toString()+" doesn't exists!");
        }
        return isExprValid;
    }

    @Override
    public Boolean visit(WriteLnOp writeLnOp, SymbolTable arg) {
        boolean isExprValid = (writeLnOp.getExpr() != null) ? writeLnOp.getExpr().accept(this, arg) : true;
        if(!isExprValid){
            throw new RuntimeException("Id:"+writeLnOp.getExpr().toString()+" doesn't exists!");
        }
        return isExprValid;
    }

    @Override
    public Boolean visit(WriteTOp writeTOp, SymbolTable arg) {
        boolean isExprValid = (writeTOp.getExpr() != null) ? writeTOp.getExpr().accept(this, arg) : true;
        if(!isExprValid){
            throw new RuntimeException("Id:"+writeTOp.getExpr().toString()+" doesn't exists!");
        }
        return isExprValid;
    }

    @Override
    public Boolean visit(WriteBOp writeBOp, SymbolTable arg) {
        boolean isExprValid = (writeBOp.getExpr() != null) ? writeBOp.getExpr().accept(this, arg) : true;
        if(!isExprValid){
            throw new RuntimeException("Id:"+writeBOp.getExpr().toString()+" doesn't exists!");
        }
        return isExprValid;
    }

    @Override
    public Boolean visit(Fun fun, SymbolTable arg) {
        arg.enterScope();
        if(fun.getId() != null){
            fun.getId().setFunction(true);
            fun.getId().setParDecl(false);
        }
        boolean isIdValid = (fun.getId() != null) ? fun.getId().accept(this, arg) : true;
        boolean areParamDeclListValid = this.checkContext(fun.getParamDeclList(),arg);
        boolean isTypeValid = (fun.getType() != null) ? fun.getType().accept(this, arg) : true;
        boolean areVarDeclListValid = this.checkContext(fun.getVarDeclList(),arg);
        boolean areStatListValid = this.checkContext(fun.getStatList(),arg);
        boolean isFunValid = isIdValid && areParamDeclListValid && areVarDeclListValid && isTypeValid && areStatListValid;
        arg.exitScope();
        return isFunValid;

    }

    @Override
    public Boolean visit(Main main, SymbolTable arg) {
        arg.enterScope();

        boolean areVarDeclListValid = this.checkContext(main.getVarDeclList(),arg);
        boolean areStatListValid = this.checkContext(main.getStatList(),arg);
        boolean isMainValid = areVarDeclListValid &&  areStatListValid;

        arg.exitScope();
        return isMainValid;
    }

    @Override
    public Boolean visit(CallFunctionStat callFunctionStat, SymbolTable arg) {
        boolean isCallFunctionValid = (callFunctionStat.getCallFunction() != null) ? callFunctionStat.getCallFunction().accept(this, arg) : true;

        return isCallFunctionValid;
    }

    /* VarDecl ::= Type:t IdListInit:idListInit SEMI
    * | VAR IdListInitObbl:idListInitObbl SEMI   */
    @Override
    public Boolean visit(VarDecl varDecl, SymbolTable arg) {

        boolean isTypeValid = (varDecl.getType() != null) ? varDecl.getType().accept(this, arg) : true;
        boolean areIdInitOpListValid = this.checkContext(varDecl.getIdListInitOp(),arg);
        boolean areIdInitOpObblListValid = this.checkContext(varDecl.getIdListInitObblOp(),arg);
        boolean isVarDeclValid = isTypeValid && areIdInitOpListValid && areIdInitOpObblListValid;
        if(isVarDeclValid){
            if(varDecl.getIdListInitOp()!=null)
                fillEntries(varDecl.getIdListInitOp(), varDecl.getType(),arg);
            if(varDecl.getIdListInitObblOp()!=null)
                fillEntriesObbl(varDecl.getIdListInitObblOp(),arg);
        }
        return isVarDeclValid;
    }

    @Override
    public Boolean visit(LetStat letStat, SymbolTable arg) {
        arg.enterScope();
        boolean areVarDeclListValid = this.checkContext(letStat.getVarDeclList(),arg);
        boolean areStatListValid = this.checkContext(letStat.getStatList(),arg);
        boolean isLetValid = areVarDeclListValid && areStatListValid;

        arg.exitScope();
        return isLetValid;
    }

    public Boolean binaryExprVisitation(Expr leftOperand, Expr rightOperand,SymbolTable arg){
        boolean isLeftExprOperandValid = (leftOperand != null) ? leftOperand.accept(this, arg): true;
        boolean isRightExprOperandValid = (rightOperand != null) ? rightOperand.accept(this, arg): true;
        if(!isLeftExprOperandValid){
            throw new RuntimeException("BinaryExpr "+leftOperand.toString() +" doesn't exists!");
        }
        if(!isRightExprOperandValid){
            throw new RuntimeException("BinaryExpr "+rightOperand.toString() +" doesn't exists!");
        }
        boolean isBinaryOpValid = isLeftExprOperandValid && isRightExprOperandValid;
        return isBinaryOpValid;
    }

    public boolean fillEntries(LinkedList<IdInitOp> idInitList, Type type,SymbolTable arg){
        for(IdInitOp idInitOp : idInitList){
            arg.addEntry(idInitOp.getId().getValue(),new SymbolTableRecord(idInitOp.getId().getValue(),type.typeFactory(), NodeKind.VARIABLE));
        }
        return true;
    }
    public boolean fillEntriesObbl(LinkedList<IdInitObblOp> idInitList,SymbolTable arg){
        for(IdInitObblOp idInitObblOp : idInitList){
            Const c = idInitObblOp.getConstant();
            Type type = c.getType();
            arg.addEntry(idInitObblOp.getId().getValue(),new SymbolTableRecord(idInitObblOp.getId().getValue(),type.typeFactory(), NodeKind.VARIABLE));
        }
        return true;
    }
}
