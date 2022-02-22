# MyFun

Programming language definited for the Compiler course from University.

## Full Project
JFlex and JavaCup integration for MyFun language implementation.

##Specifications
```
Project SDK : Amazon corretto-11 (JDK 11)
Language-level: 11.
Main class: CGeneratorTester.java
```
## Lexical Specification

| Token | Lexeme |
|   -------|--------|
|   MAIN |'main'|
|	ID   | regex id|
|	INTEGER|  'integer'|
|	STRING |'string'|
|	REAL |'real'|
|	BOOL |'bool'|
|	LPAR |'('|
|	RPAR |')'|
|	COLON |':'|
|	FUN |'Fun'|
|	END |'end'|
|	IF |'if'|
|	THEN |'then'|
|	ELSE |'else'|
|	WHILE |'while'|
|	LOOP |'loop'|
|	READ |'%'|
|	WRITE |'?'|
|	WRITELN |'?.'|
|	WRITEB |'?,'|
|	WRITET |'?:'|
|	ASSIGN |':='|
|	PLUS |'+'|
|	MINUS |'-'|
|	TIMES |'*'|
|	DIVINT |'div'|
|	DIV | '/'|
|	POW |'^'|
|	STR_CONCAT |'&'|
|	EQ |'=' |
|	NE |'<>' or '!='|
|	LT |'<' |
|	LE |'<=' |
|	GT |'>' |
|	GE |'>='|
|	AND |'and'|
|	OR |'or'|
|	NOT |'not'|
|	NULL |'null'|                          
|   TRUE |'true' |                         
|   FALSE |'false'|                           
| 	INTEGER_CONST | any integer number (sequence of decimal digits) |                 
|    REAL_CONST | any real number|
|   STRING_CONST | any string between " or between '|
|	SEMI |';'|
|	COMMA |','|
|	RETURN |'return'|
|	OUTPAR |'@'|
|	VAR |'var'|
|	OUT |'out'|
|	LOOP |'loop'|

##Grammar Specification
```
Program ::= VarDeclList FunList Main

VarDeclList ::= /* empty */
|  VarDeclList VarDecl

Main ::= MAIN VarDeclList StatList END MAIN SEMI

FunList ::= /* empty */ 
| FunList Fun

VarDecl ::= Type IdListInit SEMI
| VAR IdListInitObbl SEMI

Type ::= INTEGER                                                    
| BOOL                                                               
| REAL                                                               
| STRING                                                             

IdListInit ::= ID                                                    
| IdListInit COMMA ID
| ID ASSIGN Expr                                          
| IdListInit COMMA ID ASSIGN Expr

IdListInitObbl ::= ID ASSIGN Const                                 
| IdListInitObbl COMMA ID ASSIGN Const              

Const ::= INTEGER_CONST                                              
|REAL_CONST                                                
|BOOL_CONST                                                 
|STRING_CONST                                               

Fun ::= FUN ID LPAR ParamDeclList RPAR COLON Type
VarDeclList StatList END FUN SEMI         
| FUN ID LPAR ParamDeclList RPAR
VarDeclList StatList END FUN SEMI        


ParamDeclList ::= /*empty */                                      
| NonEmptyParamDeclList                              

NonEmptyParamDeclList ::= ParDecl                         
| NonEmptyParamDeclList COMMA ParDecl

ParDecl ::= Type ID                 
| OUT Type ID                    

StatList ::= /*empty*/                             
| StatList Stat                       

Stat ::= IfStat SEMI         
| WhileStat SEMI      
| ReadStat SEMI        
| WriteStat SEMI      
| AssignStat SEMI    
| CallFun SEMI          
| RETURN Expr SEMI

IfStat ::= IF Expr THEN VarDeclList StatList Else END IF

Else ::= /* empty */
| ELSE VarDeclList  StatList

WhileStat ::= WHILE Expr LOOP VarDeclList  StatList END LOOP

ReadStat ::= READ IdList Expr
| READ IdList                               

IdList ::= ID                                
| IdList COMMA ID                 

WriteStat ::=  WRITE  Expr
| WRITELN  Expr 
| WRITET  Expr                         
| WRITEB  Expr                         


AssignStat ::=  ID ASSIGN Expr              

CallFun ::= ID LPAR ExprList RPAR       
| ID LPAR RPAR                               

ExprList ::= Expr
| ExprList COMMA Expr      
| OUTPAR ID                      
| ExprList COMMA OUTPAR ID       

Expr ::= BOOL_CONST            
| INTEGER_CONST            
| REAL_CONST               
| STRING_CONST             
| ID                       
| CallFun                  
| Expr  PLUS Expr       
| Expr  MINUS Expr      
| Expr  TIMES Expr      
| Expr  DIV Expr        
| Expr  DIVINT Expr     
| Expr  AND Expr        
| Expr POW Expr         
| Expr STR_CONCAT Expr  
| Expr  OR Expr        
| Expr  GT Expr        
| Expr  GE Expr         
| Expr  LT Expr         
| Expr  LE Expr         
| Expr  EQ Expr        
| Expr  NE Expr        
| MINUS Expr               
| NOT Expr                 
| LPAR Expr RPAR
```

```
These two productions was changed from:

StatList ::= Stat
	 | Stat StatList;

Stat ::= IfStat SEMI
	| WhileStat SEMI
	| ReadStat SEMI
	| WriteStat SEMI
	| AssignStat SEMI
	| CallFun SEMI
	| RETURN Expr SEMI
	| /*empty*/;

to:

StatList ::= /*empty*/
	 | Stat StatList;

Stat ::= IfStat SEMI
	| WhileStat SEMI
	| ReadStat SEMI
	| WriteStat SEMI
	| AssignStat SEMI
	| CallFun SEMI
	| RETURN Expr SEMI;

because in the first case LR parser has shift/reduce conflicts.

Moreover, every production with right recursion was changed to left recursion in order to
have an syntax tree's inversion elements.
```


## Notes
For compile CUP file launch:
```sh
java -jar C:\CUP\java-cup-11b.jar -dump -progress -locations -expect 5 -destdir .\src\dist\ .\srcjflexcup\Parser.cup 2>.\out.txt
```
For compile jFLEX file launch:
```sh
..\jflex-1.7.0\bin\jflex -d .\src\dist\ srcjflexcup\Lexer.flex
```

