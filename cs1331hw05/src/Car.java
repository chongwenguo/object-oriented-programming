/**
 * This class is the parent class of all specific car objects.
 * @author chongwen guo
 * @version 1.0
 */

public abstract class Car {

    protected String licensePlate;
    private double baseDailyRate;
    private int passengerCapacity;

/**
 * constructor for car
 * @param aLicensePlate the license plate for this car
 */
     public Car(String aLicensePlate, double baseDailyRate,
              int passengerCapacity) {
             licensePlate = aLicensePlate;
             this.baseDailyRate = baseDailyRate;
             this.passengerCapacity = passengerCapacity;
    }

/**
 * This method gets the base Daily Rate for a car.
 * @return The base daily rate of this car
 */
    public double baseDailyRate() {
          return baseDailyRate;
    }

/**
 * This method gets the passenger capacity for a car.
 * @return the passenger capacity for this car
 */
     public int passengerCapacity() {
         return passengerCapacity;
     }

/**
 * general toString method
 * @return the String representation of a car with its license plate
 */
    public String toString() {
          return "Car with license plate " + licensePlate;
    }

}
