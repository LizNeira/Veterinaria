
package veterinaria;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Recepcionista extends Empleado implements Serializable
{
    
     private GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
     private Veterinaria veterinaria;
    
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
                           sistema.getSistemaTurno().mostrarListaTurno();
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
        FactoriaTurno factoriaTurno = FactoriaTurno.getInstancia();
        
       do
        {
            nombreDuenio = EntradaYSalida.leerCadena("\nIngrese el nombre: ");
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
            
            tipoAnimal = EntradaYSalida.leerCadena("Ingrese el tipo de animal: ");
            while (tipoAnimal.isEmpty())
            {
                tipoAnimal = EntradaYSalida.leerCadena("ERROR: el tipo de animal no puede ser nulo "
                        + "Ingrese el tipo de animal:");
            }
            
           nombreAnimal = EntradaYSalida.leerCadena("Ingrese el nombre del animal: ");
            while (nombreAnimal.isEmpty())
            {
                nombreAnimal = EntradaYSalida.leerCadena("ERROR: el tipo de animal no puede ser nulo "
                        + "Ingrese el tipo de animal:");
            }
            
            try 
            {
                Animal animal = factoriaTurno.crearAnimal(nombreAnimal, tipoAnimal);
                Duenio duenio = factoriaTurno.crearDuenio("Duenio" ,nombreDuenio, numeroContacto);
                sistema.getSistemaTurno().getListaTurno().add(new Turno(animal,duenio));
            } catch (ReflectiveOperationException ex) {
                Logger.getLogger(Recepcionista.class.getName()).log(Level.SEVERE, null, ex);
            }
         
                
            guardarYLeerArchivo.guardarArchivo(sistema);
            EntradaYSalida.mostrarMensaje("\nSe ha dado el turno\n");
            opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");

        } while (opcion.equals("s") || opcion.equals("S")); 
    }

    private void venderRegular(Sistema sistema)
    {
        String opcion;
        int indiceProducto;
     do 
      {       
        EntradaYSalida.mostrarMensaje("\n---Lista de Regulares---\n");
        veterinaria.getMostrarListaRegular(sistema);
        indiceProducto = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");
        
        while(indiceProducto < 0 || indiceProducto > veterinaria.getCantidadProductoRegular(sistema))
        {
                  indiceProducto = EntradaYSalida.leerEntero("\nOpcion no valida"
                  + "\nIngrese nuevamente: ");
        }
        
         veterinaria.venderProductoRegular(indiceProducto, sistema);
        opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");
      
        } while( opcion.equals("s") || opcion.equals("S"));
    }
    

}
