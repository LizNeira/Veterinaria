package veterinaria;

import java.io.Serializable;
import java.util.ArrayList;

public class SistemaProducto implements Serializable
{
    private final ArrayList<Producto> listaMedicamento;
    private final ArrayList<Producto> listaRegular;
    private ArrayList<Producto> listaRegularVendido;
    private ArrayList<Producto> listaMedicamentoVendido;

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

    public ArrayList<Producto> getListaRegularVendido()
    {
        return listaRegularVendido;
    }

    public ArrayList<Producto> getListaMedicamentoVendido()
    {
        return listaMedicamentoVendido;
    }
    
   
    public void mostrarListaMedicamento()
    {
        for (int i = 0; i < listaMedicamento.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    +"||Descripcion: "+listaMedicamento.get(i).getDescripcion()
                    +"||Precio: "+listaMedicamento.get(i).getprecio());
        }
    }
    
    public void mostrarListaRegular()
    {
        for (int i = 0; i < listaRegular.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    +"||Descripcion: "+listaRegular.get(i).getDescripcion()
                    +"||Precio: "+listaRegular.get(i).getprecio());
        }
    } 
}
