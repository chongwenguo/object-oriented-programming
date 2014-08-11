/**
 * Square class which extends Rectangle
 * 
 * 
 * @author chongwen guo
 * @version 1.0
 *
 */
public class Square extends Rectangle {
	
/**
 * square constructor 
 * 
 * to create a square with id and two the same length
 * 
 * 
 * @param id the id of a square
 * @param length of the square
 */
	public Square(String id, double length) {
		super(id, length, length);

	}
/**
 * default constructor
 * create a square with None ID and length of 5
 */
	public Square(){
		this("None", 5);
	}
/**
 * method to get the area of a square
 * 
 * @return the area of a square
 */
	public double getArea() {
		return  super.getArea();
	}

/**
 * method to get total area of a square
 * inherent from rectangle.getTotal()
 * 
 * @return the total of a square
 */
	public double getTotal() {

		return super.getTotal();
	}
	
/**
 * general toString method
 * 
 * @return the string that represent a square
 */
	public String toString(){
		
		return  "Square with side length " + length1 + " with id " + id; 
	}
	
}
