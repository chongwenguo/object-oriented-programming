/**
 * class for User created convertible unit
 *
 * @author chongwen guo
 * @version 1.0
 *
 */
public class UserCreatedConvertible implements Convertible {

    private double conversionRate;
    private String name;
    private String fact;

/**
 * constructor which sets the conversionrate, name, and fact according to
 * the input
 *
 * @param double rate - the new conversion rate
 * @param String name - the name of this unit
 * @param String fact - the fact about this unit
 */
    public UserCreatedConvertible(double rate, String name, String fact) {
        conversionRate = rate;
        this.name = name;
        this.fact = fact;
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
