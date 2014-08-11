import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
/**
 * class for shark which extends carnivore
 * They eat any fish, but they are unable to kill the mythical Giant Squids.
 * They do not reproduce very often (20% percent) and only have 1-2 children
 * in the litter. shark has 200 HP.
 *
 * @author chongwen guo
 * @version 1.0
 */
public class Shark extends Carnivore {

      //static Integer number to track the number of all sharks
    private static int number = 0;
/**
 * constructor to create a new shark
 * set the type to Shark, set the HP to 200, and set
 * up an appropriate image (fliped image) for them, and
 * increase the number of shark by 1
 * @param pX - current mouse x position
 * @param pY - current mouse y position
 * @param bounds - the rectangle confined the area
 */
    public Shark(int x, int y, Rectangle rec) {
        super(x, y, rec);
        setUpImage("shark.png");
        turnOver();
        type = "Shark";
        hp = 200;
        number++;
    }
/**
 * canEatFish method for shark
 * shark can eat those parrot and surgeon fishes whose HP
 * are lower than 80
 * @param fish - other fish to be ate
 * @return true - if shark can eat the fish
 *         false - if shark can not eat the fish
 */
    public boolean canEatFish(Fish fish) {
        if (fish.type.equals("ParrotFish")
                || fish.type.equals("SurgeonFish")
                || fish.type.equals("Dolphin")) {
            if (fish.hp < 80) {
                return true;
            }
        }
        return false;
    }
/**
 * reproduceWIthFish method for shark
 * if the number of shark less than 15,
 * then they have 20 percent change to reproduce
 * 1-2 children at a time
 *
 * @param fish - the other fish to reproduce with
 * @return children - the ArraList<Fish> which contains
 * the reproduced sharks
 */
    public ArrayList<Fish> reproduceWithFish(Fish fish) {
        ArrayList<Fish> children = new ArrayList<Fish>();
        Random rand = new Random();
        if (number < 15) {
            if (rand.nextInt(100) < 20) {
                for (int i = 0; i < 1 + rand.nextInt(2); i++) {
                    children.add(new Shark(pX + 10 * i, pY + 10 * i, bounds));
                }
            }
        }
        return children;
    }

}
