
/**
 *
 * @author vana
 */
public abstract class GameEntity {
    private int x;
    private int y;
    
    public GameEntity(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public GameEntity() {
        this(0,0);
    }
    
    public void moveTo(int newx, int newy) {
        x = newx;
        y = newy;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public abstract String getDescription();
    
}
