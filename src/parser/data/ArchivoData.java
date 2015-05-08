
package parser.data;

import java.io.File;


public class ArchivoData {
    File archivo;
  
    public ArchivoData() {
        this.archivo = null;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
}
