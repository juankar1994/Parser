
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
%eofclose false
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

PALABRA_RESERVADA = "break" | "case" | "char" | "const" | "continue" | "default" | "do" | 
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

    ","                {    System.out.println(" COMMA ");
                            return symbol(sym.COMMA,","); }

    ";"                {    System.out.println(" SEMICOLON ");
                            return symbol(sym.SEMICOLON,";"); }

    ":"                {    System.out.println(" COLON ");
                            return symbol(sym.COLON,":"); }
     

    /*** SENTENCIAS ***/
    "if"                {   System.out.println(" IF ");
                            lexeme= lexema(PALABRA_RESERVADA,yytext());
                            return symbol(sym.IF,"if"); }

    "else"                {   System.out.println(" ELSE ");
                            lexeme= lexema(PALABRA_RESERVADA,yytext());
                            return symbol(sym.ELSE,"else"); }

    "while"             {   System.out.println(" WHILE ");
                            lexeme= lexema(PALABRA_RESERVADA,yytext());
                            return symbol(sym.WHILE,"while"); }

    /*** PALABRA_RESERVADA ***/

    "return"              {   System.out.println(" RETURN ");
                            lexeme= lexema(PALABRA_RESERVADA,yytext());
                            return symbol(sym.RETURN,"return"); }

    "void"              {   System.out.println(" VOID ");
                            return symbol(sym.VOID,"void"); }
                            
    /** FUNCIONES **/
    "read"              {   System.out.println(" READ ");
                            lexeme= lexema(READ,yytext());
                            return symbol(sym.READ,"read"); }
    
    "write"             {   System.out.println(" WRITE ");
                            lexeme= lexema(WRITE,yytext());
                            return symbol(sym.WRITE,"write"); }
                            
                            
    /*** TIPOS ***/

    "int"               {   System.out.println(" INT ");
                            lexeme= lexema(TIPO_DATO,yytext()); 
                            return symbol(sym.INT,"int"); }
                   
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

    /*** IDENTIFICADOR ***/
    {ID}                {   
                            System.out.println(" IDENTIFICADOR "); 
                            lexeme = lexema(IDENTIFICADOR,yytext()); 
                            return symbol(sym.IDENTIFICADOR,yytext());
                        } 
    
    {ESPACIO} | {COMENTARIO} {/*Ignorar*/}
    \" {string = "\""; yybegin(STRING_STATE);}
    "/*"        {yybegin(COMENTARIO_STATE);}
    . | 0{NUMERO}* {lexeme = lexema(ERROR,yytext()); return symbol(sym.ERROR);}
    <<EOF>> {  return symbol(sym.EOF);}
}
<STRING_STATE>{
    {CARACTER}+         { string = string.concat(yytext());} 
    
    {FINDELINEA}        {   yybegin(YYINITIAL); string.concat(yytext()); 
                            lexeme = lexema(ERROR,string); return symbol(sym.ERROR);
                        }
    <<EOF>>             {   yybegin(YYINITIAL); string.concat(yytext()); 
                            lexeme = lexema(ERROR,string); return symbol(sym.ERROR);
                        }
}
<COMENTARIO_STATE>{
    [^*] {/*Ignorar*/}
    <<EOF>> { yybegin(YYINITIAL); lexeme = lexema(ERROR,yytext()); return symbol(sym.ERROR);}
}