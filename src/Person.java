
/**
 *
 * @author vana
 */
public abstract class Person extends GameEntity {
    
    private static final int DEFAULT_ENERGY = 50;
    private final String name;
    private int energy;
    
    public Person(int x, int y, String name, int energy) {
        super(x, y);
        this.name = name;
        this.energy = energy;
    }
    
    public Person(String name, int energy) {
        this(0, 0, name, energy);
    }
    
    public Person(String name) {
        this(0, 0, name, Person.DEFAULT_ENERGY);
    }
    
    public int getEnergy() {
        return this.energy;
    }
    
    protected void addEnergy(int delta) {
        this.energy += delta;
    }
    
    public void showInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Energy: " + this.energy);
    }

    @Override
    public String getDescription() {
        return name;
    }
    
}
