package veterinaria;

import java.io.Serializable;

public abstract class Empleado implements Serializable
{
    private final String usuario;
    private final String contrasenia;

    public Empleado(String usuario, String contrasenia)
    {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    public String getContrasenia() 
    {
       return contrasenia;
    }

    public String getUsuario() 
    {
       return usuario;
    }

    public abstract boolean menuPrincipal(Sistema sistema);
 
}
