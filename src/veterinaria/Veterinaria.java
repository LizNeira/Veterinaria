package veterinaria;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;

public class Veterinaria implements VeterinariaFacade, Serializable
{
    private  FactoriaTurno factoriaTurno;
    private  GuardarYLeerArchivo guardarYLeerArchivo = new GuardarYLeerArchivo();
    private static Veterinaria veterinaria = null;
    
    private Veterinaria()
    {
    }
    
    public static Veterinaria getInstancia()   
    {   
        if(null == veterinaria)
            veterinaria = new Veterinaria();   

        return veterinaria;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Administrador">
    @Override //Usado por la clase Controlador también. 
    public Empleado getBuscarEmpleado(String dato, Sistema sistema)
    {
      Empleado empleado;
      empleado = sistema.getSistemaEmpleado().buscarEmpleado(dato);
      guardarYLeerArchivo.guardarArchivo(sistema);
      
      return empleado;
    }

    @Override //Usado por la clase Controlador también. 
    public void setEmpleado(Empleado empleado, Sistema sistema) 
    {
       sistema.getSistemaEmpleado().getlistaEmpleado().add(empleado);
       guardarYLeerArchivo.guardarArchivo(sistema);
    }

    @Override
    public void setProductoRegular(Regular regular, Sistema sistema) 
    {
       sistema.getSistemaProducto().getListaRegular().add(regular);
       guardarYLeerArchivo.guardarArchivo(sistema);
    }
    
    @Override
    public void setProductoMedicamento(Medicamento medicamento, Sistema sistema)
    {
       sistema.getSistemaProducto().getListaMedicamento().add(medicamento);
       guardarYLeerArchivo.guardarArchivo(sistema);
    }

    @Override
    public boolean getMostrarListaMedicamento(Sistema sistema) 
    {
       return sistema.getSistemaProducto().mostrarListaMedicamento();
    }
    
    @Override
    public boolean getMostrarListaRegular(Sistema sistema) 
    {
      return sistema.getSistemaProducto().mostrarListaRegular(); 
    }
    
    @Override
    public void getMostrarListaRegularVendido(Sistema sistema)
    {
        sistema.getSistemaProducto().mostrarListaRegularVendido();
    }
    
     @Override
    public void getMostrarListaMedicamentoVendido(Sistema sistema)
    {
        sistema.getSistemaProducto().mostrarListaMedicamentoVendido();
    }

    @Override
    public ArrayList<Producto> getListaMedicamentoVendido(Sistema sistema) 
    {
      return sistema.getSistemaProducto().getListaMedicamentoVendido();
    }

    @Override
    public ArrayList<Producto> getListaRegularVendido(Sistema sistema)
    {
      return sistema.getSistemaProducto().getListaRegularVendido();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Recepcionista">
    @Override
    public void setTurno(String nombreDuenio, String numeroContacto, String tipoAnimal, 
                         String nombreAnimal, Sistema sistema,String hora) 
    {
        factoriaTurno = FactoriaTurno.getInstancia();
        
        try 
        {
           Animal animal = factoriaTurno.crearAnimal("Animal", nombreAnimal,tipoAnimal);
           Duenio duenio = factoriaTurno.crearDuenio("Duenio" ,nombreDuenio, numeroContacto);
           
           
            switch (tipoAnimal) 
            {
                case "Perro":
                    sistema.getSistemaTurno().getListaTurnoPerro().add(new Turno(animal, duenio,hora));
                    break;
                case "Gato":
                    sistema.getSistemaTurno().getListaTurnoGato().add(new Turno(animal, duenio,hora));
                    break;
                case "Tortuga":
                    sistema.getSistemaTurno().getListaTurnoTortuga().add(new Turno(animal, duenio,hora));
                    break;
                case "Canario":
                    sistema.getSistemaTurno().getListaTurnoCanario().add(new Turno(animal, duenio,hora));
                    break;
                
            }
           
        } 
        catch (ReflectiveOperationException ex) 
        {
           Logger.getLogger(Recepcionista.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @Override
    public int getCantidadTurno(Sistema sistema) 
    {
        return sistema.getSistemaProducto().getListaRegular().size();
    }
    
    @Override //Usado por la clase Veterinario también.
    public void venderProductoRegular(int indiceProducto, Sistema sistema)
    {  
      Producto productoSeleccionado;
      productoSeleccionado = sistema.getSistemaProducto().getListaRegular().get(indiceProducto -1);
      sistema.getSistemaProducto().getListaRegularVendido().add(productoSeleccionado);
      sistema.getSistemaProducto().getListaRegular().remove(indiceProducto - 1); 
      guardarYLeerArchivo.guardarArchivo(sistema);     
    }

    public boolean esHorarioDisponible(String hora, String especialidad, Sistema sistema) 
    {
        boolean estado = true;
        
        switch (especialidad) 
        {
            case "Perro":
                      if(sistema.getSistemaTurno().getListaTurnoPerro().isEmpty())
                          estado = true;
                      
                      else
                        for(Turno turno : sistema.getSistemaTurno().getListaTurnoPerro())
                              if(turno.getHora().equals(hora))
                                  estado = false;
                break;
            case "Gato":
                    if(sistema.getSistemaTurno().getListaTurnoGato().isEmpty())
                          estado = true;
                    
                    else
                      for(Turno turno : sistema.getSistemaTurno().getListaTurnoGato())
                          if(turno.getHora().equals(hora))
                             estado = false;
                break;
            case "Tortuga":
                     if(sistema.getSistemaTurno().getListaTurnoTortuga().isEmpty())
                          estado = true;
                     
                     else
                        for(Turno turno : sistema.getSistemaTurno().getListaTurnoTortuga())
                             if(turno.getHora().equals(hora))
                                 estado = false;
                break;
            case "Canario":
                    if(sistema.getSistemaTurno().getListaTurnoCanario().isEmpty())
                          estado = true;
                    
                    else
                      for(Turno turno : sistema.getSistemaTurno().getListaTurnoCanario())
                          if(turno.getHora().equals(hora))
                              estado = false;
                break;
            default:
                throw new AssertionError();
        }
        
        return estado;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Veterinario">
    @Override
    public void venderProductoMedicamento(int indiceProducto, Sistema sistema) 
    {
      Producto productoSeleccionado;
      productoSeleccionado = sistema.getSistemaProducto().getListaMedicamento().get(indiceProducto -1);      
      sistema.getSistemaProducto().getListaMedicamentoVendido().add(productoSeleccionado);
      sistema.getSistemaProducto().getListaMedicamento().remove(indiceProducto - 1);
      guardarYLeerArchivo.guardarArchivo(sistema);
    }
    
    @Override
    public void atenderAnimal(String especialidad, int indiceTurno, Sistema sistema)
    {
        switch (especialidad)
        {
            case "Perro":
                 sistema.getSistemaTurno().getListaTurnoPerro().remove(indiceTurno - 1);
                 guardarYLeerArchivo.guardarArchivo(sistema);
              break;
            case "Gato":
                 sistema.getSistemaTurno().getListaTurnoGato().remove(indiceTurno - 1);
                 guardarYLeerArchivo.guardarArchivo(sistema);
              break;
            case "Tortuga":
                 sistema.getSistemaTurno().getListaTurnoTortuga().remove(indiceTurno - 1);
                 guardarYLeerArchivo.guardarArchivo(sistema);
              break;
            case "Canario":
                sistema.getSistemaTurno().getListaTurnoCanario().remove(indiceTurno - 1);
                guardarYLeerArchivo.guardarArchivo(sistema);
              break;
            
        }
    }

    @Override
    public int getCantidadTurno(String especialidad, Sistema sistema)
    {
        int cantidadTurno = 0;
        
        switch (especialidad) 
        {
            case "Perro":
                    cantidadTurno = sistema.getSistemaTurno().getListaTurnoPerro().size();
                break;
            case "Gato":
                    cantidadTurno = sistema.getSistemaTurno().getListaTurnoGato().size();               
                break;
            case "Canario":
                    cantidadTurno = sistema.getSistemaTurno().getListaTurnoCanario().size();
                break;
            case "Tortuga":
                    cantidadTurno = sistema.getSistemaTurno().getListaTurnoTortuga().size();
                break;
            
        }
        
        return cantidadTurno;
    }
    
    @Override ////Usado por la clase Recepcionista también.
    public int getCantidadProductoRegular(Sistema sistema)
    {
       return  sistema.getSistemaProducto().getListaRegular().size();
    }
    
    @Override
    public int getCantidadProductoMedicamento(Sistema sistema)
    {
       return  sistema.getSistemaProducto().getListaMedicamento().size();
    }
    
    @Override
    public boolean getMostrarListaTurnoPerro(Sistema sistema) 
    {
       return sistema.getSistemaTurno().mostrarListaTurnoPerro(); 
    }
    
    @Override
    public boolean getMostrarListaTurnoGato(Sistema sistema) 
    {
       return sistema.getSistemaTurno().mostrarListaTurnoGato(); 
    }
    
    @Override
    public boolean getMostrarListaTurnoTortuga(Sistema sistema) 
    {
       return sistema.getSistemaTurno().mostrarListaTurnoTortuga(); 
    }
    
    @Override
    public boolean getMostrarListaTurnoCanario(Sistema sistema) 
    {
       return sistema.getSistemaTurno().mostrarListaTurnoCanario(); 
    }
    
    //</editor-fold>
    
    
}
