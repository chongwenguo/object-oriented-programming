import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * abstract Fish class, represents a fish,
 * contains some general method for all fish
 * and some abstract method to be implemented
 * by its subclass
 *
 * @author chongwen guo
 * @version 1.0
 *
 */
public abstract class Fish {

    protected int pX;
    protected int pY;
    protected Rectangle bounds;
    protected int hp;
    protected int age;
    protected BufferedImage image;
    protected String type;
    protected int imageWidth;
    protected int imageHeight;
    protected int xDirection;
    protected int yDirection;


/**
 * constructor, create a fish in current x,y position,
 * inside the bounds, and set HP to 100, set age to 0,
 * and assign a random moving direction
 * @param xPos
 * @param yPos
 * @param bounds
 */
    public Fish(int xPos, int yPos, Rectangle bounds) {
        this.pX = xPos;
        this.pY = yPos;
        this.bounds = bounds;
        hp = 100;
        age = 0;
        Random rand = new Random();
        boolean n1 = rand.nextBoolean();
        boolean n2 = rand.nextBoolean();
        //initialize the random moving direction
        if (n1) {
            xDirection = 1;
        } else {
            xDirection = -1;
        }
        if (n2) {
            yDirection = 1;
        } else {
            yDirection = -1;
        }
    }

/**
 * method to draw a fish in current mouse position
 * @param g
 */
    public void draw(Graphics g) {
        g.drawImage(image, this.pX, this.pY, null);
    }

/**
 * getOlder method to increase age by 1
 */
    public void getOlder() {
        age++;
    }
/**
 * method to get a age of a fish
 * @return age - the age of a fish
 */
    public int getAge() {
        return age;
    }
/**
 * method to set HP to 0 for the fish
 */
    public void setHPToZero() {
        hp = 0;
    }
/**
 * getHP method which return the HP of a fish
 * @return HP
 */
    public int getHP() {
        return hp;
    }
/**
 * setUpImage method to set up appropriate image for fishes
 * @param imageFilename - the file name of a image file
 */
    public void setUpImage(String imageFilename) {
        File file = new File(imageFilename);
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();

        // change the image orientation according to the direction
        if (xDirection == 1) {
            turnOver();
        }

   // if the fish is initially outside of boundary,
   // put it into boundary.
        if ((bounds.getWidth() - pX) < imageWidth) {
            pX = (int) (bounds.getWidth() - imageWidth);
        }
        if ((bounds.getHeight() - pY) < imageHeight) {
            pY = (int) (bounds.getHeight() - imageHeight);
        }
    }
/**
 * collidesWithFish method, all fishes share the this method
 *
 * @param other - other fish collided with
 * @return true if they are close enough
 *         false if they are not close enough
 */
    public boolean collidesWithFish(Fish other) {
         return Math.abs((this.pX - other.pX)) < 10
                 && Math.abs((this.pY - other.pY)) < 10;
    }
    /**
     * canReproduceWithFish method, shared by all fishes
     *
     * @param other - other fish to reproduce with
     * @return true - if they are the same type of fish
     *         false - if they are different type of fish
     */
        public boolean canReproduceWithFish(Fish other) {
            if (this.type.equals(other.type)) {
                return true;
            }
            return false;
        }
/**
 * method to turn over the image horizontally if needed
 */
    public void turnOver() {
        AffineTransform transform =
           new  AffineTransform(-1, 0, 0, 1, image.getWidth() - 1, 0);
        AffineTransformOp op =
        new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        image = op.filter(image, null);
    }
/**
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
        pX += rand.nextInt(2) * xDirection;
        pY += rand.nextInt(2) * yDirection;

        hp--;
    }

/**
 * abstract reproduceWithFIsh method implemented by subclass of fish
 * @param fish - the fish to reproduced with
 * @return ArrayList<fish> - a ArrayList contains reproduced children
 */
    public abstract ArrayList<Fish> reproduceWithFish(Fish fish);

 /**
  * abstract canEatFish method implemented by subclass of fish
  * @param fish - the fish to be ate
  * @return true - if can eat
  *         false - if cannot eat
  */
    public abstract boolean canEatFish(Fish fish);

}
