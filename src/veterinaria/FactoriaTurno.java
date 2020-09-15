
package veterinaria;



public class FactoriaTurno 
{
    private static FactoriaTurno factoria = null;

    private FactoriaTurno()
    {}

    
    public static FactoriaTurno getInstancia()   
    {   
        if(null == factoria)
            factoria = new FactoriaTurno();   

        return factoria;
    }

    
    public Animal crearAnimal(String nombreClase,final String nombreAnimal, final String tipoAnimal) throws ReflectiveOperationException
	{
	    Animal animal = null;
	
	    try
	    {
	        animal = (Animal) Class.forName(factoria.getClass().getPackage().getName()
	                + "." + nombreClase).getDeclaredConstructor().newInstance();  
	    }
	    catch(ClassNotFoundException | InstantiationException | 
	            IllegalAccessException e)
	    {
	        EntradaYSalida.mostrarMensaje("Error: La clase " + nombreAnimal + " no existe ");
	        System.err.println(e);
	    }
	
	    if(null == animal)
               throw new IllegalAccessException(nombreAnimal);
        
            else
            {
               animal.setNombre(tipoAnimal);
               animal.setTipo(nombreAnimal);
            }
          
            return animal;
        
    }
    
    public Duenio crearDuenio(String nombreClase, final String nombreDuenio, final String numeroContacto) throws ReflectiveOperationException
	{
	    Duenio duenio = null;
	
	    try
	    {
	        duenio = (Duenio) Class.forName(factoria.getClass().getPackage().getName()
	                + "." + nombreClase).getDeclaredConstructor().newInstance();  
	    }
	    catch(ClassNotFoundException | InstantiationException | 
	            IllegalAccessException e)
	    {
	        EntradaYSalida.mostrarMensaje("Error: La clase " + nombreDuenio + " no existe ");
	        System.err.println(e);
	    }
	
	    if(null == duenio)
               throw new IllegalAccessException(nombreDuenio);
        
            else
            {
               duenio.setNombre(nombreDuenio);
               duenio.setNumeroContacto(numeroContacto);
            }
          
            return duenio;
        
    }
  
}