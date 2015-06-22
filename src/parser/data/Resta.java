
package parser.data;

public class Resta extends Operacion{
    public Resta(){
        
    }

    @Override
    public String generarCodigo() {
        String valor1 = ((RegistroSemanticoVar)getRS_OP1()).getDireccion();
        System.out.println(valor1);
        String valor2 = ((RegistroSemanticoVar)getRS_OP2()).getDireccion();
        System.out.println(valor2);
        String code = "\tmov eax, "+ valor2 + "\n";
        code += "\tmov ebx, "+ valor1 + "\n";
        code += "\tsub eax,ebx" + "\n";
        code += "\tmov byte["+this.getVarReturn()+"],eax" + "\n";
        return code;
    }
    
}
