/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.data;

import java.util.Stack;

/**
 *
 * @author JuanCarlos
 */
public class PilaSemantica {
    public Stack<RegistroSemantico> pilaSemantica;

    public PilaSemantica() {
       this.pilaSemantica= new Stack<>();
    }
    
    public RegistroSemantico pop(){
        RegistroSemantico s = this.pilaSemantica.pop();
        return s;
    }
    
    public void push(RegistroSemantico pRS){
        this.pilaSemantica.push(pRS);
    }
    
    public RegistroSemantico searchRS(String type){
        Stack<RegistroSemantico> pilaTemp = new Stack<>();
        RegistroSemantico result;
        while (true){
            result = this.pilaSemantica.pop();
            pilaTemp.push(result);
            if(result.getTipo().equals(type)){
                break;
            }
        }
        while(!pilaTemp.isEmpty()){
            this.pilaSemantica.push(pilaTemp.pop());
        }
        return result;
    }
    
    
    
}
