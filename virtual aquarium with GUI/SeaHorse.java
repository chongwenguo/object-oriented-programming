import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
/**
 * class for SeaHorse which extends Herbivore
 * They have 30% percent to reproduce and can have
 * up to 3 children at a time.
 * SeaHorse has 100 HP as regular fish
 *
 * Special ability: no other fish except giant squid can eat a seaHorse
 * since it is bigger than others!
 *
 * @author chongwen guo
 * @version 1.0
 */
public class SeaHorse extends Herbivore {
    //static Integer number to track the number of all sea horse
    private static int number = 0;
/**
 * constructor to create a new seaHorse
 * set the type to SeaHorse, and set up a
 * appropriate image for them, and increase the
 * number of seaHorse by 1
 * @param pX - current mouse x position
 * @param pY - current mouse y position
 * @param bounds - the rectangle confined the area
 */
    public SeaHorse(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setUpImage("seaHorse.png");
        type = "SeaHorse";
        number++;
    }
/**
 * reproduceWIthFish method for seaHorse fish
 * if the number of sea horse less than 30,
 * then they have 15% percent change to reproduce
 * their children up to 3 children at a time
 *
 * @param fish - the other fish to reproduce with
 * @return children - the ArraList<Fish> which contains
 * the reproduced surgeon fish
 */
    public ArrayList<Fish> reproduceWithFish(Fish fish) {
        ArrayList<Fish> children = new ArrayList<Fish>();
        Random rand = new Random();
        if (number < 30) {
            if (rand.nextInt(100) < 15) {
                for (int i = 0; i < 1 + rand.nextInt(3); i++) {
                    children.
                    add(new SeaHorse(pX - 30 * i, pY - 30 * i, bounds));
                }
            }
        }
        return children;
    }
}
