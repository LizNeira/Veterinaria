
package veterinaria;

import java.io.Serializable;

public class Animal implements Serializable
{
    private  String nombre;
    private  String tipo;

      
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }

    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }

    public String getTipo()
    {
        return tipo;
    }
    
     
}
