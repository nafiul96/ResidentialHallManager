
/**
 * MD NAFIUL AZIM
 * CSE214_HOMEWORK-1
 * ID#: 110548047
 */
/**
 * This is a customized Exception, an inheritance of Exception class. It ensures that no student is added once a floor reaches it's
 * capacity limit.
 *
 * @author MD NAFIUL AZIM
 */
public class FullFloorException extends Exception {

    /**
     * Creates Instance of FullFloorException
     */
    public FullFloorException() {

        super("The floor is full");
    }
}
