/************************************
 * 
 * cs1331 hw02
 * 
 * @author chongwen guo
 * 
 */

import java.text.NumberFormat;


public class Hotel {
	
	private String name;
	private double nightlyRate;
	private Guest[] Guests;
	private int numberOfGuests;
	
	public Hotel(String newName, double startingNightlyRate){
		this.name = newName;
		this.nightlyRate = startingNightlyRate;
		numberOfGuests = 0;
		Guests = new Guest[10];
	}

	public double getNightlyRate() {
		return nightlyRate;
	}

	public void setNightlyRate(double newNightlyRate) {
		this.nightlyRate = newNightlyRate;
	}
	
	public  boolean addGuest(Guest who){
		boolean Add = false;
		if(numberOfGuests < 10){
			Guests[numberOfGuests] = who;
			Add = true;
			numberOfGuests++;
		}
		else{
			for(int i = 0; i < 10; i ++){
				if(!Guests[i].isStaying()){
					Guests[i] = who;
					Add = true;
					break;
				}
			}
		}
		return Add;
	}
	
	public double totalIncome(){
		double totalIncome = 0;
		
		for(int i = 0; i < numberOfGuests; i ++){
			if(Guests[i].isStaying()){
			totalIncome += Guests[i].getNumberOfNights()*this.nightlyRate;
			}
		}
		
		return totalIncome;
	}
	
	
	public void delay(){
		for(int i = 0; i < numberOfGuests; i ++){
			Guests[i].increaseNumberOfNights();
		}
	}
	
	public void check(){
		for(int i = 0; i < numberOfGuests; i ++){
			if(Guests[i].getMoney() < this.nightlyRate * Guests[i].getNumberOfNights()){
				System.out.println(Guests[i].getName() + " doesn't have the money to stay here! they're leaving");
				Guests[i].SetStaying(false);
			}
			else{
				Guests[i].SetStaying(true);
			}
		}
	}
	
	
	public String toString(){
		NumberFormat us = NumberFormat.getCurrencyInstance();
		String s = "";
		s += "Hotel [" + this.name +"]. Current rate of " + us.format(this.nightlyRate)
				+ " per night. " + this.numberOfGuests + " customers: \n";
		s += this.name + " will make " + us.format(this.totalIncome()) +  " off the customers currently booked.\n";
		
		for(int i = 0; i < this.numberOfGuests; i ++)
		{
			s += "Customer " + Guests[i].toString() + "\n";
		}
		
		return s;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
