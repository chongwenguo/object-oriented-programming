/**
 * class for inch unit to implement its function
 *
 * @author chongwen guo
 * @version 1.0
 *
 */
public class Inch implements Convertible {

    private double conversionRate;
    private String name;
    private String fact;
 /**
  * default constructor which sets the conversion rate to 0.0254,
  * name to Inch, and assigns a fact
  */
    public Inch() {
        conversionRate = 0.0254;
        name = "Inch";
        fact = "it is small compared to meter ";
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
 * the covnertToDifferenceMeasurement method
 * converts a set amount of of this unit
 * to another unit already defined.
 *
 * @param x - the amount to convert
 * @param rate - the rate of conversion of the other type
 * @return double amount - the converted amount.
 */
    public double convertToDifferentMeasurement(double x, double rate) {
        return x * rate;
    }

}
