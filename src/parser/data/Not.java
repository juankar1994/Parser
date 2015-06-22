
package parser.data;

public class Not extends Operacion{
    public Not(){
        
    }

    @Override
    public String generarCodigo() {
        String valor1 = ((RegistroSemanticoVar)getRS_OP1()).getDireccion();
        System.out.println(valor1);
        String code = "\tmov eax, "+ valor1 + "\n";
        code += "\tnot eax\n";
        code += "\tmov byte["+this.getVarReturn()+"],eax" + "\n";
        return code;
    }
    
}
