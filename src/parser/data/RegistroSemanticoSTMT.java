
package parser.data;

import java.util.ArrayList;

//RS_IF, RS_WHILE
public class RegistroSemanticoSTMT extends RegistroSemantico{

    private ArrayList<String> etiquetas; 

    public RegistroSemanticoSTMT(String token, String tipo) {
        super(token, tipo);
        this.etiquetas = new ArrayList<>();
    }
    
    public void addEtiqueta(String etiqueta){
        this.etiquetas.add(etiqueta);
    }
}
