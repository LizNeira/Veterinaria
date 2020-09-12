
package veterinaria;


public class Turno 
{
  private Animal animal;
  private Duenio duenio;

    public Turno(Animal animal, Duenio duenio)
    {
        this.animal = animal;
        this.duenio = duenio;
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

  
  
  
     
}
