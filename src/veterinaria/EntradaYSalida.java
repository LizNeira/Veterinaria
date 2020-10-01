package veterinaria;

import static java.lang.Character.toUpperCase;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class EntradaYSalida
{
   private static final Scanner entrada = new Scanner(System.in); 

   private EntradaYSalida()
   {
   }

   public static void mostrarMensaje(final String s)
   {
       System.out.print(s);
   }

   public static String leerCadena(String mensaje)
   {
       System.out.print(mensaje);
       String entrada= new Scanner(System.in).nextLine();
       return (entrada == null ? "" : entrada);
   }
   
   public static int leerEntero(String mensaje)
    {
        System.out.print(mensaje);
        return entrada.nextInt();
    }   
   
   public static Double leerDouble(String mensaje) 
    {
        System.out.print(mensaje);
        return (Double) entrada.nextDouble();
    }
    public static boolean leerBoolean(String texto)
    {
        System.out.print(texto);
        String entrada = new Scanner(System.in).nextLine();

        if (toUpperCase(entrada.charAt(0)) == 'S')
        {
            return true;
        } 
        else
        {
            return false;
        }
        
 
    }
   public static String leerHora()
    {
        
        
        Scanner entrada = new Scanner(System.in);

         String hora;
         Date horaValida = null;
       
        do
        {
            System.out.print("Ingrese la hora (HH:mm): ");
            hora =entrada.nextLine();
          
            try
            {
               horaValida = validarHora(hora);
            }
            catch(ParseException e)
            {
                e.getMessage();
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
        }while( horaValida == null );

               
        return hora;
      }
   
    public static Date validarHora(String horaValidar) throws ParseException, Exception
     {
        
          /*Los turnos se dan desde las 9hs hasta las 18hs en
         intervalos de 30 minutos y con un receso de 12hs a 13.30hs*/
        
         /* 9:15 */
         
         /* 9 a 12 y de 13:30 18 */
         /* 9, 9:30, ...*/
         
        Date hora = null;
        try
        {
             String horaInicialPrimerBloque = "9:00";
             String horaFinalPrimerBloque = "12:00";
             
             String horaInicialSegundoBloque = "13:30";
             String horaFinalSegundoBloque = "18:00";

             
             SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
             formatoHora.setLenient(false);
             
             Date horaIniPrimerBloque;
             Date horaFinPrimerBloque;
             
             Date horaIniSegundoBloque;
             Date horaFinSegundoBloque;

             
             horaIniPrimerBloque = formatoHora.parse(horaInicialPrimerBloque);
             horaFinPrimerBloque = formatoHora.parse(horaFinalPrimerBloque);
             
             horaIniSegundoBloque = formatoHora.parse(horaInicialSegundoBloque);
             horaFinSegundoBloque = formatoHora.parse(horaFinalSegundoBloque);

            hora= formatoHora.parse(horaValidar);
             
            if (    horaIniPrimerBloque.compareTo(hora) <= 0
                 && horaFinPrimerBloque.compareTo(hora) >= 0
                 || horaIniSegundoBloque.compareTo(hora) <= 0
                 && horaFinSegundoBloque.compareTo(hora) >= 0 
               )
               {
                long diferenciaMinutos =  (hora.getTime() - horaIniPrimerBloque.getTime()) / 1000 / 60;
                if ( diferenciaMinutos % 30 > 0 )
                {
                    throw new Exception("Error: Los horarios se deben asignar cada 30 minutos");
                }
            }
            else{
                    throw new Exception("Hora sin atencion al publico");
            }
        }
        catch(ParseException e)
        {
            throw new Exception("La hora no es valida");
        }        
        
        return hora;
    }
}
