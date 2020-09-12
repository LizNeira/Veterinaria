package veterinaria;

import java.io.Serializable;
import java.util.ArrayList;

public class SistemaTurno implements Serializable 
{

    private ArrayList<Turno> listaTurno;

    public SistemaTurno() 
    {
        listaTurno = new ArrayList<>();  
    }

    public ArrayList<Turno> getListaTurno()
    {
        return listaTurno;
    }
     public ArrayList<Turno> getSistemaTurno()
    {
        return listaTurno;
    }
    

    public void mostrarListaTurno()
    {
        for (int i = 0; i < listaTurno.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    +"||Nombre del duenio: " + listaTurno.get(i).getDuenio().getNombre()
                    +"||Telefono: " + listaTurno.get(i).getDuenio().getNumeroContacto()
                    +"||Nombre del animal: " + listaTurno.get(i).getAnimal().getNombre()
                    +"||Tipo de animal: " + listaTurno.get(i).getAnimal().getTipo());
        }
        
    }
    
}
