/**
 * MetricConverte class which deals with all units and their functions.
 *
 * @author chongwen guo
 * @version 1.0
 */

public class MetricConverter {

    private Convertible[] units;
    private int arraySize = 5;
    private int index;

/**
 * Default Constructor: instantiate the array and put the Convertible objects
 * that are instantiated into the array.
 *
 */
    public MetricConverter() {
        units = new Convertible[arraySize];
        units[index++] = new Mile();
        units[index++] = new Foot();
        units[index++] = new Inch();
        units[index++] = new Kilometer();
        units[index++] = new Yard();
        //index = 5
    }

/**
 * addUnit method
 *
 * Add a new unit into the array with its rate, name and fact.
 * if size is not enough, double the size.
 *
 * @param double rate - rate to meter for new unit
 * @param String name - name for new unit
 * @param String fact - fact about new unit
 *
 * @throws UnsupportedRateException -if the inputed rate is negative
 * @throws DuplicateUnitException - if the inputed unit is already supported
 */
    public void addUnit(double rate, String name, String fact)
     throws DuplicateUnitException, UnsupportedRateException {
         checkDuplication(name);
         if (rate < 0) {
             throw new UnsupportedRateException(
                     "UnsupportedRateException: Nonnegative rate!");
        }
        if (index >= arraySize) {
            Convertible[] temp = units.clone();
            arraySize *= 2;
            units = new Convertible[arraySize];
            for (int i = 0; i < index; i++) {
                units[i] = temp[i];
            }
        }
        units[index++] = new UserCreatedConvertible(rate, name, fact);
    }

/**
 * converToMeters method
 *
 * Convert the unit to meters by giving the name and number of that unit.
 *
 * @param String name - the name of unit
 * @param x - the quantity of the unit
 * @return double result - the converted value of meters
 *
 * @throws UnsupportedUnitException - if the inputed unit is not supported
  */
    public double convertToMeters(String name, double x)
              throws UnsupportedUnitException {
        checkUnitSupported(name);
        double result = 0;
        for (int i = 0; i < index; i++) {
            if (units[i].getName().equalsIgnoreCase(name)) {
                result = units[i].convertToMeters(x);
            }
        }
        return result;
    }
/**
 * convertToDifferentUnit method
 *
 * Convert one unit to another unit
 *
 * @param baseUnit
 * @param targetUnit
 * @param x
 * @return the converted value of target unit
 *
 * @throws UnsupportedUnitException - if the inputed unit is not supported
 */
    public double convertToDifferentUnit(String baseUnit, String targetUnit,
            double x) throws UnsupportedUnitException {
        checkUnitSupported(baseUnit);
        checkUnitSupported(targetUnit);
        double rate1 = 0, rate2 = 1;
        for (int i = 0; i < index; i++) {
            if (units[i].getName().equalsIgnoreCase(baseUnit)) {
                   rate1 = units[i].getConversionRate();
            }
            if (units[i].getName().equalsIgnoreCase(targetUnit)) {
               rate2 = units[i].getConversionRate();
            }
        }
        return   x * rate1 / rate2;
    }

/**
 * getCoolFact method
 *
 * get a fact of a unit.
 *
 * @param name - the name of unit
 * @return the fact of the given unit
 *
 * @throws UnsupportedUnitException - if the inputed unit is not supported
 */
 public String getCoolFact(String name) throws UnsupportedUnitException {
        checkUnitSupported(name);
        String s = "";
        for (int i = 0; i < index; i++) {
            if (units[i].getName().equalsIgnoreCase(name)) {
                s = units[i].specialInformation();
            }
        }
        return s;
    }
/**
 * method to check weather the input unit name already exists or not.
 *
 * @param name - the name of wanted input operation
 *
 * @throws DuplicateUnitException - if the inputed unit is already supported
 */
    public void checkDuplication(String name) throws DuplicateUnitException {
        for (int i = 0; i < index; i++) {
            if (units[i].getName().equalsIgnoreCase(name)) {
                throw new DuplicateUnitException(
                    "DuplicateUnitException:"
                    + " We already support this operation!");
            }
        }
    }

/**
 * Check if the input unit is supported
 *
 * @param name - the input unit name
 *
 * @throws UnsupportedUnitException - if the inputed unit is already supported
 */
    public boolean checkUnitSupported(String name)
            throws UnsupportedUnitException {
        boolean isSupported = false;
        for (int i = 0; i < index; i++) {
            if (units[i].getName().equalsIgnoreCase(name)) {
                isSupported = true;
            }
        }
        if (!isSupported) {
            throw  new UnsupportedUnitException(
            "UnsupportedUnitException: the inputed unit is not supported!");
        }
        return isSupported;
    }


/**
 * general toString method
 *
 * @return the String representation
 */
    public String toString() {
        String s = "We offer these following units: \n";
        for (int i = 0; i < index; i++) {
            s += units[i].getName() + "\n";
        }
        return s;
    }

}
