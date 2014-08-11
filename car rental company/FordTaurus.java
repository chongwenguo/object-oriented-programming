/**
 * FordTaurus class, which represents a Ford Taurus, and extends the Car class
 *
 * @author chongwen guo
 * @version 1.0
 *
 */


public class FordTaurus extends Car {

/**
 * constructor for FordTaurus, create a Ford Taurus with
 * a license plate and 30.00 base daily rate and 4 passenger
 * capacity
 * @param aLicensePlate, the license plate for a Ford Taurus
 */

    public FordTaurus(String aLicensePlate) {
        super(aLicensePlate, 30.00, 4);
    }


/**
 * this method gets the base daily rate of this Ford Taurus
 * @return baseDailyRate, the base daily rate of this Ford Taurus
 */
    public double baseDailyRate() {
        return super.baseDailyRate();
    }

/**
 * this method gets the base daily rate of this Ford Taurus
 * @return baseDailyRate, the base daily rate of this Ford Taurus
 */
    public int passengerCapacity() {
        return super.passengerCapacity();
    }


/**
 * general toString method
 * @return String with represents a Ford Taurus with its license plate
 */
    public String toString() {
        return "Ford Taurus with license plate " + licensePlate;
    }
}
