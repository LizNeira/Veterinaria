
package veterinaria;


public class Turno 
{
  private Animal animal;
  private Duenio duenio;
  private String hora;
  
    public Turno(Animal animal, Duenio duenio,String hora)
    {
        this.animal = animal;
        this.duenio = duenio;
        this.hora = hora;
    }
  
    
    public Animal getAnimal()
    {
        return animal;
    }

    public void setAnimal(Animal animal)
    {
        this.animal = animal;
    }

    public Duenio getDuenio()
    {
        return duenio;
    }

    public void setDuenio(Duenio duenio)
    {
        this.duenio = duenio;
    }

    public String getHora()
    {
        return hora;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }
    
    

  
  
  
     
}
