// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: srcjflexcup/jflexLexer.flex

import java_cup.runtime.ComplexSymbolFactory;import java_cup.runtime.Symbol;import lexical.StringTable;

/**
* This class is a simple example lexer.
*/



// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int SQ_STRING = 2;
  public static final int DQ_STRING = 4;
  public static final int BLK_COMMENT = 6;
  public static final int CHAR = 8;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2,  2,  3,  3,  4, 4
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\0\1\3\1\4\22\0\1\3"+
    "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\12\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\4\10"+
    "\1\34\25\10\1\0\1\35\1\0\1\36\1\10\1\0"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\2\10\1\50\1\51\1\52\1\53\1\54\1\10"+
    "\1\55\1\56\1\57\1\60\1\61\1\62\3\10\u0185\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\2\2\1\1\1\3\1\1\1\4\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\1\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\20\4\1\30\1\31\1\32\1\33"+
    "\1\30\1\34\1\35\1\2\1\36\1\37\1\0\1\17"+
    "\1\0\1\40\1\41\1\42\1\43\1\44\1\45\10\4"+
    "\1\46\5\4\1\47\7\4\6\0\1\37\1\50\2\4"+
    "\1\51\1\4\1\52\1\4\1\53\3\4\1\54\1\4"+
    "\1\55\5\4\1\56\1\4\1\57\1\60\1\61\1\62"+
    "\1\63\1\64\1\65\1\66\2\4\1\67\1\70\1\71"+
    "\1\72\2\4\1\73\1\74\1\4\1\75\3\4\1\76"+
    "\1\4\1\77\1\100\1\101";

  private static int [] zzUnpackAction() {
    int [] result = new int[145];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\146\0\231\0\314\0\377\0\377\0\u0132"+
    "\0\u0165\0\377\0\u0198\0\u01cb\0\377\0\377\0\377\0\377"+
    "\0\377\0\377\0\377\0\377\0\377\0\u01fe\0\u0231\0\u0264"+
    "\0\u0297\0\377\0\u02ca\0\377\0\u02fd\0\u0330\0\377\0\377"+
    "\0\u0363\0\u0396\0\u03c9\0\u03fc\0\u042f\0\u0462\0\u0495\0\u04c8"+
    "\0\u04fb\0\u052e\0\u0561\0\u0594\0\u05c7\0\u05fa\0\u062d\0\u0660"+
    "\0\377\0\u0693\0\377\0\377\0\u06c6\0\377\0\377\0\u06f9"+
    "\0\377\0\u072c\0\u01fe\0\u075f\0\u0792\0\377\0\377\0\377"+
    "\0\377\0\377\0\377\0\u07c5\0\u07f8\0\u082b\0\u085e\0\u0891"+
    "\0\u08c4\0\u08f7\0\u092a\0\u01cb\0\u095d\0\u0990\0\u09c3\0\u09f6"+
    "\0\u0a29\0\u01cb\0\u0a5c\0\u0a8f\0\u0ac2\0\u0af5\0\u0b28\0\u0b5b"+
    "\0\u0b8e\0\u0bc1\0\u0bf4\0\u0c27\0\u0c5a\0\u0c8d\0\u0cc0\0\u0cc0"+
    "\0\u01cb\0\u0cf3\0\u0d26\0\u01cb\0\u0d59\0\u01cb\0\u0d8c\0\u01cb"+
    "\0\u0dbf\0\u0df2\0\u0e25\0\u01cb\0\u0e58\0\u01cb\0\u0e8b\0\u0ebe"+
    "\0\u0ef1\0\u0f24\0\u0f57\0\u01cb\0\u0f8a\0\377\0\377\0\377"+
    "\0\377\0\377\0\u01cb\0\u01cb\0\u01cb\0\u0fbd\0\u0ff0\0\u01cb"+
    "\0\u01cb\0\u01cb\0\u01cb\0\u1023\0\u1056\0\u01cb\0\u01cb\0\u1089"+
    "\0\u01cb\0\u10bc\0\u10ef\0\u1122\0\u01cb\0\u1155\0\u01cb\0\u01cb"+
    "\0\u01cb";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[145];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\6\3\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\14\1\6\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\2\14\1\47\1\50\1\51\1\52"+
    "\1\53\1\14\1\54\1\55\1\56\1\14\1\57\1\60"+
    "\2\61\1\6\1\61\1\6\1\61\1\6\4\61\1\62"+
    "\21\61\1\63\27\61\1\6\1\61\1\6\1\61\1\64"+
    "\4\61\1\65\21\61\1\63\25\61\7\7\1\66\53\7"+
    "\63\6\65\0\1\7\110\0\1\67\32\0\2\70\1\0"+
    "\1\70\1\0\11\70\1\71\44\70\10\0\1\14\13\0"+
    "\1\14\7\0\1\14\2\0\24\14\24\0\1\72\61\0"+
    "\1\70\61\0\1\73\1\0\1\74\7\0\1\75\56\0"+
    "\1\76\62\0\1\77\1\67\61\0\1\100\52\0\1\101"+
    "\1\0\1\102\2\0\1\103\45\0\1\14\13\0\1\14"+
    "\7\0\1\14\2\0\13\14\1\104\10\14\10\0\1\14"+
    "\13\0\1\14\7\0\1\14\2\0\14\14\1\105\7\14"+
    "\10\0\1\14\13\0\1\14\7\0\1\14\2\0\7\14"+
    "\1\106\14\14\10\0\1\14\13\0\1\14\7\0\1\14"+
    "\2\0\10\14\1\107\13\14\10\0\1\14\13\0\1\14"+
    "\7\0\1\14\2\0\11\14\1\110\1\14\1\111\10\14"+
    "\10\0\1\14\13\0\1\14\7\0\1\14\2\0\1\112"+
    "\20\14\1\113\2\14\10\0\1\14\13\0\1\14\7\0"+
    "\1\14\2\0\5\14\1\114\5\14\1\115\10\14\10\0"+
    "\1\14\13\0\1\14\7\0\1\14\2\0\14\14\1\116"+
    "\7\14\10\0\1\14\13\0\1\14\7\0\1\14\2\0"+
    "\1\117\23\14\10\0\1\14\13\0\1\14\7\0\1\14"+
    "\2\0\14\14\1\120\4\14\1\121\2\14\10\0\1\14"+
    "\13\0\1\14\7\0\1\14\2\0\16\14\1\122\2\14"+
    "\1\123\2\14\10\0\1\14\13\0\1\14\7\0\1\14"+
    "\2\0\4\14\1\124\17\14\10\0\1\14\13\0\1\14"+
    "\7\0\1\14\2\0\20\14\1\125\3\14\10\0\1\14"+
    "\13\0\1\14\7\0\1\14\2\0\7\14\1\126\6\14"+
    "\1\127\5\14\10\0\1\14\13\0\1\14\7\0\1\14"+
    "\2\0\1\130\23\14\10\0\1\14\13\0\1\14\7\0"+
    "\1\14\2\0\7\14\1\131\14\14\1\0\1\132\1\133"+
    "\1\0\1\134\1\0\1\135\55\0\1\132\1\133\1\0"+
    "\1\134\6\0\1\136\47\0\2\70\1\7\1\70\1\10"+
    "\56\70\24\0\1\72\7\0\1\75\52\0\1\74\55\0"+
    "\1\137\1\0\1\137\2\0\1\140\46\0\1\14\13\0"+
    "\1\14\7\0\1\14\2\0\3\14\1\141\20\14\10\0"+
    "\1\14\13\0\1\14\7\0\1\14\2\0\14\14\1\142"+
    "\7\14\10\0\1\14\13\0\1\14\7\0\1\14\2\0"+
    "\1\143\23\14\10\0\1\14\13\0\1\14\7\0\1\14"+
    "\2\0\22\14\1\144\1\14\10\0\1\14\13\0\1\14"+
    "\7\0\1\14\2\0\17\14\1\145\4\14\10\0\1\14"+
    "\13\0\1\14\7\0\1\14\2\0\3\14\1\146\20\14"+
    "\10\0\1\14\13\0\1\14\7\0\1\14\2\0\11\14"+
    "\1\147\12\14\10\0\1\14\13\0\1\14\7\0\1\14"+
    "\2\0\13\14\1\150\10\14\10\0\1\14\13\0\1\14"+
    "\7\0\1\14\2\0\20\14\1\151\3\14\10\0\1\14"+
    "\13\0\1\14\7\0\1\14\2\0\14\14\1\152\7\14"+
    "\10\0\1\14\13\0\1\14\7\0\1\14\2\0\10\14"+
    "\1\153\13\14\10\0\1\14\13\0\1\14\7\0\1\14"+
    "\2\0\20\14\1\154\3\14\10\0\1\14\13\0\1\14"+
    "\7\0\1\14\2\0\11\14\1\155\12\14\10\0\1\14"+
    "\13\0\1\14\7\0\1\14\2\0\20\14\1\156\3\14"+
    "\10\0\1\14\13\0\1\14\7\0\1\14\2\0\1\157"+
    "\17\14\1\160\3\14\10\0\1\14\13\0\1\14\7\0"+
    "\1\14\2\0\16\14\1\161\5\14\10\0\1\14\13\0"+
    "\1\14\7\0\1\14\2\0\4\14\1\162\17\14\10\0"+
    "\1\14\13\0\1\14\7\0\1\14\2\0\21\14\1\163"+
    "\2\14\10\0\1\14\13\0\1\14\7\0\1\14\2\0"+
    "\16\14\1\164\5\14\10\0\1\14\13\0\1\14\7\0"+
    "\1\14\2\0\10\14\1\165\13\14\13\0\1\166\62\0"+
    "\1\167\62\0\1\170\62\0\1\171\62\0\1\172\73\0"+
    "\1\140\46\0\1\14\13\0\1\14\7\0\1\14\2\0"+
    "\11\14\1\173\12\14\10\0\1\14\13\0\1\14\7\0"+
    "\1\14\2\0\16\14\1\174\5\14\10\0\1\14\13\0"+
    "\1\14\7\0\1\14\2\0\4\14\1\175\17\14\10\0"+
    "\1\14\13\0\1\14\7\0\1\14\2\0\17\14\1\176"+
    "\4\14\10\0\1\14\13\0\1\14\7\0\1\14\2\0"+
    "\4\14\1\177\17\14\10\0\1\14\13\0\1\14\7\0"+
    "\1\14\2\0\15\14\1\200\6\14\10\0\1\14\13\0"+
    "\1\14\7\0\1\14\2\0\13\14\1\201\10\14\10\0"+
    "\1\14\13\0\1\14\7\0\1\14\2\0\11\14\1\202"+
    "\12\14\10\0\1\14\13\0\1\14\7\0\1\14\2\0"+
    "\11\14\1\203\12\14\10\0\1\14\13\0\1\14\7\0"+
    "\1\14\2\0\21\14\1\204\2\14\10\0\1\14\13\0"+
    "\1\14\7\0\1\14\2\0\10\14\1\205\13\14\10\0"+
    "\1\14\13\0\1\14\7\0\1\14\2\0\13\14\1\206"+
    "\10\14\10\0\1\14\13\0\1\14\7\0\1\14\2\0"+
    "\4\14\1\207\17\14\10\0\1\14\13\0\1\14\7\0"+
    "\1\14\2\0\11\14\1\210\12\14\10\0\1\14\13\0"+
    "\1\14\7\0\1\14\2\0\4\14\1\211\17\14\10\0"+
    "\1\14\13\0\1\14\7\0\1\14\2\0\6\14\1\212"+
    "\15\14\10\0\1\14\13\0\1\14\7\0\1\14\2\0"+
    "\16\14\1\213\5\14\10\0\1\14\13\0\1\14\7\0"+
    "\1\14\2\0\13\14\1\214\10\14\10\0\1\14\13\0"+
    "\1\14\7\0\1\14\2\0\4\14\1\215\17\14\10\0"+
    "\1\14\13\0\1\14\7\0\1\14\2\0\4\14\1\216"+
    "\17\14\10\0\1\14\13\0\1\14\7\0\1\14\2\0"+
    "\13\14\1\217\10\14\10\0\1\14\13\0\1\14\7\0"+
    "\1\14\2\0\6\14\1\220\15\14\10\0\1\14\13\0"+
    "\1\14\7\0\1\14\2\0\16\14\1\221\5\14";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4488];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\2\11\2\1\1\11\2\1\11\11\4\1\1\11"+
    "\1\1\1\11\2\1\2\11\20\1\1\11\1\1\2\11"+
    "\1\1\2\11\1\1\1\11\1\1\1\0\1\1\1\0"+
    "\6\11\26\1\6\0\26\1\5\11\27\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[145];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
            switch (zzLexicalState) {
            case YYINITIAL: {
              return generateParserSym(ParserSym.EOF);
            }  // fall though
            case 146: break;
            case SQ_STRING: {
              yybegin(YYINITIAL);
              return generateError("Stringa non completata");
            }  // fall though
            case 147: break;
            case DQ_STRING: {
              yybegin(YYINITIAL);
              return generateError("Stringa non completata");
            }  // fall though
            case 148: break;
            case BLK_COMMENT: {
              yybegin(YYINITIAL);
          return generateError("Commento non chiuso");
            }  // fall though
            case 149: break;
            default:
          { 	return generateParserSym(ParserSym.EOF);
 }
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.err.println("Illegal character <" + yytext() + "> on L: " + yyline + " C: " + yycolumn);
  return generateError(yytext());
            }
            // fall through
          case 66: break;
          case 2:
            { /* ignore */
            }
            // fall through
          case 67: break;
          case 3:
            { string.setLength(0); yybegin(DQ_STRING);
            }
            // fall through
          case 68: break;
          case 4:
            { return generateParserSym(ParserSym.ID, yytext()); /* may need to add string table*/
            }
            // fall through
          case 69: break;
          case 5:
            { return generateParserSym(ParserSym.READ);
            }
            // fall through
          case 70: break;
          case 6:
            { return generateParserSym(ParserSym.STR_CONCAT);
            }
            // fall through
          case 71: break;
          case 7:
            { string.setLength(0); yybegin(SQ_STRING);
            }
            // fall through
          case 72: break;
          case 8:
            { return generateParserSym(ParserSym.LPAR);
            }
            // fall through
          case 73: break;
          case 9:
            { return generateParserSym(ParserSym.RPAR);
            }
            // fall through
          case 74: break;
          case 10:
            { return generateParserSym(ParserSym.TIMES);
            }
            // fall through
          case 75: break;
          case 11:
            { return generateParserSym(ParserSym.PLUS);
            }
            // fall through
          case 76: break;
          case 12:
            { return generateParserSym(ParserSym.COMMA);
            }
            // fall through
          case 77: break;
          case 13:
            { return generateParserSym(ParserSym.MINUS);
            }
            // fall through
          case 78: break;
          case 14:
            { return generateParserSym(ParserSym.DIV);
            }
            // fall through
          case 79: break;
          case 15:
            { return generateParserSym(ParserSym.INTEGER_CONST, yytext());
            }
            // fall through
          case 80: break;
          case 16:
            { return generateParserSym(ParserSym.COLON);
            }
            // fall through
          case 81: break;
          case 17:
            { return generateParserSym(ParserSym.SEMI);
            }
            // fall through
          case 82: break;
          case 18:
            { return generateParserSym(ParserSym.LT);
            }
            // fall through
          case 83: break;
          case 19:
            { return generateParserSym(ParserSym.EQ);
            }
            // fall through
          case 84: break;
          case 20:
            { return generateParserSym(ParserSym.GT);
            }
            // fall through
          case 85: break;
          case 21:
            { return generateParserSym(ParserSym.WRITE);
            }
            // fall through
          case 86: break;
          case 22:
            { return generateParserSym(ParserSym.OUTPAR);
            }
            // fall through
          case 87: break;
          case 23:
            { return generateParserSym(ParserSym.POW);
            }
            // fall through
          case 88: break;
          case 24:
            { string.append( yytext() );
            }
            // fall through
          case 89: break;
          case 25:
            { yybegin(YYINITIAL);
          if(string.length()>1){
              return generateParserSym(ParserSym.STRING_CONST,string.toString());
          }else{
              return generateParserSym(ParserSym.CHAR_CONST, string.toString());
          }
            }
            // fall through
          case 90: break;
          case 26:
            { string.append('\\');
            }
            // fall through
          case 91: break;
          case 27:
            { yybegin(YYINITIAL);
          if(string.length()>1){
            return generateParserSym(ParserSym.STRING_CONST,string.toString());
          }else{
            return generateParserSym(ParserSym.CHAR_CONST, string.toString());
            }
            }
            // fall through
          case 92: break;
          case 28:
            { yybegin(YYINITIAL);
            }
            // fall through
          case 93: break;
          case 29:
            { return generateParserSym(ParserSym.NE);
            }
            // fall through
          case 94: break;
          case 30:
            { yybegin(BLK_COMMENT);
            }
            // fall through
          case 95: break;
          case 31:
            { return generateParserSym(ParserSym.REAL_CONST, yytext());
            }
            // fall through
          case 96: break;
          case 32:
            { return generateParserSym(ParserSym.ASSIGN);
            }
            // fall through
          case 97: break;
          case 33:
            { return generateParserSym(ParserSym.LE);
            }
            // fall through
          case 98: break;
          case 34:
            { return generateParserSym(ParserSym.GE);
            }
            // fall through
          case 99: break;
          case 35:
            { return generateParserSym(ParserSym.WRITEB);
            }
            // fall through
          case 100: break;
          case 36:
            { return generateParserSym(ParserSym.WRITELN);
            }
            // fall through
          case 101: break;
          case 37:
            { return generateParserSym(ParserSym.WRITET);
            }
            // fall through
          case 102: break;
          case 38:
            { return generateParserSym(ParserSym.IF);
            }
            // fall through
          case 103: break;
          case 39:
            { return generateParserSym(ParserSym.OR);
            }
            // fall through
          case 104: break;
          case 40:
            { return generateParserSym(ParserSym.AND);
            }
            // fall through
          case 105: break;
          case 41:
            { return generateParserSym(ParserSym.DIVINT);
            }
            // fall through
          case 106: break;
          case 42:
            { return generateParserSym(ParserSym.END);
            }
            // fall through
          case 107: break;
          case 43:
            { return generateParserSym(ParserSym.FUN);
            }
            // fall through
          case 108: break;
          case 44:
            { return generateParserSym(ParserSym.NOT);
            }
            // fall through
          case 109: break;
          case 45:
            { return generateParserSym(ParserSym.OUT);
            }
            // fall through
          case 110: break;
          case 46:
            { return generateParserSym(ParserSym.VAR);
            }
            // fall through
          case 111: break;
          case 47:
            { string.append('\t');
            }
            // fall through
          case 112: break;
          case 48:
            { string.append('\n');
            }
            // fall through
          case 113: break;
          case 49:
            { string.append('\r');
            }
            // fall through
          case 114: break;
          case 50:
            { string.append('\"');
            }
            // fall through
          case 115: break;
          case 51:
            { string.append('\'');
            }
            // fall through
          case 116: break;
          case 52:
            { return generateParserSym(ParserSym.BOOL);
            }
            // fall through
          case 117: break;
          case 53:
            { return generateParserSym(ParserSym.CHAR);
            }
            // fall through
          case 118: break;
          case 54:
            { return generateParserSym(ParserSym.ELSE);
            }
            // fall through
          case 119: break;
          case 55:
            { return generateParserSym(ParserSym.LOOP);
            }
            // fall through
          case 120: break;
          case 56:
            { return generateParserSym(ParserSym.MAIN);
            }
            // fall through
          case 121: break;
          case 57:
            { return generateParserSym(ParserSym.NULL);
            }
            // fall through
          case 122: break;
          case 58:
            { return generateParserSym(ParserSym.REAL);
            }
            // fall through
          case 123: break;
          case 59:
            { return generateParserSym(ParserSym.THEN);
            }
            // fall through
          case 124: break;
          case 60:
            { return generateParserSym(ParserSym.BOOL_CONST, "true");
            }
            // fall through
          case 125: break;
          case 61:
            { return generateParserSym(ParserSym.BOOL_CONST, "false");
            }
            // fall through
          case 126: break;
          case 62:
            { return generateParserSym(ParserSym.WHILE);
            }
            // fall through
          case 127: break;
          case 63:
            { return generateParserSym(ParserSym.RETURN);
            }
            // fall through
          case 128: break;
          case 64:
            { return generateParserSym(ParserSym.STRING);
            }
            // fall through
          case 129: break;
          case 65:
            { return generateParserSym(ParserSym.INTEGER);
            }
            // fall through
          case 130: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
