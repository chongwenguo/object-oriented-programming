/**
 * class for Yard unit to implement its function
 *
 * @author chongwen guo
 * @version 1.0
 *
 */
public class Yard implements Convertible {

    private double conversionRate;
    private String name;
    private String fact;

/**
 * default constructor which sets the conversionrate to 0.9144, name to
 * yard, and assigns a fact
*/
    public Yard() {
        conversionRate = 0.9144;
        name = "Yard";
        fact = "a Yard equals three feet ";
     }

/**
 * method to get the conversion rate
 *
 * @return ConversionRate
 */
    public double getConversionRate() {
        return conversionRate;
    }

/**
 * method to get the name of this unit
 *
 * @return the name of this unit
 */
    public String getName() {
        return name;
    }

/**
 * method to convert a number with other unit to mile
 *
 * @return the converted quantity
 */
    public double convertToMeters(double x) {
           return x * conversionRate;
     }

/**
 * method to get the fact of mile
 *
 * @return string representation of the fact
 */
    public String specialInformation() {
        return fact;
    }

/**
 * method to convert to different measurement
 *
 * @return converted rate
 */
    public double convertToDifferentMeasurement(double x, double rate) {
         return x * rate;
     }

}
