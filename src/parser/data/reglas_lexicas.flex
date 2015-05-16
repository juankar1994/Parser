
/* --------------------------Codigo de Usuario----------------------- */
package parser.data;

import java_cup.runtime.*;
import java.io.Reader;
import static parser.data.Token.*;
      
%% 
   
/* ------ Seccion de opciones y declaraciones de JFlex -------------- */  

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
%}
   

/*
    Macro declaraciones
*/
   
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
RETURN_TYPE = "int" | "float" | "double" | "char" | "string"
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

%% //fin de opciones
/* -------------------- Seccion de reglas lexicas ------------------ */
     
<YYINITIAL> {
   
    {ESPACIO} | {COMENTARIO} {/*Ignorar*/}
        
    /*** OPERADORES ***/

    "+"                {    System.out.print(" ADD ");
                            return symbol(sym.ADD); }
    
    "-"                {    System.out.print(" SUBSTRACT ");
                            return symbol(sym.SUBSTRACT); }
    
    "*"                {    System.out.print(" TIMES ");
                            return symbol(sym.TIMES); }

    "/"                {    System.out.print(" DIVISION ");
                            return symbol(sym.DIVISION); }
    

    /*** SEPARADORES ***/

    "("                {    System.out.print(" LPAREN ");
                            return symbol(sym.LPAREN); }
    
    ")"                {    System.out.print(" RPAREN ");
                            return symbol(sym.RPAREN); }

    "{"                {    System.out.print(" LBRACE ");
                            return symbol(sym.LBRACE); }
    
    "}"                {    System.out.print(" RBRACE ");
                            return symbol(sym.RBRACE); }

    "["                {    System.out.print(" LBRACK ");
                            return symbol(sym.LBRACK); }

    "]"                {    System.out.print(" RBRACK ");
                            return symbol(sym.RBRACK); }

    ","                {    System.out.print(" COMMA ");
                            return symbol(sym.COMMA); }

    "."                {    System.out.print(" DOT ");
                            return symbol(sym.DOT); }

    ";"                {    System.out.print(" SEMICOLON ");
                            return symbol(sym.SEMICOLON); }
     

    /*** SENTENCIAS ***/
    "if"                {   System.out.print(" IF ");
                            return symbol(sym.IF); }

    "else"                {   System.out.print(" ELSE ");
                            return symbol(sym.ELSE); }

    "while"             {   System.out.print(" WHILE ");
                            return symbol(sym.WHILE); }

    "do"                {   System.out.print(" DOWHILE ");
                            return symbol(sym.DO); }

    "for"               {   System.out.print(" FOR ");
                            return symbol(sym.FOR); }

    "switch"            {   System.out.print(" SWITCH ");
                            return symbol(sym.SWITCH); }
       
    /*** COMPARADORES ***/  
    "="               {   System.out.print(" EQUAL ");
                            return symbol(sym.EQUAL); }

    "!"               {   System.out.print(" EXCLAMACION ");
                            return symbol(sym.EXCLAMACION); }

    "<"               {   System.out.print(" MENORQUE ");
                            return symbol(sym.MENORQUE); }

    ">"               {   System.out.print(" MAYORQUE ");
                            return symbol(sym.MAYORQUE); }


    /*** TIPOS ***/
    {RETURN_TYPE}        {   System.out.print(" RETURN_TYPE ");
                            return symbol(sym.RETURN_TYPE); }
                   
    {NUMERO_ENTERO}     { 
                            System.out.print(" NUMERO_ENTERO "); 
                            lexeme= lexema(LITERAL_ENTERO,yytext()); 
                            return symbol(sym.LITERAL_ENTERO, new Integer(yytext()));
                        }

    /*** IDENTIFICADOR ***/
    {ID}                {   
                            System.out.print(" IDENTIFICADOR "); 
                            lexeme = lexema(IDENTIFICADOR,yytext()); 
                            return symbol(sym.IDENTIFICADOR);
                        } 
}
