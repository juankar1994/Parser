package principal;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import parser.view.LexerGUI;

public class ParserPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        generarClases();
    }
    public static void generarClases(){
        try {
            //Creamos el archivo para el .FLEX y generar el scanner
            File file = new File("src\\parser\\data\\reglas_lexicas.flex");
            jflex.Main.generate(file);

            //Creamos el archivo .CUP y generar el parser
            String analizadorSintactico[] = {"-parser", "Parser", "src\\parser\\data\\gramatica.cup"};
            java_cup.Main.main(analizadorSintactico);
            
            //Movemos los archivos generados
            if(!moverArchivo("Parser.java") || !moverArchivo("sym.java")){
                System.out.println("Hubo un problema al generar y mover los archivos");
                System.exit(0);
            }
            System.out.println("Archivos generados correctamente!");
        }
        catch (Exception e) {
          e.printStackTrace(System.out);
          System.exit(1);
        }
    }
    
    public static boolean moverArchivo(String archNombre) {
        boolean efectuado = false;
        File arch = new File(archNombre);
        if (arch.exists()) {
            Path currentRelativePath = Paths.get("");
            String nuevoDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator
                    + "parser" + File.separator + "data" + File.separator + arch.getName();
            File archViejo = new File(nuevoDir);
            archViejo.delete();
            if (arch.renameTo(new File(nuevoDir))) {
                System.out.println("\n*** Generado " + archNombre + "***\n");
                efectuado = true;
            } else {
                System.out.println("\n*** No movido " + archNombre + " ***\n");
            }

        } else {
            System.out.println("\n*** El archivo no existe. ***\n");
        }
        return efectuado;
    }
    
}
