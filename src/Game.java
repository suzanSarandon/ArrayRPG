
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vana
 */
public class Game {
    
    private static final int SIZE = 5;
    private GameEntity [][] grid;
    private Player player;
    
    
    public Game() {   
        int x, y;
        grid = new GameEntity[SIZE][SIZE];
        Random rand = new Random();
        for (int i=0; i<25; i++) {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
            if (x==0 && y==0) continue;
            int chance = rand.nextInt(25);
            if (chance < 5) {
                grid[x][y] = new Sword(x, y);
            }
            else if (chance < 8) {
                grid[x][y]= new Watermelon(x, y);
            }
            else if (chance < 15) {
                grid[x][y] = new BerryBush(x, y);
            }
            else {
                grid[x][y]= new Apple(x, y);
            }
        }
        player = new Player("Player");
        System.out.println("Type help for a list of available commands.");
    }
    
    public void play() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(this);
            System.out.print(">  ");
            String command = sc.next();
            if (command.equalsIgnoreCase("go")) {
                String direction = sc.next();
                move(direction);
            }
            else if (command.equalsIgnoreCase("leave")) {
                System.out.println("You give up and go home.");
                break;
            }
            else if (command.equalsIgnoreCase("inv")) {
                player.showInfo();
            }
            else if (command.equalsIgnoreCase("food")) {
                player.showFood();
            }
            else if (command.equalsIgnoreCase("help")) {
                printHelp();
            }
            else {
                System.out.println("Say what? ");
            }
        }
    }
    
    private void printHelp() {
        System.out.println("COMMANDS:");
        System.out.println("go D, where D is s, n, e, w to move south, north, east or west respectively.");
        System.out.println("inv, to see your inventory and general info");
        System.out.println("food, to see what foodstuffs you carry");   
        System.out.println("leave, to exit");
    }
    
    private void checkGround(int x, int y) {
        Scanner sc = new Scanner(System.in);
        if (grid[x][y] instanceof Eatable) {
            System.out.println("There is a " + grid[x][y].getDescription() + " near you. Do you want to eat it? (y/n) ");
            if (sc.next().equalsIgnoreCase("y")) {
                player.eat((Eatable)grid[x][y]);
                System.out.println("You put the " + grid[x][y].getDescription() + " in your belly.");
                grid[x][y] = null;
            }
        }    
        if (grid[x][y] instanceof CarriableItem) {
            System.out.println("There is a " + grid[x][y].getDescription() + " near you. Do you want to take it with you? (y/n) ");
            if (sc.next().equalsIgnoreCase("y")) {
                try{
                    player.pickup((CarriableItem)grid[x][y]);
                    
                }
                catch(OverBurdendeException ex){
                    System.out.println("This item weighs more than you can carry!");
                    return;
                }
                System.out.println("You put the " + grid[x][y].getDescription() + " in your backpack.");
                    grid[x][y] = null;
                    
                }
   
            }
    }
    
    
    public void move(String direction) {
        int x = player.getX();
        int y = player.getY();
        if (direction.toLowerCase().startsWith("n") && x > 0) {
            checkGround(x-1, y);
            player.moveTo(x-1, y);
            return;
        }
        else if (direction.toLowerCase().startsWith("s") && x < SIZE-1) {
            checkGround(x+1, y);
            player.moveTo(x+1, y);
            return;
        }
        else if (direction.toLowerCase().startsWith("w") && y > 0) {
            checkGround(x, y-1);
            player.moveTo(x, y-1);
            return;
        }
        else if (direction.toLowerCase().startsWith("e") && y < SIZE-1) {
            checkGround(x, y+1);
            player.moveTo(x, y+1);
            return;
        }
        System.out.println("You hit your nose on a wall.");
    }
    
    @Override
    public String toString() {
        String str= "\n";
        for (int c=0; c<4*SIZE+1; c++) {
            str += "-";
        } 
        for (int r=0; r<5;r++) {
            str += "\n|";
            for (int c=0; c<SIZE; c++) {
                if (player.getX()==r && player.getY()==c) {
                    str += player;
                }
                else {
                    str += " ";
                }
                if (grid[r][c] == null) {
                    str += "  |";
                }
                else {
                    str += grid[r][c] + " |";
                }
            }
            str += "\n";
            for (int c=0; c<4*SIZE+1; c++) {
                str += "-";
            }
        }
        str += "\n\n";
        return str;
    }
    
    
}
