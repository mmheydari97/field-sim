import java.util.List;

public abstract class Actor {
    // The actor's age
    private int age;
    // Whether the animal is alive or not.
    private boolean alive;

    // The actor's position.
    private Location location;

    // The field occupied.
    private Field field;

    public Actor() {
        this.age = 0;
        this.alive = true;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    public void setLocation(Location newLocation) {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    public Field getField() {
        return field;
    }

    public abstract void act(List<Actor> newActors);
}
