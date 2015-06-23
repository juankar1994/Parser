
package parser.data;

public class IgualIgual extends Operacion{
    public IgualIgual(){
        
    }

    @Override
    public String generarCodigo() {
        String valor1 = ((RegistroSemanticoVar)getRS_OP1()).getDireccion();
        String valor2 = ((RegistroSemanticoVar)getRS_OP2()).getDireccion();
        String code = "\tmov eax, "+ valor1 + "\n";
        code += "\tmov ebx, "+ valor2 + "\n";
        code += "\tcmp eax, ebx\n";
        code += "\tjne \n";
        code += "\tmov ["+this.getVarReturn()+"],eax" + "\n";
        return code;
    }
    
}
