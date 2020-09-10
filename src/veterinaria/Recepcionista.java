
package veterinaria;

import java.io.Serializable;

public class Recepcionista extends Empleado implements Serializable
{
    
     private GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
    
     public Recepcionista(String usuario, String contrasenia)
     {
       super(usuario, contrasenia);
     }   

     @Override
     public boolean menuPrincipal(Sistema sistema) 
     {
           int opcion;
           String mensaje;
                       
           do 
           {
                mensaje = "\n-----Menu Recepcionista-----\n"
                         +"[1] \n"
                         +"[2] \n"
                         +"[3] Salir\n"
                         +"Digite una opcion: ";
                opcion = EntradaYSalida.leerEntero(mensaje);
                
                switch (opcion) 
                {
                    case 1:
                        
                       break;
                    case 2:
                        
                        break;
                    case 3:
                        EntradaYSalida.mostrarMensaje("Cerrando menu del cocinero...");
                      break;
                }
            
           } while(opcion != 3);
            
            return true;
     }

}
