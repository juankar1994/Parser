
package parser.data;

public class Lexema {
  private Token type;
  private Object value;
  private int line;
  private int column;

    public Lexema(Token type, int line, int column) {
        this(type, null, line, column);
    }

    public Lexema(Token type, Object value, int line, int column) {
        this.type = type;
        this.value = value;
        this.line = line;
        this.column = column;
    }

    public Token getType() {
        return type;
    }

    public void setType(Token type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Lexema{" + "type=" + type + ", value=" + value + ", line=" + line + '}';
    }
    
    
  
}
