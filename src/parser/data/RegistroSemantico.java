
package parser.data;

public class RegistroSemantico {
    private String token; //TOKEN ACTUAL
    private String tipo;  //RS_TIPO, RS_ID, RS_DO, RS_OPERADOR
    private String valor;  //1, 2, 3

    public RegistroSemantico(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }
    
    public RegistroSemantico(String token, String tipo, String valor) {
        this.token = token;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
