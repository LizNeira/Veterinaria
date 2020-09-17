
package veterinaria;

import java.io.Serializable;

public class Recepcionista extends Empleado implements Serializable
{
    
     private GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
     private final Veterinaria veterinaria;
    
     public Recepcionista(String usuario, String contrasenia)
     {
       super(usuario, contrasenia);
       veterinaria = Veterinaria.getInstancia();
     }   

     @Override
     public boolean menuPrincipal(Sistema sistema) 
     {
           int opcion;
           String mensaje;
                       
           do 
           {
                mensaje = "\n\n-----Menu Recepcionista-----\n"
                         +"[1] Dar turnos\n"
                         +"[2] Vender Regulares\n"
                         +"[3]Salir\n"
                         +"Digite una opcion: ";
                opcion = EntradaYSalida.leerEntero(mensaje);
                
                switch (opcion) 
                {
                    case 1:
                           darTurno(sistema);
                       break;
                    case 2:
                           venderRegular(sistema);
                        break;
                    case 3:
                        EntradaYSalida.mostrarMensaje("Cerrando menu del cocinero...");
                      break;
                }
            
           } while(opcion != 3);
            
            return true;
     }

    private void darTurno(Sistema sistema)
    {
        String opcion;
        String nombreDuenio;
        String numeroContacto;
        String nombreAnimal;
        String tipoAnimal;
        String mensaje;
        
       do
        {
            nombreDuenio = EntradaYSalida.leerCadena("\nIngrese el nombre del dueño: ");
            while (nombreDuenio.isEmpty())
            {
                nombreDuenio = EntradaYSalida.leerCadena("ERROR: El nombre no puede ser nulo"
                        + "Ingrese el nombre: ");
            }

            numeroContacto = EntradaYSalida.leerCadena("Ingrese el numero de contacto: ");
            while (numeroContacto.isEmpty())
            {
                numeroContacto = EntradaYSalida.leerCadena("ERROR: El numero no puede ser nulo");
            } 
            
                          mensaje = ("\n---Tipo---\n"
                                    + "[1] Gato\n"
                                    + "[2] Perro\n"
                                    + "{3} Canario\n"
                                    + "[4] Tortuga\n"
                                    +"\nIngrese el tipo de animal: ");
         tipoAnimal = EntradaYSalida.leerCadena(mensaje);    

	         switch (tipoAnimal)
                   {
                    case "1":
                            tipoAnimal = "Gato";
                        break;
                    case "2":
                            tipoAnimal = "Perro";
                        break;
                    case "3":
                            tipoAnimal = "Canario";
                        break;
                    case "4":
                            tipoAnimal = "Tortuga";
                    break;
            }
            
           nombreAnimal = EntradaYSalida.leerCadena("Ingrese el nombre del animal: ");
           while (nombreAnimal.isEmpty())
           {
                nombreAnimal = EntradaYSalida.leerCadena("ERROR: el tipo de animal no puede ser nulo "
                        + "Ingrese el tipo de animal:");
           }

            veterinaria.setTurno(nombreDuenio, numeroContacto, tipoAnimal, nombreAnimal, sistema);
            EntradaYSalida.mostrarMensaje("\nSe ha dado el turno\n");
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S")); 
    }

    private void venderRegular(Sistema sistema)
    {
        String opcion;
        int indiceProducto = 0;
     do 
      {       
        veterinaria.getMostrarListaRegular(sistema);
        indiceProducto = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");
        
        while(indiceProducto < 0 || indiceProducto > veterinaria.getCantidadProductoRegular(sistema))
        {
                  indiceProducto = EntradaYSalida.leerEntero("\nOpcion no valida"
                  + "\nIngrese nuevamente: ");
        }
        
        veterinaria.venderProductoRegular(indiceProducto,sistema);
         
        EntradaYSalida.mostrarMensaje("\n\n¡¡Venta Èxitosa!!\n\n");
        opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");
      
        } while( opcion.equals("s") || opcion.equals("S"));
    }
    

}
