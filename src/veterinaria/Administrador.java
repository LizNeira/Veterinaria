
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
                    +"[3] Dar alta Productos\n"
                    +"[4] Ver Medicamentos\n"
                    +"[5] Ver Regulares\n"
                    +"[6] Ver Medicamentos Vendidos\n"
                    +"[7] Ver Regulares Vendidos\n"
                    +"[8] Salir\n"
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
                    listaMedicamento(sistema);
             break;
            case 5:  
                    listaRegular(sistema);
             break;
             
            case 6:  
                    listaMedicamentoVendido(sistema);
             break;
            case 7:  
                    listaRegularVendido(sistema);
              break;
         }
       
       } while (!(opcion == 8));
       
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
 
            sistema.getSistemaProducto().getListaRegular().add(new Regular(descripcion,precio));
            guardarYLeerArchivo.guardarArchivo(sistema);
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
 
            sistema.getSistemaProducto().getListaMedicamento().add(new Medicamento(descripcion,precio));
            guardarYLeerArchivo.guardarArchivo(sistema);
            EntradaYSalida.mostrarMensaje("\nEl producto se ha dado de alta\n");
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S"));   
    }

    private void listaMedicamento(Sistema sistema)
    {
        
      EntradaYSalida.mostrarMensaje("\n---lista de Medicamentos---\n");
      sistema.getSistemaProducto().mostrarListaMedicamento();
      EntradaYSalida.leerCadena("\n\nPresione cualquier tecla para salir ");
      guardarYLeerArchivo.guardarArchivo(sistema);      
    }
    private void listaRegular(Sistema sistema)
    {
        
      EntradaYSalida.mostrarMensaje("\n---lista de Regulares---\n");
      sistema.getSistemaProducto().mostrarListaRegular();
      EntradaYSalida.leerCadena("\n\nPresione cualquier tecla para salir ");
      guardarYLeerArchivo.guardarArchivo(sistema);      
    }
    
    private void listaMedicamentoVendido(Sistema sistema)
    {
     int i = 1;
        
        for  (Producto producto : sistema.getSistemaProducto().getListaMedicamentoVendido())
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i)+"]"
                                          +"||Preparaciones: " +producto.getDescripcion()
                                          +"||Bebida: "+producto.getprecio());
            i++;
        }
        EntradaYSalida.leerCadena("\nPresione cualquier tecla para salir ");
        guardarYLeerArchivo.guardarArchivo(sistema);
    }
    
    private void listaRegularVendido(Sistema sistema)
    {
     int i = 1;
        
        for  (Producto producto : sistema.getSistemaProducto().getListaRegularVendido())
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i)+"]"
                                          +"||Preparaciones: " +producto.getDescripcion()
                                          +"||Bebida: "+producto.getprecio());
            i++;
        }
        EntradaYSalida.leerCadena("\nPresione cualquier tecla para salir ");
        guardarYLeerArchivo.guardarArchivo(sistema);
    }

}
    

   

