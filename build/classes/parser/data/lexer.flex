package parser.data;
import static parser.data.Token.*;
import java_cup.runtime.*;
import java.io.Reader.*;
%%
%class Lexer
%line
%column
%public
%cup
%{
    private Lexema lexema(Token type) {
        return new Lexema(type, yyline, yycolumn);
    }
    private Lexema lexema(Token type, Object value) {
        return new Lexema(type, value, yyline, yycolumn);
    }
    public String token;
    public String string;
    public Lexema lexeme;

    private Symbol sym(int sym) {
        return new Symbol(sym, yyline, yycolumn);
    }

    private Symbol sym(int sym, Object val) {
        return new Symbol(sym, yyline, yycolumn, val);
    }

    
%}
LETRA = [a-zA-Z_]
NUMERO = [0-9]
DIGITO = [1-9]
OCTAL = [0-8]
HEXADECIMAL = [0-9a-fA-F]
FINDELINEA = \r|\n|\r\n
ESPACIO =[ \t\r\n] | {FINDELINEA} | [ \t\f]
CARACTER = [^\"\r\n]
CARACTER_C = "'"({CARACTER}|\")"'"

NUMERO_ENTERO = 0 | {DIGITO}{NUMERO}*(u|U)?(l|L)?
NUMERO_FlOTANTE = (0|({DIGITO}{NUMERO}*))?"."{NUMERO}+(u|U)?(l|L)? | {DIGITO}{NUMERO}*(e|E)"-"?{DIGITO}{NUMERO}*(u|U)?(l|L)?
NUMERO_OCTAL = 0({OCTAL})+(u|U)?(l|L)?
NUMERO_HEXADECIMAL = 0x({HEXADECIMAL})+(u|U)?(l|L)?
ID = {LETRA}({LETRA}|{DIGITO})*  
DIRECTIVAS = "#"(define|if|elif|message|undef|ifdef|include|else|endif|error)
SPECIFIER = "typedef" | "extern" | "static" | "auto" | "register" | "const" | "volatile"
RETURNTYPE = "int" | "float" | "double" | "char" | "string"
PALABRAS_RESERVADAS = "auto" | "break" | "case" | "char" | "const" | "continue" | "default" | "do" | "double" | 
                      "else" | "enum" | "extern" | "float" | "for" | "goto" | "if" | "int" | "long" | "register" |
                      "return" | "short" | "signed" | "sizeof" | "static" | "struct" | "switch" | "typedef" | "union" |
                      "unsigned" | "void" | "volatile" | "while"
OPERADORES = "," | ";" | "?" | "||" | "&&" | "(" | ")" | "[" | "]" | "{" | "}" | ":" | "." | "++" | "--" | "~" | "#" |
             ( "*" | "+" | "-" | "/" | "!" | "=" | "<" | ">" | "%" | "&" |"^" | "|" | "<<" | ">>" | "-" ){0,1}={0,1}
COMENTARIO = {ComentarioNormal} | {ComentariodeLinea} | {ComentarioDocumental}
ComentarioNormal = "/*" [^*] ~"*/" | "/*" "*"+ "/"
ComentariodeLinea = "//" {CARACTER}* {FINDELINEA}?
ComentarioDocumental = "/**" {ContenioComentario} "*"+ "/"
ContenioComentario = ([^*]|\*+[^/*])*
%state STRING_STATE, COMENTARIO_STATE
%%
<YYINITIAL>{

    /* null literal */
    "null"                         { return sym(sym.LITERAL_NULL); }

    /* separators */
     "("                            { return sym(sym.LPAREN); }
     ")"                            { return sym(sym.RPAREN); }
     "{"                            { return sym(sym.LBRACE); }
     "}"                            { return sym(sym.RBRACE); }
     "["                            { return sym(sym.LBRACK); }
     "]"                            { return sym(sym.RBRACK); }
     ";"                            { return sym(sym.SEMICOLON); }
     ","                            { return sym(sym.COMMA); }
     "."                            { return sym(sym.DOT); }

     {SPECIFIER}                    { lexeme = lexema(SPECIFIER,yytext()); return sym(sym.SPECIFIER); }

    {ESPACIO} | {COMENTARIO} {/*Ignorar*/}
    "/*"        {yybegin(COMENTARIO_STATE);}
    {OPERADORES} { lexeme= lexema(OPERADOR,yytext()); return sym(sym.OPERADOR);}
    {PALABRAS_RESERVADAS} { lexeme= lexema(PALABRA_RESERVADA,yytext()); return sym(sym.PALABRA_RESERVADA);}
    {DIRECTIVAS} { lexeme= lexema(DIRECTIVA,yytext()); return sym(sym.DIRECTIVA);}
    \" {string = "\""; yybegin(STRING_STATE);}
    
    {CARACTER_C} { lexeme= lexema(LITERAL_CARACTER,yytext()); return sym(sym.LITERAL_CARACTER);}
    {NUMERO_ENTERO} { lexeme= lexema(LITERAL_ENTERO,yytext()); return sym(sym.LITERAL_ENTERO, new Integer(yytext()));}
    {NUMERO_FlOTANTE}  { lexeme= lexema(LITERAL_FLOAT,yytext()); return sym(sym.LITERAL_FLOAT);}
    {NUMERO_OCTAL} { lexeme= lexema(LITERAL_OCTAL,yytext()); return sym(sym.LITERAL_OCTAL);}
    {NUMERO_HEXADECIMAL}  { lexeme= lexema(LITERAL_HEXADECIMAL,yytext()); return sym(sym.LITERAL_HEXADECIMAL);}
    {ID} {lexeme = lexema(IDENTIFICADOR,yytext()); return sym(sym.IDENTIFICADOR);} 
    . | 0{NUMERO}* | {DIGITO}({DIGITO}|{LETRA})*  {lexeme = lexema(ERROR); return sym(sym.ERROR);}
    <<EOF>> { return sym(sym.EOF);}
}
<STRING_STATE>{
    {CARACTER}+  { string = string.concat(yytext());} 
    \"          { yybegin(YYINITIAL);string = string.concat(yytext());
                    lexeme = lexema(LITERAL_STRING,string); return sym(sym.LITERAL_STRING);}
    {FINDELINEA}     { yybegin(YYINITIAL); string.concat(yytext()); 
                    lexeme = lexema(ERROR,string); return sym(sym.ERROR);}
    <<EOF>>     { yybegin(YYINITIAL); string.concat(yytext()); 
                    lexeme = lexema(ERROR,string); return sym(sym.ERROR);}
}
<COMENTARIO_STATE>{
    [^*] {/*Ignorar*/}
    <<EOF>> { yybegin(YYINITIAL); lexeme = lexema(ERROR,yytext()); return sym(sym.ERROR);}
}