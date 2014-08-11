/**
 * DodgeCaravan class, which represents a dodge caravan,
 * and extends the Car class
 * @author chongwen guo
 * @version 1.0
 *
 */

public class DodgeCaravan extends Car {



/**
 * constructor for DodgeCaravan, create a dodge caravan with a license plate
 * and 40.00 base daily rate and 8 passenger capacity
 * @param aLicensePlate, the license plate for a dodge caravan
 */
    public DodgeCaravan(String aLicensePlate) {
        super(aLicensePlate, 40.00, 8);

    }

/**
 * this method gets the base daily rate of this dodge caravan
 * @return baseDailyRate, the base daily rate of this dodge caravan
 */
    public double baseDailyRate() {
       return super.baseDailyRate();
    }

 /**
  * this method gets the passengerCapacity of this dodge caravan
  * @return passengerCapacity, the passenger capacity of this dodge caravan
  */
    public int passengerCapacity() {
       return super.passengerCapacity();
    }

/**
 * general toString method
 * @return String with represents a dodge caravan with its license plate
 */
    public String toString() {
        return "Dodge Caravan with license plate " + licensePlate;
    }
}
