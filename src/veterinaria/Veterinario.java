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
                        +"[1] \n"
                        +"[2] Salir\n"
                        +"Digite una opcion: ";
           opcion = EntradaYSalida.leerEntero(mensaje);
                
           switch (opcion) 
           {
              case 1:
                  
               break;
              case 2:
                      EntradaYSalida.mostrarMensaje("Cerrando menu del camarero...");
                break;
           }
            
        } while(opcion != 2);
            
            return true;
    }

}
