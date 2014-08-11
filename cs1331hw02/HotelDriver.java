/************************************
 * 
 * cs1331 hw02
 * 
 * @author chongwen guo
 * 
 */


import java.util.Scanner;

public class HotelDriver {

	public static void main(String[] args) {
		
		
		System.out.println("what is your hotel's name?");
		Scanner keyboard = new Scanner(System.in);
		String hotelName = keyboard.nextLine();
		System.out.println("what is your starting rate?");
		double rate = keyboard.nextDouble();
		System.out.println();
		Hotel hotel = new Hotel(hotelName, rate);
		System.out.println(hotel);
		
		boolean Continue = true;
		do{
		
		while(true){
			System.out.println("Enter the guest's name(or quit to continue):");
			
			Scanner input = new Scanner(System.in);
			String Gname = input.nextLine();
			
			if(Gname.equalsIgnoreCase("quit")){
				break;
			}
			System.out.println("And how many nights are you staying " + Gname + "?");
			int days = input.nextInt();
			
			Guest guest = new Guest(Gname, days);
			if(guest.getMoney() < hotel.getNightlyRate() *days){
				guest.SetStaying(false);
			}
			else{
				guest.SetStaying(true);
				hotel.addGuest(guest);
			}
			
			
		}
		
		System.out.println();
		System.out.println(hotel);
		
		System.out.println("Would you like to delay the flights(y/n)? I can alert our inside man.");
		
		Scanner anwser = new Scanner(System.in);
		String Sanwser = anwser.nextLine();
		if(Sanwser.equalsIgnoreCase("y")){
			System.out.println("As you wish.\n");
			hotel.delay();
		}
		hotel.check();
		System.out.println(hotel);
			
		
		System.out.println("Would you like to change the nightly rate(y/n)? More money is always preferable.");
		Scanner anwser1 = new Scanner(System.in);
		String Sanwser1 = anwser.nextLine();	
		if(Sanwser1.equalsIgnoreCase("y")){
			System.out.println("What shall the new rate be?");
			Scanner newRate = new Scanner(System.in);
			double rate1 = newRate.nextDouble();	
			hotel.setNightlyRate(rate1);
		}
		
		hotel.check();
		System.out.println();
		
		System.out.println("These are the current bookings:");
		System.out.println(hotel);
		
		System.out.println("Would you like to continue(y/n)?");
		Scanner anwser2 = new Scanner(System.in);
		String Sanwser2 = anwser2.nextLine();
		if(Sanwser2.equalsIgnoreCase("y")){
			Continue = true;
		}
		else if(Sanwser2.equalsIgnoreCase("n")){
			Continue = false;
		}
		
	}while(Continue);
	
	}
}
