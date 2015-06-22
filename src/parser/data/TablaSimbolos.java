/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.data;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author JuanCarlos
 */
public class TablaSimbolos {
    private Hashtable<String, InfoKey> tablaSimbolos;
    private ArrayList<String> tempVars;
    private int numLabel = 1;
    private int numVar = 1;

    public TablaSimbolos() {
        tablaSimbolos = new Hashtable<String, InfoKey>();
        tempVars = new ArrayList<>();
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
        tempVars.add(label);
        return label;
    }

    public ArrayList<String> getTempVars() {
        return tempVars;
    }

    public void setTempVars(ArrayList<String> tempVars) {
        this.tempVars = tempVars;
    }
    
    public void addVar(String id){
        this.tempVars.add(id);
    }
    
}
