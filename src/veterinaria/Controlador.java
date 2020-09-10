package veterinaria;

import java.io.Serializable;

public class Controlador implements Serializable
{
     private String usuario;
     private String contrasenia;
     
    public Controlador()
    {
        
    }
    
    public void ejecutar() 
    {   
           GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
           Sistema sistema = new Sistema();

        boolean seguir;

        try 
        {
           sistema = guardarYLeerArchivo.deSerializar();
           seguir = EntradaYSalida.leerBoolean("SISTEMA DE VETERINARIA \nDesea ingresar [s/n]: ");
        } 
        catch (Exception e)
        { 
            usuario = EntradaYSalida.leerCadena("Primer Arranque del sistema.\n"
                    + "Nuevo Administrador, Ingrese su nombre: ");
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

           sistema.getSistemaEmpleado().getlistaEmpleado().add(new Administrador(usuario, contrasenia));
           guardarYLeerArchivo.guardarArchivo(sistema);

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
            Empleado empleado = sistema.getSistemaEmpleado().buscarEmpleado(dato);

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
