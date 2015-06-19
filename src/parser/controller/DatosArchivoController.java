
package parser.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFileChooser;
import parser.data.ArchivoData;
import parser.data.Lexema;
import parser.data.Lexer;
import parser.data.Parser;
import parser.data.Token;
import parser.data.ErrorData;
import parser.data.sym;

public class DatosArchivoController {
    
    //Referencia al archivo leído
    ArchivoData archivoData = new ArchivoData();
    ErrorData errorData;
    
    public void setArchivo(JFileChooser archivoSeleccionado, String comando){
        if(comando.equals(JFileChooser.APPROVE_SELECTION)){
            File archivo = archivoSeleccionado.getSelectedFile();
            archivoData.setArchivo(archivo);
        }
    }
    
    public File getArchivoFromData(){
        return archivoData.getArchivo();
    }
    
    public ArrayList<Lexema> analizarArchivo() throws FileNotFoundException, IOException{
        File archivo = archivoData.getArchivo();
        
        Reader reader = new BufferedReader(new FileReader(archivo));
        
        Lexer lexer = new Lexer (reader);
        ArrayList<Lexema> lexemas = new ArrayList<>();
        
        while (true){
            int a = lexer.next_token().sym;
            if(a==0) break;
            lexemas.add(lexer.lexeme);     
        }
        
        return lexemas;       
    }
    
    public void analizarArchivoSintactico() {
        try{
            errorData.getErrores().clear();
        }catch(Exception e){ System.out.print(""); }
        
        String[] archivo = {archivoData.getArchivo().getAbsolutePath()};
        Parser.main(archivo);
    }
    
    public ArrayList<ArrayList<Lexema>> separarTokens(ArrayList<Lexema> lexemas){
        ArrayList<Lexema> lexemasValidos = new ArrayList<>();
        ArrayList<Lexema> lexemasErrores = new ArrayList<>();
        ArrayList<ArrayList<Lexema>> lexemasTotales = new ArrayList<>();
        
        for (Lexema lexema : lexemas) {
            if(lexema.getType() != Token.ERROR){
                //Hacer la lista de los Tokens válidos
                lexemasValidos.add(lexema);
            }else{
                //Hacer la lista de los Tokens no válidos
                lexemasErrores.add(lexema);
            } 
        }
        lexemasTotales.add(lexemasValidos);
        lexemasTotales.add(lexemasErrores);
        
        //Una vez divididos en listas los errores se retorna para crear el Object[][]
        return lexemasTotales;
    }
    
    public String mostrarErroresSintacticos() throws IllegalArgumentException, IllegalAccessException{
        errorData = ErrorData.getInstance();
        ArrayList<ErrorData> errores = errorData.getErrores();
        String msjErrores = "", tituloTexto = "";
        for (ErrorData error : errores) {
            Field fld[] = sym.class.getDeclaredFields();
            for (int i = 0; i < fld.length; i++)
            {
                Object value = fld[i].get(fld[i].getName());
                value = "#" + value;
                if(value.equals(error.getTitle()))
                    tituloTexto = fld[i].getName();                    
            }
            //Evitar errores léxicos
            if(!tituloTexto.equals("ERROR"))
                msjErrores += "Error Sintáctico: " + error.getId() + "\n\tMotivo: " + tituloTexto + "  \n\tMensaje: " + error.getMessage() + "\n";
        }
        return msjErrores;
    }
    
    public Object[][] getListaTokensErrores(ArrayList<Lexema> lexemas){
        Object[][] listaTokensErrores = new Object[lexemas.size()][2];
        
        ArrayList<Integer> lineas = new ArrayList<>();
        int cont = 0;
        String lineasFinales = "";
        
        for (int j = 0; j < lexemas.size(); j++)
            lineas.add(lexemas.get(j).getLine());
        
        Set<Integer> unique = new HashSet<>(lineas);
        for (Integer key : unique) {
            lineasFinales = key.toString();
            if(Collections.frequency(lineas, key) > 1)
                lineasFinales += "(" + Collections.frequency(lineas, key) + ")";
            listaTokensErrores[cont] = new Object[] { (!"".equals(lexemas.get(cont).getValue().toString())) 
                                    ? lexemas.get(cont).getValue() : "Fin de comentario incorrecto", ((Object)(Integer.valueOf(lineasFinales) + 1)) };
            
            cont++;
        }
        Object[][] listaTokensFinal = Arrays.copyOf(listaTokensErrores, cont);
        return listaTokensFinal;
    }
    
    public Object[][] getListaTokensValidos(ArrayList<Lexema> lexemas){
        Object[][] listaTokensValidos = new Object[lexemas.size()][2];
        ArrayList<Integer> lineas;
        ArrayList<Integer> exclusion = new ArrayList<>();
        int cont = 0;
        
        for (int i = 0; i < lexemas.size(); i++) {
            if(isExclusive(exclusion, i))
                continue;
            lineas = new ArrayList<>();
            
            for (int j = i; j < lexemas.size(); j++) {
                if(lexemas.get(i).getValue().equals(lexemas.get(j).getValue())
                        && lexemas.get(i).getType().equals(lexemas.get(j).getType())){
                    exclusion.add(j);
                    lineas.add(lexemas.get(j).getLine());
                }
            }
            
            String lineasFinales = getListaRepetidos(lineas);
            listaTokensValidos[cont] = new Object[] { lexemas.get(i).getValue(), 
                lexemas.get(i).getType(), lineasFinales};
            cont++;
        }
        
        Object[][] listaTokensFinal = Arrays.copyOf(listaTokensValidos, cont);
        return listaTokensFinal;
    }
    
    public String getListaRepetidos(ArrayList<Integer> pLineas){
        ArrayList<Integer> exclusion = new ArrayList<>();
        String resultado = "";
        
        int cont;
        
        for(int i = 0; i < pLineas.size(); i++){
            cont = 0;
            if(isExclusive(exclusion, pLineas.get(i)))
                continue;
            
            for(int j = i; j < pLineas.size(); j++){
                if(pLineas.get(i).equals(pLineas.get(j))){
                    exclusion.add(pLineas.get(j));
                    cont++;
                }
            }
            
            resultado += pLineas.get(i);
            
            if(cont > 1)
                resultado += "(" + cont + "),";
            else
                resultado += ",";
        }
        StringBuilder b = new StringBuilder(resultado);
        b.replace(resultado.lastIndexOf(","), resultado.lastIndexOf(",") + 1, "." );
        resultado = b.toString();
        return resultado;
    }
    
    public boolean isExclusive(ArrayList<Integer> pExclusive, int pIndex){
        for (Integer e : pExclusive) {
            if (e.equals(pIndex)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isDuplicated(ArrayList<Integer> pExclusive, int pIndex){
        int cont = 0;
        for (Integer e : pExclusive) {
            if (e.equals(pIndex)) {
                cont++;
            }
        }
        if(cont > 1)
            return true;
        else
            return false;
    }
}
