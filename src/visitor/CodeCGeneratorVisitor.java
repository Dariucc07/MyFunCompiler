package visitor;

import nodetype.NodeType;
import nodetype.PrimitiveNodeType;
import semantic.SymbolTable;
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

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class CodeCGeneratorVisitor implements Visitor<String, SymbolTable> {

    private final String root;

    public CodeCGeneratorVisitor(String root) {
        this.root = root;
    }

    private String beautify(List<? extends AstNode> nodes, StringJoiner joiner, SymbolTable table){
        nodes.forEach(node -> joiner.add(node.accept(this, table)));
        return joiner.toString();
    }

    @Override
    public String visit(Program program, SymbolTable arg) {
        arg.enterScope();
        StringJoiner varDecls = new StringJoiner("\n");
        program.getVarDeclList().forEach(varDecl -> varDecls.add(varDecl.accept(this,arg)));
        StringJoiner funs = new StringJoiner("\n");
        program.getFunList().forEach(fun -> funs.add(fun.accept(this,arg)));
        funs.add(program.getMain().accept(this,arg));
        arg.exitScope();
        return this.root.replace("$varDecls$",varDecls.toString())
                .replace("$functionsDefinitions$",funs.toString());

    }

    @Override
    public String visit(PlusOp plusOp, SymbolTable arg) {
        String leftOperand = plusOp.getLeftOperand().accept(this, arg);
        String rightOperand = plusOp.getRightOperand().accept(this, arg);
        return String.format("%s + %s", leftOperand, rightOperand);

    }

    @Override
    public String visit(MinusOp minusOp, SymbolTable arg) {
        String leftOperand = minusOp.getLeftOperand().accept(this, arg);
        String rightOperand = minusOp.getRightOperand().accept(this, arg);
        return String.format("%s - %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(TimesOp timesOp, SymbolTable arg) {
        String leftOperand = timesOp.getLeftOperand().accept(this, arg);
        String rightOperand = timesOp.getRightOperand().accept(this, arg);
        return String.format("%s * %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(DivOp divOp, SymbolTable arg) {
        String leftOperand = divOp.getLeftOperand().accept(this, arg);
        String rightOperand = divOp.getRightOperand().accept(this, arg);
        return String.format("%s / %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(DivIntOp divIntOp, SymbolTable arg) {
        String leftOperand = divIntOp.getLeftOperand().accept(this, arg);
        String rightOperand = divIntOp.getRightOperand().accept(this, arg);
        return String.format("%s / %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(PowOp powOp, SymbolTable arg) {
        String baseOperand = powOp.getBaseOperand().accept(this, arg);
        String exponentOperand = powOp.getExponentOperand().accept(this, arg);
        return String.format("pow(%s, %s)", baseOperand, exponentOperand);
    }

    @Override
    public String visit(StringConcatOp stringConcatOp, SymbolTable arg) {
        String leftOperand = stringConcatOp.getLeftOperand().accept(this, arg);
        String rightOperand = stringConcatOp.getRightOperand().accept(this, arg);
        return String.format("strcat(%s, %s)", leftOperand, rightOperand);
    }

    @Override
    public String visit(AndRelop andRelop, SymbolTable arg) {
        String leftOperand = andRelop.getLeftOperand().accept(this, arg);
        String rightOperand = andRelop.getRightOperand().accept(this, arg);
        return String.format("%s && %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(OrRelop orRelop, SymbolTable arg) {
        String leftOperand = orRelop.getLeftOperand().accept(this, arg);
        String rightOperand = orRelop.getRightOperand().accept(this, arg);
        return String.format("%s || %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(NotEqualRelop notEqualRelop, SymbolTable arg) {
        String leftOperand = notEqualRelop.getLeftOperand().accept(this, arg);
        String rightOperand = notEqualRelop.getRightOperand().accept(this, arg);
        return String.format("%s != %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(EqualRelop equalRelop, SymbolTable arg) {
        String leftOperand = equalRelop.getLeftOperand().accept(this, arg);
        String rightOperand = equalRelop.getRightOperand().accept(this, arg);
        return String.format("%s == %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(GreaterThanRelop greaterThanRelop, SymbolTable arg){
        String leftOperand = greaterThanRelop.getLeftOperand().accept(this, arg);
        String rightOperand = greaterThanRelop.getRightOperand().accept(this, arg);
        return String.format("%s > %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(GreaterEqualRelop greaterEqualRelop, SymbolTable arg) {
        String leftOperand = greaterEqualRelop.getLeftOperand().accept(this, arg);
        String rightOperand = greaterEqualRelop.getRightOperand().accept(this, arg);
        return String.format("%s >= %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(LessThanRelop lessThanRelop, SymbolTable arg) {
        String leftOperand = lessThanRelop.getLeftOperand().accept(this, arg);
        String rightOperand = lessThanRelop.getRightOperand().accept(this, arg);
        return String.format("%s < %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(LessEqualRelop lessEqualRelop, SymbolTable arg) {
        String leftOperand = lessEqualRelop.getLeftOperand().accept(this, arg);
        String rightOperand = lessEqualRelop.getRightOperand().accept(this, arg);
        return String.format("%s <= %s", leftOperand, rightOperand);
    }

    @Override
    public String visit(BoolConst boolConst, SymbolTable arg) {
        if(boolConst.getValue().equals(true)){
            return "1";
        }else{
            return "0";
        }
    }

    @Override
    public String visit(IntegerConst integerConst, SymbolTable arg) {
        return Integer.toString(integerConst.getValue());
    }

    @Override
    public String visit(RealConst realConst, SymbolTable arg) {
        return Double.toString(realConst.getValue());
    }

    @Override
    public String visit(StringConst stringConst, SymbolTable arg) {
        return "\"" + stringConst.getValue() + "\"";
    }

    @Override
    public String visit(Id id, SymbolTable arg) {
        return id.getValue();
    }

    @Override
    public String visit(CallFunction callFunction, SymbolTable arg) {
        String functionName = callFunction.getId().accept(this, arg);
        if(callFunction.getExprList() != null){
            StringJoiner sj = new StringJoiner(", ");
            for(Expr exprElement : callFunction.getExprList()){
                sj.add(exprElement.accept(this, arg));
            }
            return String.format("%s(%s)", functionName, sj.toString());
        }else{
            return String.format("%s()", functionName);
        }
    }

    @Override
    public String visit(MinusExpr minusExpr, SymbolTable arg) {
        String left = minusExpr.getExpr().accept(this,arg);
        return String.format("-%s", left);
    }

    @Override
    public String visit(NotExpr notExpr, SymbolTable arg) {
        String left = notExpr.getExpr().accept(this,arg);
        return String.format("!(%s)", left);
    }

    @Override
    public String visit(ParExpr parExpr, SymbolTable arg) {
        String left = parExpr.getExpr().accept(this,arg);
        return String.format("(%s)", left);
    }

    @Override
    public String visit(OutParIdExpr outParIdExpr, SymbolTable arg) {
        String left = outParIdExpr.getId().accept(this,arg);
        return String.format("&(%s)", left);
    }

    @Override
    public String visit(IdInitOp idInitOp, SymbolTable arg) {
        String id = idInitOp.getId().accept(this,arg);
        String expr ="";
        if(idInitOp.getExpr()!=null) {

            expr = idInitOp.getExpr().accept(this, arg);
            if(arg.lookup(idInitOp.getId().getValue()).get().getNodeType().equals(PrimitiveNodeType.STRING)){
                return String.format("char %s[256] = %s;",id,expr);
            }
            PrimitiveNodeType tp= (PrimitiveNodeType) arg.lookup(idInitOp.getId().getValue()).get().getNodeType();
            String type= tp.cType();
            return String.format("%s %s = %s;",type,id,expr);
        }else {
            PrimitiveNodeType tp= (PrimitiveNodeType) arg.lookup(idInitOp.getId().getValue()).get().getNodeType();
            String type= tp.cType();
            return String.format("%s %s;",type,id);
        }

    }

    @Override
    public String visit(Const constant, SymbolTable arg) {
        return constant.getConst().accept(this,arg);
    }

    @Override
    public String visit(IdInitObblOp idInitObblOp, SymbolTable arg) {
        String id = idInitObblOp.getId().accept(this,arg);
        String constant ="";
        if(idInitObblOp.getConstant().getConst()!=null) {
            constant = idInitObblOp.getConstant().getConst().accept(this, arg);
            String type = idInitObblOp.getConstant().getType().getType();
            if(type.equals("STRING")){
                return String.format("char %s[256] = %s;",id,constant);
            }else{
                type = idInitObblOp.getConstant().getType().typeConverterC();
                return String.format("%s %s = %s;",type,id,constant);

            }
        }
        return String.format("%s",id);
    }

    @Override
    public String visit(PrimitiveType primitiveType, SymbolTable arg) {
        return primitiveType.typeConverterC();
    }

    @Override
    public String visit(ParDecl parDecl, SymbolTable arg) {
        String type = parDecl.getType().accept(this,arg);
        String id = parDecl.getId().accept(this,arg);
        if(parDecl.isOut()){
            return String.format("%s* %s",type,id);
        }else{
            return String.format("%s %s",type,id);
        }
    }

    @Override
    public String visit(ElseOp elseOp, SymbolTable arg) {
        arg.enterScope();
        StringJoiner sj = new StringJoiner("\n");
        elseOp.getVarDeclList().forEach(varDecl -> sj.add(varDecl.accept(this,arg)));
        elseOp.getStatList().forEach(stat -> sj.add(stat.accept(this,arg)));
        arg.exitScope();
        return String.format("else {\n%s\n}\n",sj.toString());
    }

    @Override
    public String visit(IfStat ifStat, SymbolTable arg) {
        arg.enterScope();
        String condition = ifStat.getExpr().accept(this, arg);

        StringJoiner sjVarDecl = new StringJoiner(", ");
        for(VarDecl declaredElement : ifStat.getVarDeclList()){
            sjVarDecl.add(declaredElement.accept(this, arg));
        }

        StringJoiner sjStat = new StringJoiner(";\n");
        for(Stat statement : ifStat.getStatList()){
            sjStat.add(statement.accept(this, arg));
        }
        arg.exitScope();
        String elseOp = "";
        if(ifStat.getElseOp() != null) {
            elseOp = ifStat.getElseOp().accept(this, arg);
            return String.format("if(%s){\n%s%s}else{\n%s}", condition, sjVarDecl.toString(), sjStat.toString(),elseOp);
        }else {
            return String.format("if(%s){\n%s%s}", condition, sjVarDecl.toString(), sjStat.toString());
        }

    }

    @Override
    public String visit(WhileStat whileStat, SymbolTable arg) {
        arg.enterScope();
        String condition = whileStat.getExpr().accept(this, arg);

        StringJoiner sjVarDecl = new StringJoiner(", ");
        for(VarDecl declaredElement : whileStat.getVarDeclList()){
            sjVarDecl.add(declaredElement.accept(this, arg));
        }

        StringJoiner sjStat = new StringJoiner(";\n");
        for(Stat statement : whileStat.getStatList()){
            sjStat.add(statement.accept(this, arg));
        }
        arg.exitScope();
        return String.format("while(%s){\n%s%s}", condition, sjVarDecl.toString(), sjStat.toString());


    }

    @Override
    public String visit(ReadStat readStat, SymbolTable arg) {
        StringJoiner scanfs = new StringJoiner(",");
        readStat.getIdList().forEach(id -> scanfs.add("&"+id.accept(this,arg)));
        StringBuilder typesFormat = new StringBuilder();
        for(Id id : readStat.getIdList()){
            String format = formatType(arg.lookup(id.getValue()).get().getNodeType());
            typesFormat.append(format);
        }
        String message ="";
        if(readStat.getExpr()!=null){
           String expr = readStat.getExpr().accept(this,arg);
           String format = formatType(readStat.getExpr().getType());
           message = String.format("printf(\"%s\",%s);\n",format,expr);
        }
        return String.format("%s scanf(\"%s\",%s);\n",message, typesFormat.toString(),scanfs.toString());
    }

    @Override
    public String visit(AssignStat assignStat, SymbolTable arg) {
        String leftOperand = assignStat.getId().accept(this, arg);
        String rightOperand = assignStat.getExpr().accept(this, arg);
        return String.format("%s = %s;", leftOperand, rightOperand);
    }

    @Override
    public String visit(ReturnOp returnOp, SymbolTable arg) {
        String exprElement = returnOp.getExpr().accept(this, arg);
        return String.format("return %s;", exprElement);
    }

    @Override
    public String visit(WriteOp writeOp, SymbolTable arg) {
        String expr = writeOp.getExpr().accept(this,arg);
        String format = formatType(writeOp.getExpr().getType());
        return String.format("printf(\"%s\",%s);\n",format,expr);
    }

    @Override
    public String visit(WriteLnOp writeLnOp, SymbolTable arg) {
        String expr = writeLnOp.getExpr().accept(this,arg);
        String format = formatType(writeLnOp.getExpr().getType());
        return String.format("printf(\"%s\n\",%s);\n",format,expr);
    }

    @Override
    public String visit(WriteTOp writeTOp, SymbolTable arg) {
        String expr = writeTOp.getExpr().accept(this,arg);
        String format = formatType(writeTOp.getExpr().getType());
        return String.format("printf(\"%s\t\",%s);\n",format,expr);
    }

    @Override
    public String visit(WriteBOp writeBOp, SymbolTable arg) {
        String expr = writeBOp.getExpr().accept(this,arg);
        String format = formatType(writeBOp.getExpr().getType());
        return String.format("printf(\"%s\b\",%s);\n",format,expr);
    }

    @Override
    public String visit(Fun fun, SymbolTable arg) {
        arg.enterScope();
        String functionName = fun.getId().accept(this, arg);

        StringJoiner sjParamDecl = new StringJoiner(", ");
        if(fun.getParamDeclList() != null) {
            for (ParDecl parameter : fun.getParamDeclList()) {
                sjParamDecl.add(parameter.accept(this, arg));
            }
        }

        StringJoiner sjVarDecl = new StringJoiner(";\n");
        if(fun.getVarDeclList() != null){
            for(VarDecl element : fun.getVarDeclList()){
                sjVarDecl.add(element.accept(this, arg));
            }
        }

        StringJoiner sjStat = new StringJoiner("\n");
        if(fun.getStatList()!= null){
            for(Stat statElement : fun.getStatList()){
                sjStat.add(statElement.accept(this, arg));
            }
        }
        arg.exitScope();
        if(fun.getType() != null) {
            String type = fun.getType().accept(this, arg);
            return String.format("%s  %s(%s){\n%s%s\n}", type, functionName, sjParamDecl.toString(), sjVarDecl.toString(), sjStat.toString());
        }else {
            return String.format("void %s(%s){\n%s%s\n}", functionName, sjParamDecl.toString(), sjVarDecl.toString(), sjStat.toString());
        }

    }

    @Override
    public String visit(Main main, SymbolTable arg) {
        arg.enterScope();
        StringJoiner statements = new StringJoiner("\n");
        main.getVarDeclList().forEach(varDecl -> statements.add(varDecl.accept(this,arg)));
        main.getStatList().forEach(stat -> statements.add(stat.accept(this,arg)));
        arg.exitScope();
        return String.format("int main(){\n%s\n}\n",statements.toString());
    }

    @Override
    public String visit(CallFunctionStat callFunctionStat, SymbolTable arg){
        String functionCall = callFunctionStat.getCallFunction().accept(this, arg);
        return String.format("%s;", functionCall);
    }

    @Override
    public String visit(VarDecl varDecl, SymbolTable arg) {
        StringJoiner vardecls = new StringJoiner("\n");
        if(varDecl.isVar()){
            varDecl.getIdListInitObblOp().forEach(idInitObbl -> vardecls.add(idInitObbl.accept(this,arg)));
        }else{
            varDecl.getIdListInitOp().forEach(idInit -> vardecls.add(idInit.accept(this,arg)));
        }
        return String.format("%s",vardecls.toString());
    }
    private String formatType(NodeType type){
        PrimitiveNodeType pType = (PrimitiveNodeType) type;
        switch(pType){
            case REAL:
                return "%f";
            case STRING:
                return "%s";
            default:
                return "%d";
        }
    }
}

