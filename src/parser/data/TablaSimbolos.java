/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.data;

import java.util.Hashtable;

/**
 *
 * @author JuanCarlos
 */
public class TablaSimbolos {
    private Hashtable<String, InfoKey> tablaSimbolos;
    private int numLabel = 1;
    private int numVar = 1;

    public TablaSimbolos() {
        tablaSimbolos = new Hashtable<String, InfoKey>();
    }
    
    public InfoKey get(String pToken){
        return tablaSimbolos.get(pToken);
    }
    
    
    public void put(String pToken, InfoKey pInfoKey){
        tablaSimbolos.put(pToken,pInfoKey);
    }
    
    public String getLabelName(){
        String label = "label_" +numLabel;
        numLabel++;
        return label;
    }
    
    public String getVarName(){
        String label = "var_" +numVar;
        numVar++;
        return label;
    }
    
    
    
}
