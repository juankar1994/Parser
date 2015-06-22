
package parser.data;

public class MenosMenos extends Operacion{
    public MenosMenos(){
        
    }

    @Override
    public String generarCodigo() {
        String valor1 = ((RegistroSemanticoVar)getRS_OP1()).getDireccion();
        String code = "\tmov eax, "+ valor1 + "\n";
        code += "\tdec eax" + "\n";
        code += "\tmov ["+this.getVarReturn()+"],eax" + "\n";
        return code;
    }
    
}