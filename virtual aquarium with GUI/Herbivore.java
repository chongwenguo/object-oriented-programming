import java.awt.Rectangle;
/**
 * abstract Herbivore class which represents Herbivore fishes
 * contains eatSeaweed method for all Herbivore, and canEatFish
 * method which always return false
 * @author chongwen guo
 * @version 1.0
 *
 */

public abstract class Herbivore extends Fish {
/**
 * constructor for herbivore fish
 * @param xPos - current mouse x position
 * @param yPos - current mouse y position
 * @param bounds - the rectangle confined the area
 */
    public Herbivore(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
    }
/**
 * eat seaweed function, which set the HP to 100
 */
    public void eatSeaweed() {
        hp = 100;
    }
/**
 * move method for herbivore fish,
 * when their HP is lower than 20,
 * they eat seaweed to recover HP to 100
 */
    public void move() {
        super.move();
        if (hp < 20) {
            eatSeaweed();
        }
    }
/**
 * canEatFish method for all herbivore fishes,
 * which always return false since hebivore fishes can
 * not eat other fishes.
 * @return false
 */
    public boolean canEatFish(Fish fish) {
        return false;
    }
}
