/**
 * DuplicateUnitException exception class extends RuntimeException
 * it is thrown if there are duplicate units
 * @author chongwen guo
 * @version 1.0
 *
 */
public class DuplicateUnitException extends RuntimeException {

/**
 * default constructor
 */
    public DuplicateUnitException() {
         super();
    }
/**
 * constructor
 * @param message
 */
    public DuplicateUnitException(String message) {
          super(message);

    }
}
