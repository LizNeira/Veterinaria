package veterinaria;

import java.io.Serializable;

public class Controlador implements Serializable
{
     private String usuario;
     private String contrasenia;
     private Veterinaria veterinaria;
     
    public void ejecutar() 
    {   
           GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
           Sistema sistema = new Sistema();
           veterinaria = Veterinaria.getInstancia();
           boolean seguir;

        try 
        {
           sistema = guardarYLeerArchivo.deSerializar();
           seguir = EntradaYSalida.leerBoolean("SISTEMA DE VETERINARIA \nDesea ingresar [s/n]: ");
        } 
        catch (Exception e)
        { 
            usuario = EntradaYSalida.leerCadena("Primer Arranque del sistema.\n"
                    + "Nuevo/a Administrador/a, Ingrese su nombre: ");
            while (usuario.isEmpty())
            {
                usuario = EntradaYSalida.leerCadena("ERROR: El usuario no puede ser nulo"
                        + "Ingrese su usuario: ");
            }
            
            contrasenia = EntradaYSalida.leerCadena("Ingrese su contraseña: ");
            while (contrasenia.isEmpty())
            {
                contrasenia = EntradaYSalida.leerCadena("ERROR: La contraseña no puede ser nula"
                        + "+Ingrese su contraseña:");
            }

            veterinaria.setEmpleado(new Administrador(usuario, contrasenia), sistema);
            EntradaYSalida.mostrarMensaje("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");

            seguir = false;     
        }
        
        while (seguir)
        {
            String dato;
            usuario = EntradaYSalida.leerCadena("\n¡¡BIENVENIDO!!\n"
                    + "Ingrese su usuario: ");
            
            while (usuario.isEmpty())
            {
                EntradaYSalida.leerCadena("ERROR: El usuario no puede ser nulo"
                        + "Ingrese su usuario: ");
            }
            contrasenia = EntradaYSalida.leerCadena("Ingrese su contraseña: ");
            while (contrasenia.isEmpty())
            {
                EntradaYSalida.leerCadena("ERROR: La contraseña no puede ser nula"
                        + "Ingrese su contraseña: ");
            }

            dato = usuario+":"+contrasenia; 
            Empleado empleado = veterinaria.getBuscarEmpleado(dato, sistema);

            if (null == empleado)
            {
                EntradaYSalida.mostrarMensaje("ERROR: La contraseña ingresada no es valida.");    
            } 
            else
            {
               seguir = empleado.menuPrincipal(sistema);
            }
        }

    }
       
}
