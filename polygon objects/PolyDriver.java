import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Random;
/**
 * cs1331 hw04
 * 
 * PolyDriver class
 * 
 * @author chognwen guo
 * @version 1.0
 *
 */
public class PolyDriver {

	public static void main(String[] args) {
		
		PolyTruck ptruck = new PolyTruck();
		System.out.println("Time to load up the truck!");

		boolean notQuit = true;
		
		while(notQuit){
			System.out.println("What would you like to put in?");
			System.out.println();
			System.out.println("1. Default Square\n"
					+ "2. Custom Square\n"
					+ "3. Default Rectangle\n"
					+ "4. Custom Rectangle\n"
					+ "5. Default Triangle\n"
					+ "6. Custom Triangle\n"
					+ "7. Default Diamond\n"
					+ "8. Custom Diamond\n"
					+ "9. Default Trapezoid\n"
					+ "10. Custom Trapezoid\n"
					+ "11. Quit"
					);
			
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			
			if(n == 11){
				notQuit = false;
			}else{
				switch(n){
				
				case 1:
					Square s = new Square();
					if(!ptruck.isFull()){
						ptruck.addPoly(s);
					}else{
						System.out.println("The polytruck is full!");
					}
					break;
					
				case 2:
					System.out.println("Please input the side length for your square.");
					double length = scan.nextDouble();
					System.out.println("Please input the ID for your square.");
					Scanner scan1 = new Scanner(System.in);
					String id = scan1.nextLine();
					Square s1 = new Square(id, length);
					if(!ptruck.isFull()){
						ptruck.addPoly(s1);
					}else{
						System.out.println("The polytruck is full!");
					}
					break;
					
				case 3:
					Rectangle r = new Rectangle();
					ptruck.addPoly(r);
					break;
					
				case 4:
					System.out.println("Please input the first side length for your rectangle.");
					double length1 = scan.nextDouble();
					System.out.println("Please input the second side length for your rectangle.");
					double length2 = scan.nextDouble();
					System.out.println("Please input the ID for your rectangle.");
					Scanner scan2 = new Scanner(System.in);
					String id1 = scan2.nextLine();
					Rectangle r1 = new Rectangle(id1, length1, length2);
					if(!ptruck.isFull()){
						ptruck.addPoly(r1);
					}else{
						System.out.println("The polytruck is full!");
					}
					break;
					
				case 5:
					Triangle t = new Triangle();
					if(!ptruck.isFull()){
						ptruck.addPoly(t);
					}else{
						System.out.println("The polytruck is full!");
					}
					break;
					
				case 6:
					System.out.println("Please input the base for your triangle.");
					double base = scan.nextDouble();
					System.out.println("Please input the height for your triangle.");
					double height = scan.nextDouble();
					System.out.println("Please input the ID for your triangle.");
					Scanner scan3 = new Scanner(System.in);
					String id2 = scan3.nextLine();
					Triangle t1 = new Triangle(id2, base, height);
					if(!ptruck.isFull()){
						ptruck.addPoly(t1);
					}else{
						System.out.println("The polytruck is full!");
					}
					break;
					
				case 7:
					Diamond d = new Diamond();
					if(!ptruck.isFull()){
						ptruck.addPoly(d);
					}else{
						System.out.println("The polytruck is full!");
					}
					break;
					
				case 8:
					System.out.println("Please input first diagonal for your diamond.");
					double diagonal1 = scan.nextDouble();
					System.out.println("Please input the second diagonal for your diamond.");
					double diagonal2 = scan.nextDouble();
					System.out.println("Please input the ID for your triangle.");
					Scanner scan4 = new Scanner(System.in);
					String id3 = scan4.nextLine();
					Diamond d1 = new Diamond(id3, diagonal1, diagonal2);
					if(!ptruck.isFull()){
						ptruck.addPoly(d1);
					}else{
						System.out.println("The polytruck is full!");
					}
					break;
					
				case 9:
					Trapezoid trapezoid = new Trapezoid();
					if(!ptruck.isFull()){
						ptruck.addPoly(trapezoid);
					}else{
						System.out.println("The polytruck is full!");
					}
					break;
					
				case 10:
					System.out.println("Please input upper base for your trapezoid.");
					double upperBase = scan.nextDouble();
					System.out.println("Please input the lower base for your trapezoid.");
					double lowerBase = scan.nextDouble();
					System.out.println("Please input the height for your trapezoid.");
					double height1 = scan.nextDouble();
					System.out.println("Please input the ID for your triangle.");
					Scanner scan5 = new Scanner(System.in);
					String id4 = scan5.nextLine();
					Trapezoid trapezoid1 = new Trapezoid(id4, upperBase, lowerBase, height1);
					if(!ptruck.isFull()){
						ptruck.addPoly(trapezoid1);
					}else{
						System.out.println("The polytruck is full!");
					}
					break;
					
				default:
						System.out.println("Please enter a correct number.");
						break;
				}
			}
			System.out.println();
			System.out.println(ptruck);
		}
		
			Random rand = new Random();
			int x = rand.nextInt(5);
			switch(x) {
			
			case 0:
				Rectangle.setInDemand();
				System.out.println("Rectangles are in demand!");
				break;
				
			case 1:
				Triangle.setInDemand();
				System.out.println("Triangles are in demand!");
				break;
				
			case 2: 
				Square.setInDemand();
				System.out.println("Squares are in demand!");
				break;
				
			case 3:
				Diamond.setInDemand();
				System.out.println("Diamonds are in demand!");
				break;
				
			case 4:
				Trapezoid.setInDemand();
				System.out.println("Trapezoids are in demand!");
				break;
			}
			
			System.out.println("The truck arrived at the destination");
			System.out.println(ptruck);
			NumberFormat us = NumberFormat.getCurrencyInstance();
			System.out.println("The truck made " + us.format(ptruck.getTotal()) + " this trip");
		}
	}

