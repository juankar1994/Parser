
package parser.data;

public class MasMas extends Operacion{
    public MasMas(){
        
    }

    @Override
    public String generarCodigo() {
        String valor1 = ((RegistroSemanticoVar)getRS_OP1()).getDireccion();
        String code = "\tmov eax, "+ valor1 + "\n";
        code += "\tinc eax" + "\n";
        code += "\tmov byte["+this.getVarReturn()+"],eax" + "\n";
        return code;
    }
    
}
