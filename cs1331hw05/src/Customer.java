/**
 * customer class which represent a customer
 * @author chongwen guo
 * @version 1.0
 */


public class Customer {

    private String name;
    private double discount;
/**
 * constructor for customer
 * @param aName the name of a customer
 */
    public Customer(String aName) {
        name = aName;
        // By default, customers get no discount
        discount = 0.0;
    }
/**
 * this method gets the name of this customer
 * @return name of this customer
 */
    public String getName() {
        return name;
    }
/**
 * this method gets the discount rate for this customer
 * @return discount of this customer has
 */
    public double getDiscount() {
        return discount;
    }

 /**
  * this method sets the discount rate for the customer
  * @param aDiscount, the discount rate of this customer should have
  */
    public void setDiscount(double aDiscount) {
        discount = aDiscount;
    }
/**
 * general toString method
 * @return String which represents the name of this customer
 */
    public String toString() {
        return getName();
    }
}
