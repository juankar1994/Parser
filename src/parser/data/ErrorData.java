
package parser.data;

import java.util.ArrayList;

public class ErrorData {
    private int id;
    private String title;
    private String message;
    private ArrayList<ErrorData> errores;
    private static ErrorData instance = null;
    
    public ErrorData(){
        errores = new ArrayList<>();
    }
    
    public ErrorData(int id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message = message;
    }
    
   public static ErrorData getInstance() {
      if(instance == null) {
         instance = new ErrorData();
      }
      return instance;
   }

    public ArrayList<ErrorData> getErrores() {
        return errores;
    }

    public int getId() {
        return id;
    }

    public void setErrores(ArrayList<ErrorData> errores) {
        this.errores = errores;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void insertarError(ErrorData pErrorData){
        errores.add(pErrorData);
    }
}
