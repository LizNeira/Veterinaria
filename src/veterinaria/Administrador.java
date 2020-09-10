
package veterinaria;

import java.io.Serializable;

public class Administrador extends Empleado implements Serializable
{    
   private GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
    
    public Administrador(String usuario, String contrasenia)
    {
        super(usuario, contrasenia);
    }
   
    @Override
    public boolean menuPrincipal(Sistema sistema)
    {    
        int opcion;
        String mensaje;
        boolean seguir = true;
        
       do
       { 
             mensaje="\n\n----Bienvenidos----\n"
                    +"[1] Dar de alta Veterinario\n"
                    +"[2] Dar de alta Recepcionista\n"
                    +"[3] Dar alta Productos \n"
                    +"[4] \n"
                    +"[5] Salir\n"
                    +"Digite una opcion: ";
         opcion = EntradaYSalida.leerEntero(mensaje);
        
         switch (opcion)
         {
            case 1: 
                    altaVeterinario(sistema);
             break;
            case 2:
                    altaRecepcionista(sistema);
             break;
            case 3:
                   
             break;
            case 4:
                   
             break;
         }
       
       } while (!(opcion == 5));
       
        return seguir;

    }

 
    
    private void altaVeterinario(Sistema sistema)
    {
        Empleado empleado;
        String usuario, contrasenia,especialidad,opcion;
        String dato ;
        do
        {
            usuario = EntradaYSalida.leerCadena("\nIngrese su nombre: ");
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
            
            especialidad = EntradaYSalida.leerCadena("Ingrese su especialidad: ");
            while (especialidad.isEmpty())
            {
                especialidad = EntradaYSalida.leerCadena("ERROR: La especialidad no puede ser nula"
                        + "+Ingrese su especialidad:");
            }
            
            dato = usuario+":"+contrasenia;
            empleado = sistema.getSistemaEmpleado().buscarEmpleado(dato);
            
            if (empleado != null)
            {
                EntradaYSalida.mostrarMensaje("ERROR: El usuario Y/o contraseña ya figuran en el sistema");
            } 
            else
            {
                sistema.getSistemaEmpleado().getlistaEmpleado().add(new Veterinario(usuario, contrasenia,especialidad));
                guardarYLeerArchivo.guardarArchivo(sistema);
                EntradaYSalida.mostrarMensaje("\nSe ha incorporado VETERINARIO al sistema\n");
            }
            
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));
  }
    
    private void altaRecepcionista(Sistema sistema)
    {
        Empleado empleado;
        String usuario, contrasenia;
        String opcion;
        String dato;
        do
        {
            usuario = EntradaYSalida.leerCadena("\nIngrese su nombre: ");
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
            
            dato = usuario+":"+contrasenia;
            empleado = sistema.getSistemaEmpleado().buscarEmpleado(dato);
            
            if (empleado != null)
            {
                EntradaYSalida.mostrarMensaje("ERROR: El usuario y/o contraseña ya figuran en el sistema");
            } 
            else
            {
                sistema.getSistemaEmpleado().getlistaEmpleado().add(new Recepcionista(usuario, contrasenia));
                guardarYLeerArchivo.guardarArchivo(sistema);
                EntradaYSalida.mostrarMensaje("\nSe ha incorporado RECEPCIONISTA al sistema\n");
            }
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));
  }

}
    

   

