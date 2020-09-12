package veterinaria;

import java.util.ArrayList;

public class SistemaProducto
{
    private final ArrayList<Producto> listaMedicamento;
    private final ArrayList<Producto> listaRegular;
    
    public SistemaProducto()
    {
       listaMedicamento = new ArrayList<>();
       listaRegular = new ArrayList<>();
    }

    public ArrayList<Producto> getListaMedicamento() 
    {
        return listaMedicamento;
    }

    public ArrayList<Producto> getListaRegular()
    {
        return listaRegular;
    }

    public void mostrarListaMedicamento()
    {
        for (int i = 0; i < listaMedicamento.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    +"||Descripcion: "+listaMedicamento.get(i).getDescripcion()
                    +"||Precio: "+listaMedicamento.get(i).getDescripcion());
        }
        
    }
    
    public void mostrarListaRegular()
    {
        for (int i = 0; i < listaRegular.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    +"||Descripcion: "+listaRegular.get(i).getDescripcion()
                    +"||Precio: "+listaRegular.get(i).getDescripcion());
        }
        
    } 
}
