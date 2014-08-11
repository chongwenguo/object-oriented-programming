/**
 * Triangle class which extends Polygon
 * 
 * @author chongwen guo
 * @version 1.0
 *
 */
public class Triangle extends Polygon {
	
	static private boolean inDemand;
	private double base;
	private double height;
/**
 * constructor
 * create a new triangle with specific id, base and height 
 * 	
 * @param id the id of a triangle
 * @param base the base of a triangle
 * @param height the height of a triangle
 */
	public Triangle(String id, double base, double height) {
		super(id);
		this.base = base; 
		this.height = height;
	}
/**
 * default constructor
 * 
 * create a default triangle with None id, base 5, and height 4
 * 
 */
	public Triangle(){
		this("None", 2, 4);
	}

/**
 *  method to get the area of a triangle which has the value of 0.5 * base * height
 *  
 *  @return the area of a triangle
 * 
 */
	public double getArea() {

		return 0.5 * base * height;
	}


/**
 *  method to get the cost of a triangle
 *  if triangle is in demand, then double the value
 *  
 *  @return the total cost of the triangle
 * 
 */
	public double getTotal() {
		
		double total;
		if(inDemand){
			total = 2 * this.getArea();
		}else{
			total = this. getArea();
		}
		return total;
	}
	
/**
 *  general toString method
 *  
 *  @return a string which represents a triangle
 * 
 */
	public String toString(){
		
		return "Triangle with base " + base + " and height " + height + " with id " + id; 
	}

/**
 * static method to set triangle in demand
 * 
 */
	public static void setInDemand(){
		inDemand = true;
	}
	
}
