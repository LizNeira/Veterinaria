package veterinaria;

import java.io.Serializable;


public class Sistema  implements Serializable
{
    private SistemaEmpleado sistemaEmpleado;
    private final SistemaProducto sistemaProducto;
    private final SistemaTurno sistemaTurno;
    
    
    public Sistema()
    {
        sistemaEmpleado = new SistemaEmpleado();
        sistemaProducto = new SistemaProducto();
        sistemaTurno = new SistemaTurno();
    }

    public SistemaEmpleado getSistemaEmpleado()
    {
        return sistemaEmpleado;
    }

    //TODO: No occurrences.
    public void setSistemaEmpleado(SistemaEmpleado sistemaEmpleado) 
    {
        this.sistemaEmpleado = sistemaEmpleado;
    }
    
    public SistemaProducto getSistemaProducto()
    {
        return sistemaProducto;
    }
    
    public SistemaTurno getSistemaTurno()
    {
        return sistemaTurno;
    }

}
