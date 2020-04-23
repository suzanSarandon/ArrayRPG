
/**
 *
 * @author vana
 */
public abstract class CarriableItem extends GameEntity implements java.lang.Comparable<CarriableItem> {
    
    private int weight;
    
    public CarriableItem(int x, int y, int weight) {
        super(x, y);
        this.weight = weight;
    }
    public CarriableItem(int x, int y) {
        this(x, y, 0);
    }
    
    public CarriableItem(int weight) {
        this(-1, -1, weight);  // -1 means it is being carried
    }
    
    public CarriableItem() {
        this(-1, -1, 0);  // -1 means it is being carried
    }
    public int getWeight() {
        return this.weight;
    }
    
  
    
    
    @Override
    public int compareTo(CarriableItem c){
        
        if(this.weight > c.weight) return 1; 
        if(this.weight < c.weight) return -1;
        else{
            return this.getDescription().compareTo(c.getDescription());
                
            
        }
        
    }

    
}
