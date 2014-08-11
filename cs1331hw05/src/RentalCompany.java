import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * RentalCompany class, which represents the rental company.
 *
 * @author chongwen guo
 * @version 1.0
 */
public class RentalCompany {

    private String name;
    private List<Car> availableCars;
    private List<Lease> leases;

/**
 * constructor for this rental company, which sets its name and
 * add all available cars to its initial inventory
 * @param aName the name for this company
 * @param initialInventory all cars this company has
 */
    public RentalCompany(String aName, Car ... initialInventory) {
        name = aName;
        availableCars = new ArrayList<Car>();
        availableCars.addAll(Arrays.asList(initialInventory));
        leases = new ArrayList<Lease>();
    }
/**
 * this method gets the name of this company
 * @return the name of this rental company
 */
    public String getName() {
        return name;
    }

/**
 * this method gets the list of available cars of this company
 * @return the list which contains all available cars the company has
 */
    public List<Car> getAvailableCars() {
        return availableCars;
    }
/**
 * this method gets the list of all lease the company currently has
 * @return the list which contains all leases the company has
 */
    public List<Lease> getLeases() {
        return leases;
    }
/**
 * this method check if has available cars by comparing the number
 * of passengers and the capacity of cars.
 * @param numPassengers, number of passengers a customer owns
 * @return true if car available, false if not available
 */
    public boolean hasCarAvailable(int numPassengers) {
        return availableCars(numPassengers).size() > 0;
    }

    /**
     * Assumes #isCarAvailable returns true, otherwise behaviro is
     * undefined.
     */
    public Car nextAvailableCar(int numPassengers) {
        return availableCars(numPassengers).get(0);
    }
/**
 * method to gets all available cars by comparing the number of passengers
 * and the capacity of cars
 * add all available cars into bigEnoughs list
 * @param numPassengers
 * @return bigEnoughts, which contains all available cars
 */
    public List<Car> availableCars(int numPassengers) {
        List<Car> bigEnoughs = new ArrayList<Car>();
        for (Car car: availableCars) {
            if (car.passengerCapacity() >= numPassengers) {
                bigEnoughs.add(car);
            }
        }
        return bigEnoughs;
    }

    /**
     * Leases a car by removing it from the available list and adding
     * a lease to the lease list.  Assumes car is available.
     */
    public Lease lease(Car car, Customer customer) {
        availableCars.remove(car);
        Lease lease = new Lease(car, customer);
        leases.add(lease);
        return lease;
    }

 /**
  * method to return a car by adding the car in a lease to inventory
  * and remove the lease
  *
  * @param lease, the lease with the car returned
  */
    public void returnCar(Lease lease) {
        availableCars.add(lease.getCar());
        leases.remove(lease);
    }
}
