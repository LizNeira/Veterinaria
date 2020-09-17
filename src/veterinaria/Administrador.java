
package veterinaria;

import java.io.Serializable;

public class Administrador extends Empleado implements Serializable
{    
   private GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
   private Veterinaria veterinaria;
    
    public Administrador(String usuario, String contrasenia)
    {
        super(usuario, contrasenia);
        veterinaria = Veterinaria.getInstancia();
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
                    +"[3] Dar alta Productos\n"
                    +"[4] Ver Medicamentos\n"
                    +"[5] Ver Regulares\n"
                    +"[6] Ver Medicamentos Vendidos\n"
                    +"[7] Ver Regulares Vendidos\n"
                    +"[8] Salir\n"
                    +"[9] Salir del sistema\n"
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
                    altaProducto(sistema);
             break;
            case 4:  
                    veterinaria.getMostrarListaMedicamento(sistema);
                    EntradaYSalida.leerCadena("\n\nPresione cualquier tecla para salir ");
             break;
            case 5:  
                    veterinaria.getMostrarListaRegular(sistema);
                    EntradaYSalida.leerCadena("\n\nPresione cualquier tecla para salir ");
             break;
            case 6:  
                    veterinaria.getMostrarListaMedicamentoVendido(sistema);
             break;
            case 7:  
                    veterinaria.getMostrarListaRegularVendido(sistema);
              break;
            case 9:
                    seguir = false;
                    EntradaYSalida.mostrarMensaje("Cerrando sistema...\n");
             break;
         }
       
       } while (!(opcion == 8) && !(opcion == 9));
       
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
            
            dato = usuario+":"+contrasenia;
            empleado = veterinaria.getBuscarEmpleado(dato, sistema);
            
            if (empleado != null)
            {
                EntradaYSalida.mostrarMensaje("ERROR: El usuario Y/o contraseña ya figuran en el sistema");
            } 
            else
            {
                veterinaria.setEmpleado(new Veterinario(usuario, contrasenia), sistema);
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
            empleado = veterinaria.getBuscarEmpleado(dato, sistema);
            
            if (empleado != null)
            {
                EntradaYSalida.mostrarMensaje("ERROR: El usuario y/o contraseña ya figuran en el sistema");
            } 
            else
            {
              veterinaria.setEmpleado(new Recepcionista(usuario, contrasenia), sistema);
              EntradaYSalida.mostrarMensaje("\nSe ha incorporado RECEPCIONISTA al sistema\n");
            }
            
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));
  }

    private void altaProducto(Sistema sistema)
    {
        int opcion;
        String mensaje;
     do
       { 
             mensaje="\n\n----Alta Productos----\n"
                    +"[1] Regulares\n"
                    +"[2] Medicamentos\n"
                    +"[3] Salir\n"
                    +"Digite una opcion: ";
         opcion = EntradaYSalida.leerEntero(mensaje);
        
         switch (opcion)
         {
            case 1: 
                    altaRegulares(sistema);
             break;
            case 2:
                    altaMedicamento(sistema);
             break;
         }
       
       } while (!(opcion == 3));
        
    }

    private void altaRegulares(Sistema sistema)
    {
        String opcion;
        String descripcion;
        Double precio = 0.0;
       do
        {
            descripcion = EntradaYSalida.leerCadena("\nIngrese la descripcion: ");
            while (descripcion.isEmpty())
            {
                descripcion = EntradaYSalida.leerCadena("ERROR: La descripcion no puede ser nula"
                        + "Ingrese la descripcion: ");
            }

            precio = EntradaYSalida.leerDouble("Ingrese el precio: ");
            while (precio <= 0)
            {
                precio = EntradaYSalida.leerDouble("ERROR: precio invalido "
                        + "Ingrese el precio:");
            }

            veterinaria.setProductoRegular(new Regular(descripcion,precio), sistema);
            EntradaYSalida.mostrarMensaje("\nEl producto se ha dado de alta\n");
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));
        
    }

    private void altaMedicamento(Sistema sistema)
    {
        String opcion;
        String descripcion;
        Double precio = 0.0;
       do
        {
            descripcion = EntradaYSalida.leerCadena("\nIngrese la descripcion: ");
            while (descripcion.isEmpty())
            {
                descripcion = EntradaYSalida.leerCadena("ERROR: La descripcion no puede ser nula"
                        + "Ingrese la descripcion: ");
            }

            precio = EntradaYSalida.leerDouble("Ingrese el precio: ");
            while (precio <= 0)
            {
                precio = EntradaYSalida.leerDouble("ERROR: precio invalido "
                        + "Ingrese el precio:");
            }
 
            veterinaria.setProductoMedicamento(new Medicamento(descripcion,precio), sistema);
            EntradaYSalida.mostrarMensaje("\nEl producto se ha dado de alta\n");
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));   
    }
  
}
    

   

