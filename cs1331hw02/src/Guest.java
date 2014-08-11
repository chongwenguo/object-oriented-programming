/************************************
 * 
 * cs1331 hw02
 * 
 * @author chongwen guo
 * 
 */

import java.util.Random;


public class Guest {
	
	private String name;
	private int numberOfNights;
	private double money;
	private boolean staying;
	
	public Guest(String name, int numberOfNights){
		this.name = name;
		this.numberOfNights = numberOfNights;
		Random rand = new Random();
		this.money = (50 + rand.nextInt(200))*this.numberOfNights;
		
	}
	
	public int getNumberOfNights() {
		return numberOfNights;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getMoney(){
		return this.money;
	}
	
	public boolean isStaying() {
		return staying;
	}
	
	public void SetStaying(boolean stay) {
		this.staying = stay;
	}
	
	public void increaseNumberOfNights(){
		this.numberOfNights ++;
	}

	public String toString() {
		return "Guest[\"" + name + "\"]: " + this.numberOfNights + ", staying [" + this.staying + "] .";
	}
	
}
