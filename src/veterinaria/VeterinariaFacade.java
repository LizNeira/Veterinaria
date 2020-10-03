package veterinaria;

import java.util.ArrayList;

public interface VeterinariaFacade
{
    //<editor-fold defaultstate="collapsed" desc="Administrador">
    public Empleado getBuscarEmpleado(String dato, Sistema sistema);//Usado por la clase Controlador también.
    public void setEmpleado(Empleado empleado, Sistema sistema);//Usado por la clase Controlador también.
    public void setProductoRegular(Regular regular, Sistema sistema);
    public void setProductoMedicamento(Medicamento medicamento, Sistema sistema);
    public boolean getMostrarListaMedicamento(Sistema sistema);
    public boolean getMostrarListaRegular(Sistema sistema);
    public void getMostrarListaRegularVendido(Sistema sistema);
    public void getMostrarListaMedicamentoVendido(Sistema sistema);
    public ArrayList<Producto> getListaMedicamentoVendido(Sistema sistema);
    public ArrayList<Producto> getListaRegularVendido(Sistema sistema);
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Recepcionista">
    public void setTurno(String nombreDuenio, String numeroContacto,String tipoAnimal,String nombreAnimal, Sistema sistema,String hora);
    public int getCantidadTurno(Sistema sistema);
    public void venderProductoRegular(int indiceProducto, Sistema sistema);//Usado por la clase Veterinario también.
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Veterinario">
    public void venderProductoMedicamento(int indiceProducto, Sistema sistema);
    public int getCantidadProductoRegular(Sistema sistema);//Usado por la clase Recepcionista también.
    public int getCantidadProductoMedicamento(Sistema sistema);//Usado por la clase Recepcionista también.
    public void atenderAnimal(String especialidad, int indiceTurno, Sistema sistema);
    public int getCantidadTurno(String especialidad, Sistema sistema);
    public boolean getMostrarListaTurnoPerro(Sistema sistema);
    public boolean getMostrarListaTurnoGato(Sistema sistema);
    public boolean getMostrarListaTurnoTortuga(Sistema sistema);
    public boolean getMostrarListaTurnoCanario(Sistema sistema);

    //</editor-fold>
    
}
