
package veterinaria;

import java.io.Serializable;


public class Medicamento extends Producto implements Serializable
{

    public Medicamento(String descripcion, Double precio)
    {
        super(descripcion, precio);
    }
    
}
