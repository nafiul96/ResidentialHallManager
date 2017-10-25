
/**
 * MD NAFIUL AZIM
 * CSE214_HOMEWORK-1
 * ID#: 110548047
 */
/**
 * This Class defines Student Object.
 *
 * @author MD NAFIUL AZIM
 */
public class Student {

    public static final int MAX_WRTIEUPS = 3;
    private String name;
    private int idNumber;
    private int numWriteups;

    /**
     * The Constructor for the Student Object which creates an instance of the
     * Student Object with <code>name</code> and <code>idNumber</code>
     *
     * @param name holds the name of the student
     * @param idNumber holds the ID number of the student
     */
    public Student(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
        numWriteups = 0;
    }

    /**
     * Accessor/ Getter Method for the name of the student
     *
     * @return Once called, it returns the name of the student as
     * <code>String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator/ Setter method for the name of the student which sets the
     *
     * @param name the new name of the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the ID number
     *
     * @return It returns the ID number of the student
     */
    public int getIdNumber() {
        return idNumber;
    }

    /**
     * Setter for the id number
     *
     * @param idNumber The new ID number of the student
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Getter for the <code>writeups</code> for the student
     *
     * @return It returns the number of writeups the particular student has
     */
    public int getNumWriteups() {
        return numWriteups;
    }

    /**
     * Setter for the writeUps
     *
     * @param numWriteups The new writeUps for the student
     */
    public void setNumWriteups(int numWriteups) {
        this.numWriteups = numWriteups;
    }

    /**
     * This method makes deep copy of the student object
     *
     * @return It returns the deep copy of the student
     */
    @Override
    public Object clone() {

        Student temp = new Student("", 0);
        temp.setIdNumber(this.getIdNumber());
        temp.setName(this.getName());
        temp.setNumWriteups(this.getNumWriteups());
        return temp;
    }

}
