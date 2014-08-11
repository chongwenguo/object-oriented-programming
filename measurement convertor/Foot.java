/**
 * class for foot unit to implement its function
 *
 * @author chongwen guo
 * @version 1.0
 *
 */
public class Foot implements Convertible {

    private double conversionRate;
    private String name;
    private String fact;
 /**
  * default constructor which sets the conversionrate to 0.3048,
  * name to Foot, and assigns a fact
  */
    public Foot() {
        conversionRate = 0.3048;
        name = "Foot";
        fact = "a foot is one third of a yard ";
    }
/**
 * method to get the conversion rate
 * @return ConversionRate
 */
    public double getConversionRate() {
        return conversionRate;
    }

/**
 * method to get the name of this unit
 * @return the name of this unit
 */
    public String getName() {
        return name;
    }

/**
 * method to convert a number with other unit to mile
 * @return the converted quantity
 */
    public double convertToMeters(double x) {
        return x * conversionRate;
    }
/**
 * method to get the fact of mile
 * @return string representation of the fact
 */
    public String specialInformation() {
        return fact;
    }
/**
 * method to convert to different measurement
 * @return converted rate
 */
    public double convertToDifferentMeasurement(double x, double rate) {
        return x * rate;
    }

}
