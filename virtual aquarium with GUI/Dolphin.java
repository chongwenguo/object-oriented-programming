import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
/**
 * class for Dolphin which extends carnivore
 * They eat ParrotFish and SurgeonFish
 * They do not reproduce very often (20% percent) and  have up to
 * 3 children at a time
 * dolphin has 150 HP.
 *
 * Special ability: moving faster than other fishes
 *
 * @author chongwen guo
 * @version 1.0
 */
public class Dolphin extends Carnivore {

      //static Integer number to track the number of all dolphin
    private static int number = 0;
/**
 * constructor to create a new dolphin
 * set the type to Shark, set the HP to 200, and set
 * up an appropriate image  for them, and
 * increase the number of dolphin by 1
 * @param pX - current mouse x position
 * @param pY - current mouse y position
 * @param bounds - the rectangle confined the area
 */
    public Dolphin(int x, int y, Rectangle rec) {
        super(x, y, rec);
        setUpImage("dolphin.png");
        type = "Dolphin";
        hp = 150;
        number++;
    }
/**
 * @override
 * special ability: move faster than other fishes
 * move method which represents a random movement of fishes
 * each movement will cause HP reduced by 1
 */
    public void move() {
         if (pX > (bounds.width - imageWidth)) {
                if (xDirection != -1) {
                xDirection = -1;
                turnOver();
                }
            }

            if (pX < 0) {
                if (xDirection != 1) {
                xDirection = 1;
                turnOver();
                }
            }
            if (pY > (bounds.height - imageHeight)) {
                yDirection = -1;
            }
            if (pY < 0) {
                yDirection = 1;
            }
            Random rand = new Random();
            pX += rand.nextInt(7) * xDirection;
            pY += rand.nextInt(7) * yDirection;

            hp--;
        }
/**
 * canEatFish method for dolphin
 * dolphin can eat those parrot and surgeon fishes whose HP
 * are lower than 80
 * @param fish - other fish to be ate
 * @return true - if shark can eat the fish
 *         false - if shark can not eat the fish
 */
    public boolean canEatFish(Fish fish) {
        if (fish.type.equalsIgnoreCase("ParrotFish")
                || fish.type.equalsIgnoreCase("SurgeonFish")) {
            if (fish.hp < 80) {
                return true;
            }
        }
        return false;
    }
/**
 * reproduceWIthFish method for dolphin
 * if the number of dolphin less than 25,
 * then they have 20 percent change to reproduce
 * up to 3 children at a time
 *
 * @param fish - the other fish to reproduce with
 * @return children - the ArraList<Fish> which contains
 * the reproduced sharks
 */
    public ArrayList<Fish> reproduceWithFish(Fish fish) {
        ArrayList<Fish> children = new ArrayList<Fish>();
        Random rand = new Random();
        if (number < 25) {
            if (rand.nextInt(100) < 20) {
                for (int i = 0; i < 1 + rand.nextInt(3); i++) {
                    children.add(new Dolphin(pX + 10 * i, pY + 10 * i, bounds));
                }
            }
        }
        return children;
    }

}
