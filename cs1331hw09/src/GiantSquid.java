import java.awt.Rectangle;
import java.util.ArrayList;
/**
 * class for GiantSquid which extends Carnivore
 * Giant Squids are carnivores that eat any fish,
 * even sharks. However, due to ¡±technical difficulties¡±,
 * they cannot reproduce.
 * @author chongwen guo
 * @version 1.0
 *
 */
public class GiantSquid extends Carnivore {
/**
 * constructor to create a new giant Squid
 * set the type to GiantSquid, and set up a
 * appropriate image for them, set its HP to 500
 *
 * @param xPos - current mouse x position
 * @param yPos - current mouse y position
 * @param bounds - the rectangle confined the area
 */
    public GiantSquid(int x, int y, Rectangle rec) {
        super(x, y, rec);
        setUpImage("giantSquid.png");
        type = "GiantSquid";
        hp = 500;
    }
/**
 * reproduceWithFish method for giant squid,
 * since giant squid can not reproduce, so always
 * return null
 * @param fish - other fish to reproduce with
 * @return children
 */
    public ArrayList<Fish> reproduceWithFish(Fish fish) {
        ArrayList<Fish> children = null;
        return children;
    }
/**
 * canEatFish method for giant squid
 * they can eat all other fishes whose HP are
 * lower than 150
 */
    public boolean canEatFish(Fish fish) {
        if (fish.type.equals("ParrotFish")
                || fish.type.equals("SurgeonFish")
                || fish.type.equals("Shark")
                || fish.type.equals("Dolphin")
                || fish.type.equals("SeaHorse")) {
            if (fish.hp < 150) {
                return true;
            }
        }
        return false;
    }
/**
 * canReproduceWithFish method for giant squid
 * which always return false
 * @param fish - other fish to reproduce with
 * @return false
 */
    public boolean canReproduceWithFish(Fish fish) {
        return false;
    }
}
