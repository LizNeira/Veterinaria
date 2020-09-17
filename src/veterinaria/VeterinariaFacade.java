package veterinaria;

import java.util.ArrayList;

public interface VeterinariaFacade
{
    //<editor-fold defaultstate="collapsed" desc="Administrador">
    public Empleado getBuscarEmpleado(String dato, Sistema sistema);//Usado por la clase Controlador también.
    public void setEmpleado(Empleado empleado, Sistema sistema);//Usado por la clase Controlador también.
    public void setProductoRegular(Regular regular, Sistema sistema);
    public void setProductoMedicamento(Medicamento medicamento, Sistema sistema);
    public void getMostrarListaMedicamento(Sistema sistema);
    public void getMostrarListaRegular(Sistema sistema);
    public void getMostrarListaRegularVendido(Sistema sistema);
    public void getMostrarListaMedicamentoVendido(Sistema sistema);
    public ArrayList<Producto> getListaMedicamentoVendido(Sistema sistema);
    public ArrayList<Producto> getListaRegularVendido(Sistema sistema);
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Recepcionista">
    public void setTurno(String nombreAnimal, String tipoAnimal, String nombreDuenio, String numeroContacto, Sistema sistema);
    public int getCantidadTurno(Sistema sistema);
    public void venderProductoRegular(int indiceProducto, Sistema sistema);//Usado por la clase Veterinario también.
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Veterinario">
    public void venderProductoMedicamento(int indiceProducto, Sistema sistema);
    public int getCantidadProductoRegular(Sistema sistema);//Usado por la clase Recepcionista también.
    public int getCantidadProductoMedicamento(Sistema sistema);//Usado por la clase Recepcionista también.
    public void atenderAnimal(String especialidad, int indiceTurno, Sistema sistema);
    public int getCantidadTurno(String especialidad, Sistema sistema);
    public void getMostrarListaTurnoPerro(Sistema sistema);
    public void getMostrarListaTurnoGato(Sistema sistema);
    public void getMostrarListaTurnoTortuga(Sistema sistema);
    public void getMostrarListaTurnoCanario(Sistema sistema);

    //</editor-fold>
    
}
