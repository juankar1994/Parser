package principal;

import java.io.File;
import parser.data.Token;

public class Scanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path= "src\\parser\\data\\lexer.flex";
        generarLexer(path);
        
    }
    public static void generarLexer(String path){
        File file = new File(path);
        jflex.Main.generate(file);
    }
    
}
