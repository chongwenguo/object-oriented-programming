/**
 * UnsupportedRateException exception class extends RuntimeException
 * it is thrown if a given unit is not supported
 * @author chongwen guo
 * @version 1.0
 */

public class UnsupportedUnitException extends RuntimeException {
/**
 * default constructor
 */
    public UnsupportedUnitException() {
         super();
    }
/**
 * constructor
 * @param message
 */
    public UnsupportedUnitException(String message) {
         super(message);

     }

}
