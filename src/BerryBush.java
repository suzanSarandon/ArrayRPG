import java.util.Random;
/**
 *
 * @author vana
 */
public class BerryBush extends StationaryItem implements Eatable{
    private static final int ENERGY = 1;
    private boolean isPoisonous;
    
    public BerryBush(int x, int y) {
        super(x, y);
        this.isPoisonous = (new Random()).nextBoolean();
    }
    
    
    
    @Override
    public int getEnergy(){
        if (this.isPoisonous){
            return -1;
        }
        return ENERGY;
    }
    
    @Override
    public String getDescription() {
        return "berry bush";
    }
    
    @Override
    public String toString() {
        return "b";
    }
}
