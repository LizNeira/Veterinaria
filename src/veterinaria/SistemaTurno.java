package veterinaria;

import java.io.Serializable;
import java.util.ArrayList;

public class SistemaTurno implements Serializable 
{
    private final ArrayList<Turno> listaTurnoPerro; 
    private final ArrayList<Turno> listaTurnoGato;
    private final ArrayList<Turno> listaTurnoTortuga;
    private final ArrayList<Turno> listaTurnoCanario;

    public SistemaTurno() 
    {
        listaTurnoPerro = new ArrayList<>();
        listaTurnoGato = new ArrayList<>();  
        listaTurnoTortuga = new ArrayList<>();  
        listaTurnoCanario = new ArrayList<>();  
    }

    public ArrayList<Turno> getListaTurnoPerro()
    {
        return listaTurnoPerro;
    }
    
    public ArrayList<Turno> getListaTurnoGato()
    {
        return listaTurnoGato;
    }
    
    public ArrayList<Turno> getListaTurnoTortuga()
    {
        return listaTurnoTortuga;
    }
    
    public ArrayList<Turno> getListaTurnoCanario()
    {
        return listaTurnoCanario;
    }
    
    public boolean mostrarListaTurnoPerro()
    {
        boolean estado = false;
       
        if (!listaTurnoPerro.isEmpty())
         {
            estado = true;
            EntradaYSalida.mostrarMensaje("\n---Lista de turnos de perros---\n");

            for (int i = 0; i < listaTurnoPerro.size(); i++)
             {
                EntradaYSalida.mostrarMensaje("\n" + "[" + (i + 1) + "] "
                        + "||Nombre del duenio: " + listaTurnoPerro.get(i).getDuenio().getNombre()
                        + "||Telefono: " + listaTurnoPerro.get(i).getDuenio().getNumeroContacto()
                        + "||Tipo de animal: " + listaTurnoPerro.get(i).getAnimal().getTipo()
                        + "||Nombre del animal: " + listaTurnoPerro.get(i).getAnimal().getNombre()
                        + "||Hora: " + listaTurnoPerro.get(i).getHora());

             }
         } 
         else 
        {
            EntradaYSalida.mostrarMensaje("\n---Lista vacia\n");
            EntradaYSalida.leerCadena("\n\nPresione cualquier tecla para salir ");
        }
        return estado;
        
    }
    
    public boolean mostrarListaTurnoGato()
    {
        boolean estado = false;
       
        if (!listaTurnoGato.isEmpty())
         {
            estado = true;
            EntradaYSalida.mostrarMensaje("\n---Lista de turnos de gatos---\n");
        
            for (int i = 0; i < listaTurnoGato.size(); i++) 
            {
                EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    + "||Nombre del duenio: " + listaTurnoGato.get(i).getDuenio().getNombre()
                    + "||Telefono: " + listaTurnoGato.get(i).getDuenio().getNumeroContacto()
                    + "||Tipo de animal: " + listaTurnoGato.get(i).getAnimal().getTipo()
                    + "||Nombre del animal: " + listaTurnoGato.get(i).getAnimal().getNombre()
                    + "||Hora: " + listaTurnoGato.get(i).getHora());


            }
         }
        else
        {
          EntradaYSalida.mostrarMensaje("\n---Lista vacia\n");
          EntradaYSalida.leerCadena("\n\nPresione cualquier tecla para salir ");
        }
        
        return estado;
        
    }
    public boolean mostrarListaTurnoTortuga()
    {
        boolean estado = false;
       
        if (!listaTurnoTortuga.isEmpty())
         {
            estado = true;
            EntradaYSalida.mostrarMensaje("\n---Lista de turnos de tortugas---\n");

            for (int i = 0; i < listaTurnoTortuga.size(); i++) 
            {
                EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    + "||Nombre del duenio: " + listaTurnoTortuga.get(i).getDuenio().getNombre()
                    + "||Telefono: " + listaTurnoTortuga.get(i).getDuenio().getNumeroContacto()
                    + "||Tipo de animal: " + listaTurnoTortuga.get(i).getAnimal().getTipo()
                    + "||Nombre del animal: " + listaTurnoTortuga.get(i).getAnimal().getNombre()
                    + "||Hora: " + listaTurnoTortuga.get(i).getHora());

            }
         }
         else
          {
            EntradaYSalida.mostrarMensaje("\n---Lista vacia\n");
            EntradaYSalida.leerCadena("\n\nPresione cualquier tecla para salir ");
          }
        
        return estado;
        
    }
    
    public boolean mostrarListaTurnoCanario()
    {
       boolean estado = false;
       
        if (!listaTurnoCanario.isEmpty())
         {
            estado = true;
            EntradaYSalida.mostrarMensaje("\n---Lista de turnos de canarios---\n");

            for (int i = 0; i < listaTurnoCanario.size(); i++) 
            {
                EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    + "||Nombre del duenio: " + listaTurnoCanario.get(i).getDuenio().getNombre()
                    + "||Telefono: " + listaTurnoCanario.get(i).getDuenio().getNumeroContacto()
                    + "||Tipo de animal: " + listaTurnoCanario.get(i).getAnimal().getTipo()
                    + "||Nombre del animal: " + listaTurnoCanario.get(i).getAnimal().getNombre()
                    + "||Hora: " + listaTurnoCanario.get(i).getHora());

            }
         }
         else
          {
            EntradaYSalida.mostrarMensaje("\n---Lista vacia\n");
            EntradaYSalida.leerCadena("\n\nPresione cualquier tecla para salir ");
          }
        
        return estado;
        
    }
    
}
