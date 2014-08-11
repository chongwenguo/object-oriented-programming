/**
 * class for mile unit to implement its function
 *
 * @author chongwen guo
 * @version 1.0
 *
 */
public class Mile implements Convertible {

    private double conversionRate;
    private String name;
    private String fact;

/**
 * default constructor which sets the conversionrate to 1609.344, name to
 * Mile, and assigns a fact
 */
    public Mile() {
        conversionRate = 1609.34;
        name = "Mile";
        fact = "Mile is not used as scientific purpose ";
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
