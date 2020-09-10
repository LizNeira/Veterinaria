
package veterinaria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GuardarYLeerArchivo implements Serializable
{
    private String nombreArchivo;
    
    public GuardarYLeerArchivo()
    {

        this.nombreArchivo = "veterinaria.txt";
    }
  
    
    public Sistema deSerializar() throws IOException, ClassNotFoundException 
     {
        FileInputStream f = new FileInputStream(this.nombreArchivo);
        ObjectInputStream o = new ObjectInputStream(f);
        Sistema sistema = (Sistema) o.readObject();
        o.close();
        f.close();
        return sistema;
     }

      public void serializar(Sistema sistema) throws IOException 
    {
        FileOutputStream f = new FileOutputStream(this.nombreArchivo);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(sistema);
        o.close();
        f.close();
     }
    public void guardarArchivo(Sistema sistema)
    {
            try 
              {
                  this.serializar(sistema);
              } 
               catch (IOException e)
             {
                    e.getMessage();
             }
    }

}
