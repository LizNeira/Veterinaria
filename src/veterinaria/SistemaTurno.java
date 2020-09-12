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

    public void mostrarListaTurno()
    {
        for (int i = 0; i < listaTurno.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    +"||Nombre: "+listaTurno.get(i).getNombre()
                    +"||Tipo: "+listaTurno.get(i).getTipo());
        }
        
    }
    
}
