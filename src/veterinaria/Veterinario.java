package veterinaria;

import java.io.Serializable;

public class Veterinario extends Empleado implements Serializable
{  
    GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
    private final Veterinaria veterinaria;


   public Veterinario(String usuario, String contrasenia)
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
           mensaje = "\n-----Menu Veterinario-----\n"
                        +"[1] Vender Medicamentos\n"
                        +"[2] Vender Regulares\n"
                        +"[3] Atender Turno\n"
                        +"[4] Salir\n"
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
                     atenderTurno(sistema);
               break;
              case 4:
                     EntradaYSalida.mostrarMensaje("\nCerrando menu del Veterinario...\n");
                break;
           }
            
        } while(opcion != 4);
            
            return true;
    }

    private void venderMedicamento(Sistema sistema)
    {
        String opcion;
        int indicePedido;
        
    if(veterinaria.getMostrarListaRegular(sistema))
     { 
        do 
        {        
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
    }

    private void venderRegular(Sistema sistema)
    {
        String opcion;
        int indicePedido;
        
     if(veterinaria.getMostrarListaRegular(sistema))
      {
        do 
        {   
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
    
    private void atenderTurno(Sistema sistema)
    {
        String opcion;
        String mensaje;
        String especialidad;
    
       do 
       {       
                        mensaje = ("\n---Especialidad---\n"
                                    + "[1] Gato\n"
                                    + "[2] Perro\n"
                                    + "{3} Canario\n"
                                    + "[4] Tortuga\n"
                                    +"\nIngrese el tipo de animal: ");
         especialidad = EntradaYSalida.leerCadena(mensaje);    
            
	     switch (especialidad)
             {
                    case "1":
                            atenderEspecialidadGato(sistema);
                        break;
                    case "2":
                            atenderEspecialidadPerro(sistema);
                        break;
                    case "3":
                            atenderEspecialidadCanario(sistema);
                        break;
                    case "4":
                            atenderEspecialidadTortuga(sistema);
                        break;
             }
            
          opcion = EntradaYSalida.leerCadena("\nDesea continuar[s/n]?: ");
       
       } while( opcion.equals("s") || opcion.equals("S"));
    }
    
    private void atenderEspecialidadGato(Sistema sistema)
    {
        int indiceTurno;
        
            veterinaria.getMostrarListaTurnoGato(sistema);
            indiceTurno = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");

            while(indiceTurno < 0 || indiceTurno > veterinaria.getCantidadTurno("Gato", sistema))
            {
                      indiceTurno = EntradaYSalida.leerEntero("\nOpcion no valida"
                      + "\nIngrese nuevamente: ");
            }

            veterinaria.atenderAnimal("Gato", indiceTurno, sistema);
    }
    
    private void atenderEspecialidadPerro(Sistema sistema)
    {
        int indiceTurno;
     
            veterinaria.getMostrarListaTurnoPerro(sistema);
            indiceTurno = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");

            while(indiceTurno < 0 || indiceTurno > veterinaria.getCantidadTurno("Perro", sistema))
            {
                      indiceTurno = EntradaYSalida.leerEntero("\nOpcion no valida"
                      + "\nIngrese nuevamente: ");
            }

            veterinaria.atenderAnimal("Perro", indiceTurno, sistema);
    
    }

    private void atenderEspecialidadCanario(Sistema sistema)
    {
        int indiceTurno;
     
            veterinaria.getMostrarListaTurnoCanario(sistema);
            indiceTurno = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");

            while(indiceTurno < 0 || indiceTurno > veterinaria.getCantidadTurno("Canario", sistema))
            {
                      indiceTurno = EntradaYSalida.leerEntero("\nOpcion no valida"
                      + "\nIngrese nuevamente: ");
            }

            veterinaria.atenderAnimal("Canario", indiceTurno, sistema);

    }
    
    private void atenderEspecialidadTortuga(Sistema sistema)
    {
        int indiceTurno;

            veterinaria.getMostrarListaTurnoTortuga(sistema);
            indiceTurno = EntradaYSalida.leerEntero("\n\nIngrese una opción: ");

            while(indiceTurno < 0 || indiceTurno > veterinaria.getCantidadTurno("Tortuga", sistema))
            {
                      indiceTurno = EntradaYSalida.leerEntero("\nOpcion no valida"
                      + "\nIngrese nuevamente: ");
            }

            veterinaria.atenderAnimal("Tortuga", indiceTurno, sistema);
      
    }
}
