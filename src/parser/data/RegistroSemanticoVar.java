/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.data;

/**
 *
 * @author JuanCarlos
 */
public class RegistroSemanticoVar extends RegistroSemantico{
    private String direccion;

    public RegistroSemanticoVar(String token, String tipo, String valor,String direccion) {
        super(token, tipo, valor);
        setDireccion(direccion);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    
    
}
