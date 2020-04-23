
import java.util.*;


/**
 *
 * @author vana
 */
public class Player extends Person {
    
    private static final int INIT_ENERGY = 100;
    private static final int INIT_MAX_BACKPACK_WEIGHT = 20;
    
    private ArrayList<CarriableItem> backpack;
    private int currentBackpackWeight;
    private int maxBackpackWeight;
    
    
    public Player(String name) {
        super(name, Player.INIT_ENERGY);
        this.backpack = new ArrayList<>();
        this.currentBackpackWeight = 0;
        this.maxBackpackWeight = Player.INIT_MAX_BACKPACK_WEIGHT;
    }
    
    @Override
    public String toString() {
        return "P";
    }
    
    public void showFood() {
        for (CarriableItem item:backpack){
            if (item instanceof Eatable){
                System.out.println(((Eatable) item).getEnergy());
                System.out.println(((CarriableItem) item).getDescription());
            }
        }
        System.out.println("There must be some food here!");
    }
    
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Backpack: ");
        Collections.sort(backpack);
        for (CarriableItem item: backpack) {
            System.out.println(item.getDescription() + " (wt. " + item.getWeight() + ")");
        }
    }
    
    public void pickup(CarriableItem item) throws OverBurdendeException {
        if ((currentBackpackWeight+item.getWeight())>maxBackpackWeight){
                throw new OverBurdendeException();
            }
        /*}
        catch (OverBurdendeException ex){
            System.out.println("This item weighs more than you can carry!");
            return;
        }*/
        item.moveTo(-1, -1); // this means the item is not anywhere on the grid.
        backpack.add(item);
        currentBackpackWeight += item.getWeight();
    }
    
    public void eat(Eatable eatableItem){
        this.addEnergy(eatableItem.getEnergy());
    }
    
     
    
    
    
}
