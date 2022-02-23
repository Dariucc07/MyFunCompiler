import java_cup.runtime.ComplexSymbolFactory;import java_cup.runtime.Symbol;import lexical.StringTable;

/**
* This class is a simple example lexer.
*/


%%

%class Lexer
%cupsym ParserSym

%cup

%unicode

%line
%column

%{
            StringBuffer string = new StringBuffer();
            StringTable table;

            ComplexSymbolFactory complexSymbolFactory;

            private Symbol generateParserSym(int type) {
                return new Symbol(type);
            }

            private Symbol generateParserSym(int type, Object value) {
                this.table.install(value.toString());
                return new Symbol(type, value);
            }

            private Symbol generateError() {
                //TODO cambiare il return e aggiungere symbolFactory
                return new Symbol(ParserSym.ERROR);
            }

            private Symbol generateError(Object value){
                return new Symbol(ParserSym.ERROR, value);
            }
            public boolean initialize(String filePath) {
                try {
                  this.zzReader = new java.io.FileReader(filePath);
                  return true;
                } catch (java.io.FileNotFoundException e) {
                  return false;
                }
            }

            public Lexer(StringTable table, ComplexSymbolFactory csf){
                this.complexSymbolFactory =csf;
                this.table=table;
            }
            Lexer() { }
%}

%eofval{
	return generateParserSym(ParserSym.EOF);
%eofval}

LineTerminator = ([\r\n]|\r\n)
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]



Identifier = [$_A-Za-z][$_A-Za-z0-9]*
IntegerLiteral = ([0-9]+)
NumberLiteral = ([0-9]|([0-9]?\.[0-9]+))(E(\+|\-)?[0-9]+)?
// instead of doing regex for string and comment, we have to handle errors so we create comment and string (single quoted and double quoted) states
// StringLiteral = ([\"]([^\"])*[\"])|([\']([^\'])*[\'])

EndOfLineComment = (\/\/|#[^\r\n\*]){InputCharacter}*{LineTerminator}?

//NumberLiteral = (\+|\-)?([:digit:]|([:digit:]?\.[:digit:]+))(E(\+|\-)?[:digit:]+)?
%state SQ_STRING
%state DQ_STRING
%state BLK_COMMENT
%%

<YYINITIAL>{
/* parole chiave */
    "main" { return generateParserSym(ParserSym.MAIN);}
    "if" { return generateParserSym(ParserSym.IF);}
    "then" { return generateParserSym(ParserSym.THEN);}
    "else" { return generateParserSym(ParserSym.ELSE);}
    "while" { return generateParserSym(ParserSym.WHILE);}
    "loop" { return generateParserSym(ParserSym.LOOP);}
    "integer" { return generateParserSym(ParserSym.INTEGER);}
    "real" { return generateParserSym(ParserSym.REAL);}
    "string" { return generateParserSym(ParserSym.STRING); }
    "bool"  { return generateParserSym(ParserSym.BOOL); }
    "fun"  { return generateParserSym(ParserSym.FUN); }
    "end"  {return generateParserSym(ParserSym.END);}
    "return" {return generateParserSym(ParserSym.RETURN);}
    "@" {return generateParserSym(ParserSym.OUTPAR);}
    "out" {return generateParserSym(ParserSym.OUT);}
    "var" {return generateParserSym(ParserSym.VAR);}

/*values*/
    "null" { return generateParserSym(ParserSym.NULL); }
    "true" { return generateParserSym(ParserSym.BOOL_CONST, "true"); }
    "false" { return generateParserSym(ParserSym.BOOL_CONST, "false"); }

/* separatori */
    "(" {return generateParserSym(ParserSym.LPAR);}
    ")" {return generateParserSym(ParserSym.RPAR);}
    "," {return generateParserSym(ParserSym.COMMA);}
    ";" {return generateParserSym(ParserSym.SEMI);}
    ":" {return generateParserSym(ParserSym.COLON);}
/* relop */
    "<" { return generateParserSym(ParserSym.LT); }
    "<=" { return generateParserSym(ParserSym.LE); }
    "=" { return generateParserSym(ParserSym.EQ); }
    "<>" { return generateParserSym(ParserSym.NE); }
    "!=" { return generateParserSym(ParserSym.NE); }
    ">" { return generateParserSym(ParserSym.GT); }
    ">=" { return generateParserSym(ParserSym.GE); }
    ":=" { return generateParserSym(ParserSym.ASSIGN); }

/* bool operators*/
    "and" { return generateParserSym(ParserSym.AND); }
    "or" { return generateParserSym(ParserSym.OR); }
    "not" { return generateParserSym(ParserSym.NOT); }

/* math operators*/
    "+" { return generateParserSym(ParserSym.PLUS); }
    "-" { return generateParserSym(ParserSym.MINUS); }
    "*" { return generateParserSym(ParserSym.TIMES); }
    "div"  { return generateParserSym(ParserSym.DIVINT); }
    "/"  { return generateParserSym(ParserSym.DIV); }
    "^"  { return generateParserSym(ParserSym.POW); }

/*str operators*/
    "&" { return generateParserSym(ParserSym.STR_CONCAT); }

/* operatori lettura e scrittura */
    "%" { return generateParserSym(ParserSym.READ); }
    "?" { return generateParserSym(ParserSym.WRITE); }
    "?." { return generateParserSym(ParserSym.WRITELN); }
    "?," { return generateParserSym(ParserSym.WRITEB); }
    "?:" { return generateParserSym(ParserSym.WRITET); }

/* string initalizers */
    "\"" {string.setLength(0); yybegin(DQ_STRING);} //double initial string quote
    \' {string.setLength(0); yybegin(SQ_STRING);} // single initial string quote

/*block comment initializers */
    "#*" { yybegin(BLK_COMMENT);}




    {Identifier} {return generateParserSym(ParserSym.ID, yytext()); /* may need to add string table*/ }


    {IntegerLiteral} { return generateParserSym(ParserSym.INTEGER_CONST, yytext());}
    {NumberLiteral} { return generateParserSym(ParserSym.REAL_CONST, yytext());}
    {WhiteSpace} { /* ignore */}
    {EndOfLineComment} { /* ignore */}
    <<EOF>> {return generateParserSym(ParserSym.EOF);}
}
<BLK_COMMENT> {
    "#" {
          yybegin(YYINITIAL);
      }
    <<EOF>> {
          yybegin(YYINITIAL);
          return generateError("Commento non chiuso");
      }
    [^#] {/* ignore */ }
}

<DQ_STRING> {
    "\"" {
          yybegin(YYINITIAL);
          return generateParserSym(ParserSym.STRING_CONST,string.toString());
         }
         '\t' { string.append('\t'); }
         '\n' { string.append('\n'); }
         '\r' { string.append('\r'); }
         '\'' { string.append('\''); }
         "\\"  { string.append('\\'); }
         [^\n\r\"\\] { string.append( yytext() ); }

    <<EOF>> {
               yybegin(YYINITIAL);
              return generateError("Stringa non completata");
          }
}

<SQ_STRING> {
    "\'" {
          yybegin(YYINITIAL);
          return generateParserSym(ParserSym.STRING_CONST, string.toString());
      }

      '\t' { string.append('\t'); }
      '\n' { string.append('\n'); }
      '\r' { string.append('\r'); }
      '\"' { string.append('\"'); }
      "\\"  { string.append('\\'); }

      [^\n\r\"\\] { string.append( yytext() ); }
   <<EOF>> {
              yybegin(YYINITIAL);
              return generateError("Stringa non completata");
          }
}




/* error fallback */
[^] {
  System.err.println("Illegal character <" + yytext() + "> on L: " + yyline + " C: " + yycolumn);
  return generateError(yytext());
}
