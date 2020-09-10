package veterinaria;

import java.io.Serializable;


public class Sistema  implements Serializable
{
    private SistemaEmpleado sistemaEmpleado;

    public Sistema()
    {
        sistemaEmpleado = new SistemaEmpleado();
    }

    public SistemaEmpleado getSistemaEmpleado()
    {
        return sistemaEmpleado;
    }

    public void setSistemaEmpleado(SistemaEmpleado sistemaEmpleado) 
    {
        this.sistemaEmpleado = sistemaEmpleado;
    }

}
