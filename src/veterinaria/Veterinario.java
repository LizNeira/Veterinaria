package veterinaria;

import java.io.Serializable;

public class Veterinario extends Empleado implements Serializable
{  
    private final String especialidad; 
    GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
    private Veterinaria veterinaria;


   public Veterinario(String usuario, String contrasenia, String especialidad)
   {
      super(usuario, contrasenia);
      this.especialidad = especialidad;
      veterinaria = Veterinaria.getInstancia();
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
                     EntradaYSalida.mostrarMensaje("\nCerrando menu del Veterinario...");
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
        veterinaria.getMostrarListaMedicamento(sistema);
        indicePedido = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");
        
        while(indicePedido < 0 || indicePedido > veterinaria.getCantidadProductoMedicamento(sistema))
        {
                  indicePedido = EntradaYSalida.leerEntero("\nOpcion no valida"
                  + "\nIngrese nuevamente: ");
        }

        veterinaria.venderProductoMedicamento(indicePedido, sistema);
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
        veterinaria.getMostrarListaRegular(sistema);
        indicePedido = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");
        
        while(indicePedido < 0 || indicePedido > veterinaria.getCantidadProductoRegular(sistema))
        {
                  indicePedido = EntradaYSalida.leerEntero("\nOpcion no valida"
                  + "\nIngrese nuevamente: ");
        }

        veterinaria.venderProductoRegular(indicePedido, sistema);
        opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");
      
        } while( opcion.equals("s") || opcion.equals("S"));
    }

}
