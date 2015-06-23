
package parser.data;

public class Suma extends Operacion{
    public Suma(){
        
    }

    @Override
    public String generarCodigo() {
        String valor1 = ((RegistroSemanticoVar)getRS_OP1()).getDireccion();
        System.out.println("__________________"+valor1);
        String valor2 = ((RegistroSemanticoVar)getRS_OP2()).getDireccion();
        System.out.println("__________________"+valor2);
        String code = "\tmov eax, "+ valor2 + "\n";
        code += "\tmov ebx, "+ valor1 + "\n";
        code += "\tadd eax,ebx" + "\n";
        code += "\tmov ["+this.getVarReturn()+"],eax" + "\n";
        return code;
    }
    
}
