
package parser.data;

public class InfoKey {
    private String categoria; 
    private String tipo;      
    private String valor;     
    private int numDeclarado = 0;

    public InfoKey(String categoria, String tipo, String valor) {
        this.categoria = categoria;
        this.tipo = tipo;
        this.valor = valor;
        this.numDeclarado++;
    }
    
    public InfoKey(String categoria, String tipo) {
        this.categoria = categoria;
        this.tipo = tipo;
        this.numDeclarado++;
    }

    public void sumarDeclarado(){
        this.numDeclarado++;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getNumDeclarado() {
        return numDeclarado;
    }

    public void setNumDeclarado(int numDeclarado) {
        this.numDeclarado = numDeclarado;
    }    
}
