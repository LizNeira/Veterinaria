package veterinaria;

import java.io.Serializable;
import java.util.ArrayList;

public class SistemaProducto implements Serializable
{
    private ArrayList<Producto> listaMedicamento;
    private ArrayList<Producto> listaRegular;
    private ArrayList<Producto> listaRegularVendido;
    private ArrayList<Producto> listaMedicamentoVendido;

    public SistemaProducto()
    {
       listaMedicamento = new ArrayList<>();
       listaRegular = new ArrayList<>();
       listaMedicamentoVendido = new ArrayList<>();
       listaRegularVendido = new ArrayList<>();
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
    
    public boolean mostrarListaMedicamento()
    {  
     boolean estado = false;
     
     if(!listaMedicamento.isEmpty())
      { 
        estado = true;  
        EntradaYSalida.mostrarMensaje("\n---lista de Medicamentos---\n");

        for (int i = 0; i < listaMedicamento.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    +"||Descripcion: "+listaMedicamento.get(i).getDescripcion()
                    +"||Precio: $"+listaMedicamento.get(i).getprecio());
        }
      }
     else
      {
           EntradaYSalida.mostrarMensaje("\n---Lista vacia\n");  
      }
        return estado;
    }
    
    public boolean mostrarListaRegular()
    {
      boolean estado =false ; 
      
      if(!listaRegular.isEmpty())
      {
        estado = true;  
        EntradaYSalida.mostrarMensaje("\n---Lista de Regulares---\n");

        for (int i = 0; i < listaRegular.size(); i++) 
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i+1)+"] "
                    +"||Descripcion: "+listaRegular.get(i).getDescripcion()
                    +"||Precio: $"+listaRegular.get(i).getprecio());
        }
        
      }
     else
      {
           EntradaYSalida.mostrarMensaje("\n---Lista vacia\n");  
      }
        return estado;
   } 
    
    public void mostrarListaRegularVendido()
    {
        int i = 1;
        
     if(! listaRegularVendido.isEmpty())
      { 
        EntradaYSalida.mostrarMensaje("\n---Lista de Regulares Vendidos---\n");

        for  (Producto producto : getListaRegularVendido() )
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i)+"]"
                                          +"||Descripcion: " +producto.getDescripcion()
                                          +"||Precio: $"+producto.getprecio());
            i++;
        }
        EntradaYSalida.leerCadena("\n\nPresione cualquier tecla para salir ");
      }
     else
      {
        EntradaYSalida.mostrarMensaje("\n---Lista vacia\n");
      }
    }
    
    public void mostrarListaMedicamentoVendido()
    {
         int i = 1;
         
     if(! listaMedicamentoVendido.isEmpty())
      { 
          
        EntradaYSalida.mostrarMensaje("\n---Lista de Medicamentos Vendidos---\n");

        for  (Producto producto : getListaMedicamentoVendido() )
        {
            EntradaYSalida.mostrarMensaje("\n"+"["+(i)+"]"
                                          +"||Descripcion: " +producto.getDescripcion()
                                          +"||Precio: $"+producto.getprecio());
            i++;
        }
        EntradaYSalida.leerCadena("\n\nPresione cualquier tecla para salir ");
      }
     else
     {
        EntradaYSalida.mostrarMensaje("\n---Lista vacia\n");
     }
   }
}