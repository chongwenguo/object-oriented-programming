
import java.text.NumberFormat;
/**
 * lease class which represents a rental, i.e., a car rented to a customer.
 *
 * @author chongwen guo
 * @version 1.0
 *
 */


public class Lease {

    private Car car;
    private Customer customer;

/**
 * constructor
 *
 * @param aCar that car which is leased to a customer
 * @param aCustomer the customer who wants to lease a car
 */
    public Lease(Car aCar, Customer aCustomer) {
        car = aCar;
        customer = aCustomer;
    }
/**
 * method to get the car a customer rented
 * @return the car a customer rented
 */
    public Car getCar() {
        return car;
    }

/**
 * method to get the daily rate for a customer base on his discount
 * @return the daily rate for a customer
 */
    public double dailyRate() {
        return car.baseDailyRate() * (1.0 - customer.getDiscount());
    }
/**
 *
 * general toString method
 *
 * @return string which represents a lease including the name of a car,
 * customer and daily rate.
 */

    public String toString() {
        NumberFormat us = NumberFormat.getCurrencyInstance();
        return car.toString() + " leased to " + customer + " for "
               + us.format(car.baseDailyRate()) + " a day";
    }
}
