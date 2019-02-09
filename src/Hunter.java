import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Hunter extends Actor {
    private static final double RABBIT_HUNT_PROBABILITY = 0.4;
    private static final double FOX_HUNT_PROBABILITY = 0.7;
    private static final int MAX_RABBIT_HUNT = 2;
    private static final int MAX_FOX_HUNT = 3;

    private int rabbitsHunted;
    private int foxesHunted;

    public Hunter(Field field, Location location) {
        super.setField(field);
        super.setLocation(location);
        rabbitsHunted = 0;
        foxesHunted = 0;
    }

    public void resetLimits() {
        rabbitsHunted = 0;
        foxesHunted = 0;
    }

    public void act(List<Actor> actors) {
        resetLimits();
        Random rand = Randomizer.getRandom();
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = getField().getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive() && rabbitsHunted <= MAX_RABBIT_HUNT
                        && rand.nextDouble() <= RABBIT_HUNT_PROBABILITY) {
                    rabbit.setDead();
                    rabbitsHunted++;
                }
            } else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()  && foxesHunted <= MAX_FOX_HUNT
                        && rand.nextDouble() <= FOX_HUNT_PROBABILITY) {
                    fox.setDead();
                    foxesHunted++;
                }
            }

        }
    }

}