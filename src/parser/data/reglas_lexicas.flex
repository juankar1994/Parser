
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
TEXTO_DIRECTIVA = <{LETRA}* (.{CARACTER})?>

NUMERO_ENTERO = 0 | {DIGITO}{NUMERO}*(u|U)?(l|L)?
NUMERO_FlOTANTE = (0|({DIGITO}{NUMERO}*))?"."{NUMERO}+(u|U)?(l|L)? | {DIGITO}{NUMERO}*(e|E)"-"?{DIGITO}{NUMERO}*(u|U)?(l|L)?
NUMERO_OCTAL = 0({OCTAL})+(u|U)?(l|L)?
NUMERO_HEXADECIMAL = 0x({HEXADECIMAL})+(u|U)?(l|L)?
ID = {LETRA}({LETRA}|{DIGITO})*  
DIRECTIVAS = "#"(define|if|elif|message|undef|ifdef|include|else|endif|error)
SPECIFIER = "typedef" | "extern" | "static" | "auto" | "register" | "const" | "volatile"
RETURN_TYPE = "int" | "float" | "double" | "char" | "string"

PALABRAS_RESERVADAS = "break" | "case" | "char" | "const" | "continue" | "default" | "do" | 
                      "else" | "for" | "if" | "int" | "long" | "return" | "short" |"switch" | "void" | "while"

OPERADORES = "||" | "&&" | "(" | ")" |
             "++" | "--" | "%" | "!"
             ( "*" | "+" | "-" | "/"  | "=" | "<" | ">"  | "|" | "<<" | ">>" | "-" ){0,1}={0,1}
 


COMENTARIO = {ComentarioNormal} | {ComentariodeLinea} | {ComentarioDocumental}
ComentarioNormal = "/*" [^*] ~"*/" | "/*" "*"+ "/"
ComentariodeLinea = "//" {CARACTER}* {FINDELINEA}?
ComentarioDocumental = "/**" {ContenioComentario} "*"+ "/"
ContenioComentario = ([^*]|\*+[^/*])*
%state STRING_STATE, COMENTARIO_STATE

%% //fin de opciones
/* -------------------- Seccion de reglas lexicas ------------------ */
     
<YYINITIAL> {        
    /*** OPERADORES ***/

    "+"                {    System.out.println(" ADD ");
                            return symbol(sym.ADD,"+"); }
    
    "-"                {    System.out.println(" SUBSTRACT ");
                            return symbol(sym.SUBSTRACT,"-"); }
    
    "*"                {    System.out.println(" TIMES ");
                            return symbol(sym.TIMES,"*"); }

    "/"                {    System.out.println(" DIVISION ");
                            return symbol(sym.DIVISION,"/"); }

    "%"                {    System.out.println(" MODULUS ");
                            return symbol(sym.MODULUS,"%"); }
    
    /*** OPERADORES BINARIOS***/
    "++"                {   System.out.println("PLUSPLUS");
                            return symbol(sym.PLUSPLUS,"++"); }

    "--"                {   System.out.println("MINUSMINUS");
                            return symbol(sym.MINUSMINUS,"--"); }

    "+="                {   System.out.println("PLUSEQ");
                            return symbol(sym.PLUSEQ,"+="); }

    "-="                {   System.out.println("MINUSEQ");
                            return symbol(sym.MINUSEQ,"-="); }

    "*="                {   System.out.println("TIMESEQ");
                            return symbol(sym.TIMESEQ,"*="); }

    "/="                {   System.out.println("DIVEQ");
                            return symbol(sym.DIVEQ,"/="); }

    "%="                {   System.out.println("MODEQ");
                            return symbol(sym.MODEQ,"%="); }

    "&&"                {   System.out.println("&&");
                            return symbol(sym.AND,"&&"); }

    "||"                {   System.out.println("||");
                            return symbol(sym.OR,"||"); }


    /*** COMPARADORES ***/
    "="                 {   System.out.println(" ASSIGN ");
                            return symbol(sym.ASSIGN,"=");}

    "=="                {   System.out.println(" EQUAL ");
                            return symbol(sym.EQUAL,"=="); }

    "!="                 {   System.out.println(" NOTEQ ");
                            return symbol(sym.NOTEQ,"!"); }

    "!"                 {   System.out.println(" EXCLAMACION ");
                            return symbol(sym.EXCLAMACION,"!"); }

    "<"                 {   System.out.println(" MENORQUE ");
                            return symbol(sym.MENORQUE,"<"); }

    ">"                 {   System.out.println(" MAYORQUE ");
                            return symbol(sym.MAYORQUE,">"); }

    "<="                {   System.out.println("MENOREQ");
                            return symbol(sym.MENOREQ,"<=");}
    ">="                {   System.out.println("MAYOREQ");
                            return symbol(sym.MAYOREQ,">=");}


    /*** SEPARADORES ***/

    "("                {    System.out.println(" LPAREN ");
                            return symbol(sym.LPAREN,"("); }
    
    ")"                {    System.out.println(" RPAREN ");
                            return symbol(sym.RPAREN,")"); }

    "{"                {    System.out.println(" LBRACE ");
                            return symbol(sym.LBRACE,"{"); }
    
    "}"                {    System.out.println(" RBRACE ");
                            return symbol(sym.RBRACE,"}"); }

    "["                {    System.out.println(" LBRACK ");
                            return symbol(sym.LBRACK,"["); }

    "]"                {    System.out.println(" RBRACK ");
                            return symbol(sym.RBRACK,"]"); }

    ","                {    System.out.println(" COMMA ");
                            return symbol(sym.COMMA,","); }

    "."                {    System.out.println(" DOT ");
                            return symbol(sym.DOT,"."); }

    ";"                {    System.out.println(" SEMICOLON ");
                            return symbol(sym.SEMICOLON,";"); }

    ":"                {    System.out.println(" COL ");
                            return symbol(sym.COL,":"); }
    "#"                {    System.out.println(" # ");
                            return symbol(sym.SIMBOLO_NUMERO,"#"); }
     

    /*** SENTENCIAS ***/
    "if"                {   System.out.println(" IF ");
                            return symbol(sym.IF,"if"); }

    "else"                {   System.out.println(" ELSE ");
                            return symbol(sym.ELSE,"else"); }

    "while"             {   System.out.println(" WHILE ");
                            return symbol(sym.WHILE,"while"); }

    "do"                {   System.out.println(" DOWHILE ");
                            return symbol(sym.DO,"do"); }

    "for"               {   System.out.println(" FOR ");
                            return symbol(sym.FOR,"for"); }

    "switch"            {   System.out.println(" SWITCH ");
                            return symbol(sym.SWITCH,"switch"); }

    /*** PALABRAS_RESERVADAS ***/
    "default"           {   System.out.println(" DEFAULT ");
                            return symbol(sym.DEFAULT,"default"); }

    "case"              {   System.out.println(" CASE ");
                            return symbol(sym.CASE,"case"); }

    "return"              {   System.out.println(" RETURN ");
                            return symbol(sym.RETURN,"return"); }

    "break"              {   System.out.println(" BREAK ");
                            return symbol(sym.BREAK,"break"); }

    "continue"               {   System.out.println(" CONTINUE ");
                            return symbol(sym.CONTINUE,"continue"); }

    "void"              {   System.out.println(" VOID ");
                            return symbol(sym.VOID,"void"); }
    /*** TIPOS ***/


    "char"              {   System.out.println(" CHAR ");
                            return symbol(sym.CHAR,"char"); }

    "int"               {   System.out.println(" INT ");
                            return symbol(sym.INT,"int"); }

    "short"             {   System.out.println(" SHORT ");
                            return symbol(sym.SHORT,"short"); }

    "long"              {   System.out.println(" LONG ");
                            return symbol(sym.LONG,"long"); }

    "const"             {   System.out.println(" CONST ");
                            return symbol(sym.CONST,"const"); }
                   
    {NUMERO_ENTERO}     { 
                            System.out.println(" NUMERO_ENTERO "); 
                            lexeme= lexema(LITERAL_ENTERO,yytext()); 
                            return symbol(sym.LITERAL_ENTERO, new Integer(yytext()));
                        }

    {CARACTER_C}        { 
                            System.out.println(" CARACTER_C "); 
                            lexeme= lexema(LITERAL_CARACTER,yytext()); 
                            return symbol(sym.LITERAL_CARACTER, yytext());                            
                        }

    /*** DIRECTIVAS ***/                    
    "include"           {   System.out.println(" INCLUDE ");
                            return symbol(sym.INCLUDE,"include"); 
                        }

    {TEXTO_DIRECTIVA}   {   System.out.println(" TEXTO_DIRECTIVA ");
                            return symbol(sym.TEXTO_DIRECTIVA,"texto_directiva"); 
                        }

    /*** IDENTIFICADOR ***/
    {ID}                {   
                            System.out.println(" IDENTIFICADOR "); 
                            lexeme = lexema(IDENTIFICADOR,yytext()); 
                            return symbol(sym.IDENTIFICADOR,yytext());
                        } 
    
    {ESPACIO} | {COMENTARIO} {/*Ignorar*/}
    \" {string = "\""; yybegin(STRING_STATE);}
    "/*"        {yybegin(COMENTARIO_STATE);}
    . | 0{NUMERO}* | {DIGITO}({DIGITO}|{LETRA})*  {lexeme = lexema(ERROR); return symbol(sym.error);}
    <<EOF>> { return symbol(sym.EOF);}
}
<STRING_STATE>{
    {CARACTER}+         { string = string.concat(yytext());} 
    \"                  {   yybegin(YYINITIAL);string = string.concat(yytext());
                            System.out.println(" LITERAL STRING ");    
                            lexeme = lexema(LITERAL_STRING,string); return symbol(sym.LITERAL_STRING);
                        }

    {FINDELINEA}        {   yybegin(YYINITIAL); string.concat(yytext()); 
                            lexeme = lexema(ERROR,string); return symbol(sym.error);
                        }
    <<EOF>>             {   yybegin(YYINITIAL); string.concat(yytext()); 
                            lexeme = lexema(ERROR,string); return symbol(sym.error);
                        }
}
<COMENTARIO_STATE>{
    [^*] {/*Ignorar*/}
    <<EOF>> { yybegin(YYINITIAL); lexeme = lexema(ERROR,yytext()); return symbol(sym.error);}
}