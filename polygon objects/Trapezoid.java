/**
 * trapezoid class which extends Polygon class
 * 
 * @author chongwen guo
 * @version 1.0
 *
 */
public class Trapezoid extends Polygon {

		
		static private boolean inDemand;
		private double upperBase;
		private double lowerBase;
		private double height;
	/**
	 * constructor
	 * create a new trapezoid with specific id, upper and lower base and height
	 * 	
	 * @param id the id of a triangle
	 * @param upperBase the upperBase of a trapezoid
	 * @param lowerBase the lowerBase of a trapezoid
	 * @param height the height of a trapezoid
	 */
		public Trapezoid(String id, double upperBase, double lowerBase, double height) {
			super(id);
			this.upperBase = upperBase; 
			this.lowerBase = lowerBase;
			this.height = height;
		}
	/**
	 * default constructor
	 * 
	 * create a new default trapezoid with None id, upper base 5, and lower base 4, and height 3
	 * 
	 */
		public Trapezoid(){
			this("None", 5, 4, 3);
		}

	/**
	 *  method to get the area of a trapezoid which has the value of (upperBase + lowerBase) * height / 2;
	 *  
	 *  @return the area of a trapezoid
	 * 
	 */
		public double getArea() {

			return (upperBase + lowerBase) * height / 2;
		}


	/**
	 *  method to get the total of a trapezoid
	 *  if trapezoid is in demand, then double the value
	 *  
	 *  @return the total of the trapezoid
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
	 *  @return a string which represents a trapezoid
	 * 
	 */
		public String toString(){
			
			return "Trapezoid with upper base " + upperBase + " and lower base " + lowerBase + " and height " + height + " with id " + id; 
		}

	/**
	 * static method to set triangle in demand
	 * 
	 */
		public static void setInDemand(){
			inDemand = true;
		}
		
	}

