package veterinaria;

import static java.lang.Character.toUpperCase;
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
        
//          System.out.print(texto);
//        String entrada = new Scanner(System.in).nextLine();
//
//       return toUpperCase(entrada.charAt(0)) == 'S';
 
    }

}
