
package veterinaria;


public class Producto 
{
    private final String descripcion;
    private final Double precio;

    public Producto(String descripcion, Double precio)
    {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion()
    {
        return descripcion;
    }
    
    public Double getprecio()
    {
        return precio;
    }

}
