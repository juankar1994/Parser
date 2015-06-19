
package parser.data;

public class InfoKey {
    private String categoria;
    private String tipo;
    private String valor;

    public InfoKey(String categoria, String tipo, String valor) {
        this.categoria = categoria;
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public InfoKey(String categoria, String tipo) {
        this.categoria = categoria;
        this.tipo = tipo;
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
}
