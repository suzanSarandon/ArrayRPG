

/**
 *
 * @author vana
 */
public class Sword extends CarriableItem {
    
    public static final int WEIGHT = 15;
    
    public Sword(int x, int y) {
        super(x, y, WEIGHT);
    }
    
    public Sword() {
        super(WEIGHT); 
    }
    
    @Override
    public int getWeight() {
        return WEIGHT;
    }
    
    @Override
    public String getDescription() {
        return "sharp sword";
    }
    
    @Override
    public String toString() {
        return "s";
    }
    
}
