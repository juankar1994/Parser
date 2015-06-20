
package parser.data;

import java.util.ArrayList;

//RS_IF, RS_WHILE
public class RegistroSemanticoSTMT extends RegistroSemantico{

    private String exit_label;
    private String stmt_label;

    public RegistroSemanticoSTMT(String token, String tipo) {
        super(token, tipo);
        this.setStmt_label(stmt_label);
    }

    public String getExit_label() {
        return exit_label;
    }

    public void setExit_label(String exit_label) {
        this.exit_label = exit_label;
    }

    public String getStmt_label() {
        return stmt_label;
    }

    public void setStmt_label(String stmt_label) {
        this.stmt_label = stmt_label;
    }
    
}
