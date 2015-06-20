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
public abstract class Operacion implements IOperacion{
    private RegistroSemantico RS_OP1;
    private RegistroSemantico RS_OP2;

    @Override
    public void setOperandos(RegistroSemantico RS_DO1, RegistroSemantico RS_DO2) {
        setRS_OP1(RS_OP1);
        setRS_OP2(RS_OP2);
    }
    
    @Override
    public void setOperandor(RegistroSemantico RS_DO1) {
        setRS_OP1(RS_OP1);
    }

    public RegistroSemantico getRS_OP1() {
        return RS_OP1;
    }

    public void setRS_OP1(RegistroSemantico RS_OP1) {
        this.RS_OP1 = RS_OP1;
    }

    public RegistroSemantico getRS_OP2() {
        return RS_OP2;
    }

    public void setRS_OP2(RegistroSemantico RS_OP2) {
        this.RS_OP2 = RS_OP2;
    }
    
}
