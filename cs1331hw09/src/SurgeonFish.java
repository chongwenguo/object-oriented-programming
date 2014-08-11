import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
/**
 * class for SurgeonFish which extends Herbivore
 * They rarely reproduce (15% percent) but can have
 * up to 5 children at a time.
 * SurgeonFish has 100 HP as regular fish
 * @author chongwen guo
 * @version 1.0
 */
public class SurgeonFish extends Herbivore {
    //static Integer number to track the number of all surgeonfish
    private static int number = 0;
/**
 * constructor to create a new surgeon fish
 * set the type to SurgeonFish, and set up a
 * appropriate image for them, and increase the
 * number of surgeon fish by 1
 * @param pX - current mouse x position
 * @param pY - current mouse y position
 * @param bounds - the rectangle confined the area
 */
    public SurgeonFish(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setUpImage("surgeonFish.png");
        type = "SurgeonFish";
        number++;
    }
/**
 * reproduceWIthFish method for surgeon fish
 * if the number of surgeon fish less than 30,
 * then they have 15% percent change to reproduce
 * their children up to 5 children at a time
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
                for (int i = 0; i < 1 + rand.nextInt(5); i++) {
                    children.
                    add(new SurgeonFish(pX - 30 * i, pY - 30 * i, bounds));
                }
            }
        }
        return children;
    }
}
