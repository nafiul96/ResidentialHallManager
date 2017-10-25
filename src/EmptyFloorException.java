
/**
 * MD NAFIUL AZIM
 * CSE214_HOMEWORK-1
 * ID#: 110548047
 */
/**
 * This class contains the inheritance of Exception Class of Java. This Exception Class ensures that no student can be removed from
 * a floor without any student
 *
 * @author MD NAFIUL AZIM
 */
public class EmptyFloorException extends Exception {

    /**
     * Creates instance of EmptyFloorException
     */
    public EmptyFloorException() {

        super("The floor is empty!");
    }
}
