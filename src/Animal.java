import java.util.List;
import java.util.Random;

public abstract class Animal extends Actor {

    /**
     * Check whether or not this animal is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newAnimals A list to add newly born animals to.
     */
    abstract protected void giveBirth(List<Actor> newAnimals);

    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    protected int breed()
    {
        int births = 0;
        if(canBreed() && getRand().nextDouble() <= getBreedingProbability()) {
            births = getRand().nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }

    //abstract public void act(List<Animal> newAnimals);
    abstract protected int getBreedingAge();
    abstract protected int getMaxAge();
    abstract protected int getMaxLitterSize();
    abstract protected double getBreedingProbability();
    abstract protected Random getRand();

    public boolean canBreed() {
        return getAge() >= getBreedingAge();
    }

    /**
     * Increase the age. This could result in the animal's death.
     */
    protected void incrementAge()
    {
        setAge(getAge() + 1);
        if(getAge() > getMaxAge()) {
            setDead();
        }
    }

}
