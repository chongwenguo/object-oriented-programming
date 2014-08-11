/**
 * Diamond class which extends Polygon
 * @author chongwen guo
 * @version 1.0
 *
 */
public class Diamond extends Polygon {
	
	static private boolean inDemand;
	private double firstDiagonal;
	private double secondDiagonal;
/**
 * constructor
 * create a new diamond with specific id and diagonals
 * 	
 * @param id the id of a diamond
 * @param firstDiagonal the first Diagonal of a diamond
 * @param secondDiagonal the second Diagonal of a diamond
 */
	public Diamond(String id, double firstDiagonal, double secondDiagonal) {
		super(id);
		this.firstDiagonal = firstDiagonal; 
		this.secondDiagonal = secondDiagonal;
	}
/**
 * default constructor
 * 
 * create a new default diamond with None id, first diagonal 5, and second diagonal 4
 * 
 */
	public Diamond(){
		this("None", 5, 4);
	}

/**
 *  method to get the area of a diamond which has the value of first diagonal * second diagonal
 *  
 *  @return the area of a diamond
 * 
 */
	public double getArea() {

		return firstDiagonal * secondDiagonal;
	}


/**
 *  method to get the cost of a diamond
 *  if diamond is in demand, then double the value
 *  
 *  @return the total  of the diamond
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
 *  @return a string which represents a diamond
 * 
 */
	public String toString(){
		
		return "Diamond with first diagonal " + firstDiagonal + " and second diagonal " + secondDiagonal + " with id " + id; 
	}

/**
 * static method to set diamond in demand
 * 
 */
	public static void setInDemand(){
		inDemand = true;
	}
	
}
