package veterinaria;

import java.io.Serializable;

public class Veterinario extends Empleado implements Serializable
{  
   private final String especialidad; 
   Controlador controlador = null;
   GuardarYLeerArchivo guardarYLeerArchivo =new GuardarYLeerArchivo();

   public Veterinario(String usuario, String contrasenia, String especialidad)
   {
      super(usuario, contrasenia);
      this.especialidad = especialidad;
   }
   
   @Override
   public boolean menuPrincipal(Sistema sistema) 
   {
        int opcion;
        String mensaje;
            
        do 
        {
           mensaje = "\n-----Menu Veterinario-----\n"
                        +"[1] Vender Medicamentos\n"
                        +"[2] Vender Regulares\n"
                        +"[3] Salir\n"
                        +"Digite una opcion: ";
           opcion = EntradaYSalida.leerEntero(mensaje);
                
           switch (opcion) 
           {
              case 1:
                     venderMedicamento(sistema);
                  
               break;
              case 2:
                     venderRegular(sistema);
                  
               break;
              case 3:

                     EntradaYSalida.mostrarMensaje("Cerrando menu del camarero...");
                break;
           }
            
        } while(opcion != 3);
            
            return true;
    }

    private void venderMedicamento(Sistema sistema)
    {
        String opcion;
        int indicePedido;
     do 
      {       
        EntradaYSalida.mostrarMensaje("\n---Lista de Medicamentos---\n");
        sistema.getSistemaProducto().mostrarListaMedicamento();
        indicePedido = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");
        while(indicePedido < 0 || indicePedido > sistema.getSistemaProducto().getListaMedicamento().size())
        {
                  indicePedido = EntradaYSalida.leerEntero("\nOpcion no valida"
                  + "\nIngrese nuevamente: ");
        }
        Producto productoSeleccionado = sistema.getSistemaProducto().getListaMedicamento().get(indicePedido -1);
        sistema.getSistemaProducto().getListaMedicamentoVendido().add(productoSeleccionado);
        sistema.getSistemaProducto().getListaMedicamento().remove(indicePedido -1);
        guardarYLeerArchivo.guardarArchivo(sistema);
        opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");
      
        } while( opcion.equals("s") || opcion.equals("S"));
    }

    private void venderRegular(Sistema sistema)
    {
        String opcion;
        int indicePedido;
     do 
      {       
        EntradaYSalida.mostrarMensaje("\n---Lista de Regulares---\n");
        sistema.getSistemaProducto().mostrarListaRegular();
        indicePedido = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");
        while(indicePedido < 0 || indicePedido > sistema.getSistemaProducto().getListaRegular().size())
        {
                  indicePedido = EntradaYSalida.leerEntero("\nOpcion no valida"
                  + "\nIngrese nuevamente: ");
        }
        
        Producto productoSeleccionado = sistema.getSistemaProducto().getListaRegular().get(indicePedido -1);
        sistema.getSistemaProducto().getListaRegularVendido().add(productoSeleccionado);
        sistema.getSistemaProducto().getListaRegular().remove(indicePedido -1);
        guardarYLeerArchivo.guardarArchivo(sistema);
        opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");
      
        } while( opcion.equals("s") || opcion.equals("S"));
    }

}
