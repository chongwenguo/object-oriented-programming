import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
/**
 * class for ParrotFish which extends Herbivore
 * Parrot Fish are herbivore that reproduce more often
 * than other fish (80% percent) but have will only have 1 child
 * at a time. ParrotFish has 100 HP as regular fish
 *
 * @author chongwen guo
 * @version 1.0
 */
public class ParrotFish extends Herbivore {

    //static Integer number to track the number of all Parrot fish
    private static int number = 0;
/**
 * constructor to create a new parrot fish
 * set the type to ParrotFish, and set up a
 * appropriate image for them, and increase the
 * number of parrot fish by 1
 * @param pX - current mouse x position
 * @param pY - current mouse y position
 * @param bounds - the rectangle confined the area
 */
    public ParrotFish(int x, int y, Rectangle rec) {
        super(x, y, rec);
        setUpImage("parrotFish.png");
        type = "ParrotFish";
        number++;
    }
/**
 * reproduceWIthFish method for parrot fish
 * if the number of parrot fish less than 20,
 * then they have 80% percent change to reproduce
 * their children up to 5 children at a time
 *
 * @param fish - the other fish to reproduce with
 * @return children - the ArraList<Fish> which contains
 * the reproduced parrot Fish
 */
    public ArrayList<Fish> reproduceWithFish(Fish fish) {
        ArrayList<Fish> children = new ArrayList<Fish>();
        Random rand = new Random();
        if (number < 20) {
             if (rand.nextInt(100) < 80) {
                   children.add(new ParrotFish(pX + 10, pY + 10, bounds));
             }
        }
        return children;
    }
}
