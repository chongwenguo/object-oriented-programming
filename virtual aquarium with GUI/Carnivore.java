import java.awt.Rectangle;
import java.util.Random;

/**
 * abstract Carnivore class which represents carnivore fishes
 * contains eatFish method for all carnivore, and override fish
 * move method which makes carnivore move faster than herbivore fish
 * @author chongwen guo
 * @version 1.0
 *
 */
public abstract class Carnivore extends Fish {
/**
 * Carnivore constructor
 * @param xPos - current mouse x position
 * @param yPos - current mouse y position
 * @param bounds - the rectangle confined the area
 */
    public Carnivore(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
    }
/**
 * abstract canEatFish method to be implemented by
 * subclass fish of carnivore
 * @return true - if can eat
 *         false - if cannot eat
 */
    public abstract boolean canEatFish(Fish other);
/**
 * eatFish method for all carnivore fish
 * set other fish's HP to 0
 * and add 30 HP to the carnivore fish
 * @param other - the fish to be ate
 */
    public void eatFish(Fish other) {
       other.hp = 0;
       hp += 30;
    }
/**
 * Carnivore fish move faster than regular fish,
 * each time they move will reduce 1 HP
 *
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
        pX += rand.nextInt(4) * xDirection;
        pY += rand.nextInt(4) * yDirection;

        hp--;
    }

}
