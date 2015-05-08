package parser.data;
import static parser.data.Token.*;
import java_cup.runtime.*;
import java_cup.sym;
%%
%class Lexer
%line
%column
%public
%cup
%implements sym
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
        return new Symbol(sym);
    }

    private Symbol sym(int sym, Object val) {
        return new Symbol(sym, val);
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
    {ESPACIO} | {COMENTARIO} {/*Ignorar*/}
    "/*"        {yybegin(COMENTARIO_STATE);}
    {OPERADORES} { lexeme= lexema(OPERADOR,yytext()); return sym(9);}
    {PALABRAS_RESERVADAS} { lexeme= lexema(PALABRA_RESERVADA,yytext()); return sym(2);}
    {DIRECTIVAS} { lexeme= lexema(DIRECTIVA,yytext()); return sym(12);}
    \" {string = "\""; yybegin(STRING_STATE);}
    
    {CARACTER_C} { lexeme= lexema(LITERAL_CARACTER,yytext()); return sym(4);}
    {NUMERO_ENTERO} { lexeme= lexema(LITERAL_ENTERO,yytext()); return sym(5);}
    {NUMERO_FlOTANTE}  { lexeme= lexema(LITERAL_FLOAT,yytext()); return sym(8);}
    {NUMERO_OCTAL} { lexeme= lexema(LITERAL_OCTAL,yytext()); return sym(6);}
    {NUMERO_HEXADECIMAL}  { lexeme= lexema(LITERAL_HEXADECIMAL,yytext()); return sym(7);}
    {ID} {lexeme = lexema(IDENTIFICADOR,yytext()); return sym(1);} 
    . | 0{NUMERO}* | {DIGITO}({DIGITO}|{LETRA})*  {lexeme = lexema(ERROR); return sym(10);}
    <<EOF>> { return sym(11);}
}
<STRING_STATE>{
    {CARACTER}+  { string = string.concat(yytext());} 
    \"          { yybegin(YYINITIAL);string = string.concat(yytext());
                    lexeme = lexema(LITERAL_STRING,string); return sym(3);}
    {FINDELINEA}     { yybegin(YYINITIAL); string.concat(yytext()); 
                    lexeme = lexema(ERROR,string); return sym(10);}
    <<EOF>>     { yybegin(YYINITIAL); string.concat(yytext()); 
                    lexeme = lexema(ERROR,string); return sym(10);}
}
<COMENTARIO_STATE>{
    [^*] {/*Ignorar*/}
    <<EOF>> { yybegin(YYINITIAL); lexeme = lexema(ERROR,yytext()); return sym(10);}
}