/* The following code was generated by JFlex 1.6.1 */


/* --------------------------Codigo de Usuario----------------------- */
package parser.data;

import java_cup.runtime.*;
import java.io.Reader;
import static parser.data.Token.*;
      

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/parser/data/reglas_lexicas.flex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING_STATE = 2;
  public static final int COMENTARIO_STATE = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\6\1\5\1\12\1\6\1\4\22\0\1\6\1\50\1\7"+
    "\1\0\1\0\1\47\1\43\1\10\1\44\1\45\1\51\1\46\1\56"+
    "\1\21\1\0\1\52\1\2\10\3\1\3\1\60\1\57\1\11\1\53"+
    "\1\13\2\0\4\1\1\1\1\1\5\1\1\17\10\1\1\15\5\1"+
    "\4\0\1\1\1\0\1\27\1\36\1\31\1\22\1\20\1\23\1\30"+
    "\1\37\1\24\1\1\1\40\1\16\1\1\1\25\1\33\1\1\1\1"+
    "\1\32\1\26\1\34\1\14\1\35\1\41\1\1\1\1\1\1\1\54"+
    "\1\42\1\55\7\0\1\12\u1fa2\0\1\12\1\12\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\2\3\2\4\1\5\1\1\1\6"+
    "\1\7\2\2\1\10\11\2\2\1\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\2\27\1\30\1\1\2\3\1\0"+
    "\1\31\1\32\2\2\1\33\1\34\1\2\1\35\1\2"+
    "\1\36\13\2\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\4\1\47\1\50\1\51\3\2\1\52"+
    "\1\53\13\2\2\0\1\54\1\55\3\2\1\56\2\2"+
    "\1\57\1\60\1\2\1\61\3\2\1\0\1\4\1\2"+
    "\1\62\1\2\1\63\2\2\1\64\1\65\1\66\1\2"+
    "\1\67\1\2\1\70\1\71\1\2\1\72";

  private static int [] zzUnpackAction() {
    int [] result = new int[132];
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
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\u0126\0\u0157"+
    "\0\223\0\223\0\u0188\0\u01b9\0\u01ea\0\u021b\0\u024c\0\u027d"+
    "\0\u02ae\0\u02df\0\u0310\0\u0341\0\u0372\0\u03a3\0\u03d4\0\u0405"+
    "\0\u0436\0\u0467\0\u0498\0\223\0\223\0\u04c9\0\u04fa\0\u052b"+
    "\0\u055c\0\u058d\0\u05be\0\223\0\223\0\223\0\223\0\223"+
    "\0\u05ef\0\u0620\0\223\0\223\0\365\0\u0651\0\223\0\u0682"+
    "\0\223\0\223\0\u06b3\0\u06e4\0\223\0\223\0\u0715\0\304"+
    "\0\u0746\0\304\0\u0777\0\u07a8\0\u07d9\0\u080a\0\u083b\0\u086c"+
    "\0\u089d\0\u08ce\0\u08ff\0\u0930\0\u0961\0\223\0\223\0\223"+
    "\0\223\0\223\0\223\0\223\0\u0992\0\u09c3\0\223\0\223"+
    "\0\223\0\u09f4\0\u0a25\0\u0a56\0\304\0\304\0\u0a87\0\u0ab8"+
    "\0\u0ae9\0\u0b1a\0\u0b4b\0\u0b7c\0\u0bad\0\u0bde\0\u0c0f\0\u0c40"+
    "\0\u0c71\0\u0ca2\0\u0cd3\0\304\0\304\0\u0d04\0\u0d35\0\u0d66"+
    "\0\304\0\u0d97\0\u0dc8\0\304\0\304\0\u0df9\0\304\0\u0e2a"+
    "\0\u0e5b\0\u0e8c\0\u0ebd\0\u0ca2\0\u0eee\0\304\0\u0f1f\0\304"+
    "\0\u0f50\0\u0f81\0\304\0\304\0\304\0\u0fb2\0\304\0\u0fe3"+
    "\0\304\0\304\0\u1014\0\304";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[132];
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
    "\1\4\1\5\1\6\1\7\1\10\2\11\1\12\1\13"+
    "\1\14\1\0\1\15\2\5\1\16\1\5\1\17\1\20"+
    "\1\21\1\22\1\23\1\5\1\24\2\5\1\25\1\26"+
    "\2\5\1\27\1\30\2\5\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\4\51\1\52\1\53\1\51"+
    "\1\54\51\51\51\11\1\0\7\11\62\0\1\5\1\0"+
    "\1\5\10\0\5\5\1\0\20\5\21\0\2\55\57\0"+
    "\2\7\10\0\2\56\2\57\46\0\1\11\53\0\4\60"+
    "\2\0\53\60\53\0\1\61\60\0\1\62\6\0\1\5"+
    "\1\0\1\5\10\0\5\5\1\0\11\5\1\63\6\5"+
    "\20\0\1\5\1\0\1\5\10\0\2\5\1\64\2\5"+
    "\1\0\20\5\40\0\1\65\31\0\1\66\6\0\1\5"+
    "\1\0\1\5\10\0\4\5\1\67\1\0\11\5\1\70"+
    "\6\5\20\0\1\5\1\0\1\5\10\0\5\5\1\0"+
    "\11\5\1\71\6\5\20\0\1\5\1\0\1\5\10\0"+
    "\5\5\1\0\1\5\1\72\1\5\1\73\14\5\20\0"+
    "\1\5\1\0\1\5\10\0\5\5\1\0\15\5\1\74"+
    "\1\5\1\75\20\0\1\5\1\0\1\5\10\0\5\5"+
    "\1\0\5\5\1\76\3\5\1\77\3\5\1\100\2\5"+
    "\20\0\1\5\1\0\1\5\10\0\4\5\1\101\1\0"+
    "\20\5\20\0\1\5\1\0\1\5\10\0\5\5\1\0"+
    "\11\5\1\102\6\5\20\0\1\5\1\0\1\5\10\0"+
    "\5\5\1\0\10\5\1\103\7\5\20\0\1\5\1\0"+
    "\1\5\10\0\5\5\1\0\10\5\1\104\4\5\1\105"+
    "\2\5\61\0\1\106\61\0\1\107\63\0\1\110\4\0"+
    "\1\111\60\0\1\112\60\0\1\113\60\0\1\114\56\0"+
    "\1\115\1\116\1\117\60\0\1\120\5\0\4\51\2\0"+
    "\1\51\1\0\51\51\5\0\1\53\71\0\2\57\51\0"+
    "\1\121\51\0\1\5\1\0\1\5\10\0\5\5\1\0"+
    "\3\5\1\122\14\5\20\0\1\5\1\0\1\5\10\0"+
    "\5\5\1\0\4\5\1\123\13\5\20\0\1\5\1\0"+
    "\1\5\10\0\5\5\1\0\1\5\1\124\16\5\20\0"+
    "\1\5\1\0\1\5\10\0\5\5\1\0\10\5\1\125"+
    "\7\5\20\0\1\5\1\0\1\5\10\0\5\5\1\0"+
    "\12\5\1\126\5\5\20\0\1\5\1\0\1\5\10\0"+
    "\5\5\1\0\11\5\1\127\6\5\20\0\1\5\1\0"+
    "\1\5\10\0\5\5\1\0\2\5\1\130\15\5\20\0"+
    "\1\5\1\0\1\5\10\0\5\5\1\0\4\5\1\131"+
    "\13\5\20\0\1\5\1\0\1\5\10\0\5\5\1\0"+
    "\3\5\1\132\14\5\20\0\1\5\1\0\1\5\10\0"+
    "\5\5\1\0\5\5\1\133\12\5\20\0\1\5\1\0"+
    "\1\5\10\0\5\5\1\0\5\5\1\134\4\5\1\135"+
    "\5\5\20\0\1\5\1\0\1\5\10\0\5\5\1\0"+
    "\2\5\1\136\15\5\20\0\1\5\1\0\1\5\10\0"+
    "\4\5\1\137\1\0\20\5\20\0\1\5\1\0\1\5"+
    "\10\0\5\5\1\0\2\5\1\140\15\5\20\0\1\5"+
    "\1\0\1\5\10\0\5\5\1\0\2\5\1\141\15\5"+
    "\17\0\51\142\1\143\7\142\4\116\1\10\1\11\1\116"+
    "\1\0\51\116\1\0\1\5\1\0\1\5\10\0\5\5"+
    "\1\0\6\5\1\144\11\5\20\0\1\5\1\0\1\5"+
    "\10\0\4\5\1\145\1\0\20\5\20\0\1\5\1\0"+
    "\1\5\10\0\5\5\1\0\5\5\1\146\12\5\20\0"+
    "\1\5\1\0\1\5\10\0\5\5\1\0\10\5\1\147"+
    "\7\5\20\0\1\5\1\0\1\5\10\0\5\5\1\0"+
    "\12\5\1\150\5\5\20\0\1\5\1\0\1\5\10\0"+
    "\4\5\1\151\1\0\20\5\20\0\1\5\1\0\1\5"+
    "\10\0\5\5\1\0\4\5\1\152\5\5\1\153\5\5"+
    "\20\0\1\5\1\0\1\5\10\0\5\5\1\0\10\5"+
    "\1\154\7\5\20\0\1\5\1\0\1\5\10\0\5\5"+
    "\1\0\1\155\17\5\20\0\1\5\1\0\1\5\10\0"+
    "\1\156\4\5\1\0\20\5\20\0\1\5\1\0\1\5"+
    "\10\0\5\5\1\0\1\157\17\5\20\0\1\5\1\0"+
    "\1\5\10\0\5\5\1\0\5\5\1\160\12\5\20\0"+
    "\1\5\1\0\1\5\10\0\5\5\1\0\12\5\1\161"+
    "\5\5\20\0\1\5\1\0\1\5\10\0\2\5\1\162"+
    "\2\5\1\0\20\5\17\0\51\142\1\163\60\142\1\163"+
    "\1\164\6\142\1\0\1\5\1\0\1\5\10\0\1\165"+
    "\4\5\1\0\20\5\20\0\1\5\1\0\1\5\10\0"+
    "\5\5\1\0\12\5\1\166\5\5\20\0\1\5\1\0"+
    "\1\5\10\0\5\5\1\0\7\5\1\167\10\5\20\0"+
    "\1\5\1\0\1\5\10\0\5\5\1\0\12\5\1\170"+
    "\5\5\20\0\1\5\1\0\1\5\10\0\5\5\1\0"+
    "\2\5\1\171\15\5\20\0\1\5\1\0\1\5\10\0"+
    "\5\5\1\0\10\5\1\172\7\5\20\0\1\5\1\0"+
    "\1\5\10\0\5\5\1\0\16\5\1\173\1\5\20\0"+
    "\1\5\1\0\1\5\10\0\4\5\1\174\1\0\20\5"+
    "\20\0\1\5\1\0\1\5\10\0\4\5\1\175\1\0"+
    "\20\5\17\0\51\142\1\163\1\11\6\142\1\0\1\5"+
    "\1\0\1\5\10\0\2\5\1\176\2\5\1\0\20\5"+
    "\20\0\1\5\1\0\1\5\10\0\5\5\1\0\15\5"+
    "\1\177\2\5\20\0\1\5\1\0\1\5\10\0\5\5"+
    "\1\0\3\5\1\200\14\5\20\0\1\5\1\0\1\5"+
    "\10\0\5\5\1\0\3\5\1\201\14\5\20\0\1\5"+
    "\1\0\1\5\10\0\5\5\1\0\12\5\1\202\5\5"+
    "\20\0\1\5\1\0\1\5\10\0\1\203\4\5\1\0"+
    "\20\5\20\0\1\5\1\0\1\5\10\0\4\5\1\204"+
    "\1\0\20\5\17\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4165];
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


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\4\1\2\11\21\1\2\11\6\1\5\11"+
    "\2\1\2\11\2\1\1\11\1\0\2\11\2\1\2\11"+
    "\17\1\7\11\2\1\3\11\20\1\2\0\17\1\1\0"+
    "\21\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[132];
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

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    private Lexema lexema(Token type) {
        return new Lexema(type, yyline, yycolumn);
    }
    private Lexema lexema(Token type, Object value) {
        return new Lexema(type, value, yyline, yycolumn);
    }
    public String token;
    public String string;
    public Lexema lexeme;
    /*  Generamos un java_cup.Symbol para guardar el tipo de token 
        encontrado */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Generamos un Symbol para el tipo de token encontrado 
       junto con su valor */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 188) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
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
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
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
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

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
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
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
        // peek one character ahead if it is \n (if we have counted one line too much)
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
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
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
              System.out.println(" EOF ");  return symbol(sym.EOF);
            }
            case 133: break;
            case STRING_STATE: {
              yybegin(YYINITIAL); string.concat(yytext()); 
                            lexeme = lexema(ERROR,string); return symbol(sym.error);
            }
            case 134: break;
            case COMENTARIO_STATE: {
              yybegin(YYINITIAL); lexeme = lexema(ERROR,yytext()); return symbol(sym.error);
            }
            case 135: break;
            default:
          { return new java_cup.runtime.Symbol(sym.EOF); }
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { lexeme = lexema(ERROR); return symbol(sym.error);
            }
          case 59: break;
          case 2: 
            { System.out.println(" IDENTIFICADOR "); 
                            lexeme = lexema(IDENTIFICADOR,yytext()); 
                            return symbol(sym.IDENTIFICADOR,yytext());
            }
          case 60: break;
          case 3: 
            { System.out.println(" NUMERO_ENTERO "); 
                            lexeme= lexema(LITERAL_ENTERO,yytext()); 
                            return symbol(sym.LITERAL_ENTERO, new Integer(yytext()));
            }
          case 61: break;
          case 4: 
            { /*Ignorar*/
            }
          case 62: break;
          case 5: 
            { string = "\""; yybegin(STRING_STATE);
            }
          case 63: break;
          case 6: 
            { System.out.println(" MENORQUE ");
                            return symbol(sym.MENORQUE,"<");
            }
          case 64: break;
          case 7: 
            { System.out.println(" MAYORQUE ");
                            return symbol(sym.MAYORQUE,">");
            }
          case 65: break;
          case 8: 
            { System.out.println(" SUBSTRACT ");
                            return symbol(sym.SUBSTRACT,"-");
            }
          case 66: break;
          case 9: 
            { System.out.println(" LPAREN ");
                            return symbol(sym.LPAREN,"(");
            }
          case 67: break;
          case 10: 
            { System.out.println(" RPAREN ");
                            return symbol(sym.RPAREN,")");
            }
          case 68: break;
          case 11: 
            { System.out.println(" ADD ");
                            return symbol(sym.ADD,"+");
            }
          case 69: break;
          case 12: 
            { System.out.println(" MODULUS ");
                            return symbol(sym.MODULUS,"%");
            }
          case 70: break;
          case 13: 
            { System.out.println(" EXCLAMACION ");
                            return symbol(sym.EXCLAMACION,"!");
            }
          case 71: break;
          case 14: 
            { System.out.println(" TIMES ");
                            return symbol(sym.TIMES,"*");
            }
          case 72: break;
          case 15: 
            { System.out.println(" DIVISION ");
                            return symbol(sym.DIVISION,"/");
            }
          case 73: break;
          case 16: 
            { System.out.println(" ASSIGN ");
                            return symbol(sym.ASSIGN,"=");
            }
          case 74: break;
          case 17: 
            { System.out.println(" LBRACE ");
                            return symbol(sym.LBRACE,"{");
            }
          case 75: break;
          case 18: 
            { System.out.println(" RBRACE ");
                            return symbol(sym.RBRACE,"}");
            }
          case 76: break;
          case 19: 
            { System.out.println(" COMMA ");
                            return symbol(sym.COMMA,",");
            }
          case 77: break;
          case 20: 
            { System.out.println(" SEMICOLON ");
                            return symbol(sym.SEMICOLON,";");
            }
          case 78: break;
          case 21: 
            { System.out.println(" COLON ");
                            return symbol(sym.COLON,":");
            }
          case 79: break;
          case 22: 
            { string = string.concat(yytext());
            }
          case 80: break;
          case 23: 
            { yybegin(YYINITIAL); string.concat(yytext()); 
                            lexeme = lexema(ERROR,string); return symbol(sym.error);
            }
          case 81: break;
          case 24: 
            { yybegin(YYINITIAL);string = string.concat(yytext());
                            System.out.println(" LITERAL STRING ");    
                            lexeme = lexema(LITERAL_STRING,string); return symbol(sym.LITERAL_STRING);
            }
          case 82: break;
          case 25: 
            { System.out.println("MENOREQ");
                            return symbol(sym.MENOREQ,"<=");
            }
          case 83: break;
          case 26: 
            { System.out.println("MAYOREQ");
                            return symbol(sym.MAYOREQ,">=");
            }
          case 84: break;
          case 27: 
            { System.out.println("MINUSMINUS");
                            return symbol(sym.MINUSMINUS,"--");
            }
          case 85: break;
          case 28: 
            { System.out.println("MINUSEQ");
                            return symbol(sym.MINUSEQ,"-=");
            }
          case 86: break;
          case 29: 
            { System.out.println(" DOWHILE ");
                            return symbol(sym.DO,"do");
            }
          case 87: break;
          case 30: 
            { System.out.println(" IF ");
                            return symbol(sym.IF,"if");
            }
          case 88: break;
          case 31: 
            { System.out.println("||");
                            return symbol(sym.OR,"||");
            }
          case 89: break;
          case 32: 
            { System.out.println("&&");
                            return symbol(sym.AND,"&&");
            }
          case 90: break;
          case 33: 
            { System.out.println("PLUSPLUS");
                            return symbol(sym.PLUSPLUS,"++");
            }
          case 91: break;
          case 34: 
            { System.out.println("PLUSEQ");
                            return symbol(sym.PLUSEQ,"+=");
            }
          case 92: break;
          case 35: 
            { System.out.println("MODEQ");
                            return symbol(sym.MODEQ,"%=");
            }
          case 93: break;
          case 36: 
            { System.out.println(" NOTEQ ");
                            return symbol(sym.NOTEQ,"!");
            }
          case 94: break;
          case 37: 
            { System.out.println("TIMESEQ");
                            return symbol(sym.TIMESEQ,"*=");
            }
          case 95: break;
          case 38: 
            { yybegin(COMENTARIO_STATE);
            }
          case 96: break;
          case 39: 
            { System.out.println("DIVEQ");
                            return symbol(sym.DIVEQ,"/=");
            }
          case 97: break;
          case 40: 
            { System.out.println(" EQUAL ");
                            return symbol(sym.EQUAL,"==");
            }
          case 98: break;
          case 41: 
            { System.out.println(" CARACTER_C "); 
                            lexeme= lexema(LITERAL_CARACTER,yytext()); 
                            return symbol(sym.LITERAL_CARACTER, yytext());
            }
          case 99: break;
          case 42: 
            { System.out.println(" FOR ");
                            return symbol(sym.FOR,"for");
            }
          case 100: break;
          case 43: 
            { System.out.println(" INT ");
                            return symbol(sym.INT,"int");
            }
          case 101: break;
          case 44: 
            { System.out.println(" LONG ");
                            return symbol(sym.LONG,"long");
            }
          case 102: break;
          case 45: 
            { System.out.println(" ELSE ");
                            return symbol(sym.ELSE,"else");
            }
          case 103: break;
          case 46: 
            { System.out.println(" CASE ");
                            return symbol(sym.CASE,"case");
            }
          case 104: break;
          case 47: 
            { System.out.println(" CHAR ");
                            return symbol(sym.CHAR,"char");
            }
          case 105: break;
          case 48: 
            { System.out.println(" READ ");
                            return symbol(sym.READ,"read");
            }
          case 106: break;
          case 49: 
            { System.out.println(" VOID ");
                            return symbol(sym.VOID,"void");
            }
          case 107: break;
          case 50: 
            { System.out.println(" SHORT ");
                            return symbol(sym.SHORT,"short");
            }
          case 108: break;
          case 51: 
            { System.out.println(" CONST ");
                            return symbol(sym.CONST,"const");
            }
          case 109: break;
          case 52: 
            { System.out.println(" BREAK ");
                            return symbol(sym.BREAK,"break");
            }
          case 110: break;
          case 53: 
            { System.out.println(" WRITE ");
                            return symbol(sym.WRITE,"write");
            }
          case 111: break;
          case 54: 
            { System.out.println(" WHILE ");
                            return symbol(sym.WHILE,"while");
            }
          case 112: break;
          case 55: 
            { System.out.println(" SWITCH ");
                            return symbol(sym.SWITCH,"switch");
            }
          case 113: break;
          case 56: 
            { System.out.println(" RETURN ");
                            return symbol(sym.RETURN,"return");
            }
          case 114: break;
          case 57: 
            { System.out.println(" DEFAULT ");
                            return symbol(sym.DEFAULT,"default");
            }
          case 115: break;
          case 58: 
            { System.out.println(" CONTINUE ");
                            return symbol(sym.CONTINUE,"continue");
            }
          case 116: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
