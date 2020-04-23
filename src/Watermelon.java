
/**
 *
 * @author vana
 */
public class Watermelon extends CarriableItem implements Eatable{
    
    public static final int ENERGY = 3;
    public static final int WEIGHT = 4;
    
    public Watermelon(int x, int y) {
        super(x, y, WEIGHT);
    }
    
    public Watermelon() {
        super(WEIGHT); 
    }
    @Override
    public int getEnergy(){
        return ENERGY;
    }

    
    @Override
    public String getDescription() {
        return "heavy watermelon";
    }
    
    @Override
    public String toString() {
        return "w";
    }
    
}
