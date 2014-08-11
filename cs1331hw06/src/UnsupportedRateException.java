/**
 * UnsupportedRateException exception class extends RuntimeException
 * it is thrown if a given rate is negative
 *
 * @author chongwen guo
 * @version 1.0
 */

public class UnsupportedRateException extends RuntimeException {
/**
 * default constructor
 */
    public UnsupportedRateException() {
         super();
    }
/**
 * constructor
 * @param message
 */
    public UnsupportedRateException(String message) {
         super(message);
     }
}
