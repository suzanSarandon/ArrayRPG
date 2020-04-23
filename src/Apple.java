
/**
 *
 * @author vana
 */
public class Apple extends CarriableItem implements Eatable{
    
    private static final int ENERGY = 5; 
    private static final int WEIGHT = 1;
    
    public Apple(int x, int y) {
        super(x, y, WEIGHT);
    }
    
    public Apple() {
        super(WEIGHT); 
    }
    @Override
    public int getEnergy(){
        return ENERGY;
    }
    
    @Override
    public String getDescription() {
        return "juicy apple";
    }
    
    @Override
    public String toString() {
        return "a";
    }
    
    
}
