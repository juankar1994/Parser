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
public interface IOperacion {
    public String generarCodigo();
    public void setOperandos(RegistroSemantico RS_DO1,RegistroSemantico RS_DO2);
    public void setOperandor(RegistroSemantico RS_DO1);
    public void setVarReturn(String varReturn);
    public RegistroSemantico getRS_OP1();
}
