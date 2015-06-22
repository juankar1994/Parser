
package parser.data;

public class Not extends Operacion{
    public Not(){
        
    }

    @Override
    public String generarCodigo() {
        String valor1 = ((RegistroSemanticoVar)getRS_OP1()).getDireccion();
        System.out.println(valor1);
        String code = "\tmov eax, "+ valor1 + "\n";
        code += "\tneg eax\n";
        code += "\tmov ["+this.getVarReturn()+"],eax" + "\n";
        return code;
    }
}
