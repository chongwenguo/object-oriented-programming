/**
 * Rectangle class, which extends polygon
 * @author chongwen guo
 * @version 1.0
 * 
 */
public class Rectangle extends Polygon {
	
	static protected boolean inDemand;
	protected double length1;
	private double length2;
	
/**
 * constructor 	
 * create new rectangle with specific id and two lengths
 * @param id the id of a rectangle
 * @param length1 first length of a rectangle
 * @param length2 second length of a rectangle
 */
	public Rectangle(String id, double length1, double length2) {
		super(id);
		this.length1 = length1;
		this.length2 = length2;
	}
/**
 * default constructor 
 * create a default rectangle with id None and first length 5, second length 6
 */
	public Rectangle(){
		this("None", 5, 6);
	}
	
/**
 * method to get the area of a rectangle
 * 
 * @return the area of a rectangle
 * 
 */
	public double getArea() {
		
		return length1 * length2;
	}

/**
 * method to get the total of a rectangle
 * if the rectangle is in demand, then double the value
 * 
 * @return total of the rectangle
 */
	public double getTotal() {
		
		double total;
		if(inDemand){
			total = 2 * getArea();
		}else{
			total = getArea();
		}
		return total;
	}
	
/**
 * general toString method
 * 
 * @return string which represents a rectangle
 */
	public String toString(){
		
		return "Rectangle  with side lengths " + length1  + " and  " + length2 + " with id " + id; 

	}
	
/**
 * static method that set rectangle in demand
 */
	
	public static void setInDemand(){
		inDemand = true;
	}
	
	

}
