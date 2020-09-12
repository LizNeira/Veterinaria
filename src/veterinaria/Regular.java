package veterinaria;

import java.io.Serializable;


public class Regular extends Producto implements Serializable
{

    public Regular(String descripcion, Double precio) 
    {
        super(descripcion, precio);
    }
    
}
