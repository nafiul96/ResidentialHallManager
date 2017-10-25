
/**
 * MD NAFIUL AZIM
 * CSE214_HOMEWORK-1
 * ID#: 110548047
 */
/**
 * This Floor Class is used to create floor type object. This class has-an instance of Student Objects as array where the maximum number of students can be added for the particular
 * floor is limited to 50.
 *
 * @author MD NAFIUL AZIM
 */
public class Floor {

    private Student student[];
    final int CAPACITY = 50;
    private int size;

    /**
     * The constructor for the Floor Object which creates an instance of Floor
     * class
     */
    public Floor() {

        this.student = new Student[CAPACITY + 1];
        size = 0;
    }

    /**
     * This method adds an student to a specific position. In this case the
     * position resembles the room number on the particular floor. If the room
     * is occupied already, the other students is shifted and new student is
     * given the desired spot
     *
     * @param newStudent The student to be added
     * @param position The room number
     * @throws IllegalArgumentException This exception is thrown if the position
     * is too high or too low
     * @throws FullFloorException This exception is thrown when the floor is
     * already full and can't add the new student
     */
    public void addStudent(Student newStudent, int position) throws IllegalArgumentException, FullFloorException {

        if (size == CAPACITY) {

            throw new FullFloorException();
        } else if (position <= 0 || position > size + 1) {

            throw new IllegalArgumentException("Invalid position");
        } else if (position == size + 1 || size == 0) {

            this.student[++size] = newStudent;
        } else {

            //Shifting Array
            Student temp[] = new Student[CAPACITY + 1];
            for (int i = 0; i < position; i++) {

                temp[i] = this.student[i];
            }
            temp[position] = newStudent;

            for (int j = position + 1; j <= size + 1; j++) {

                temp[j] = this.student[j - 1];
            }

            this.student = temp;
            size++;

        }
    }

    /**
     * This method removes a student from a given position. While removing the
     * new student, the other students on the particular floor is shifted
     * forward/backward in order to fillup the gap
     *
     * @param position The room number of the student to be removed
     * @return It returns removed Student
     * @throws IllegalArgumentException This exception is thrown if the position
     * value is too high or too low compare to the actual size/ capacity of the
     * floor
     * @throws EmptyFloorException This exception is thrown to ensure that there
     * is no student is removed when the floor is empty
     */
    public Student removeStudent(int position) throws IllegalArgumentException, EmptyFloorException {

        if (size == 0) {

            throw new EmptyFloorException();
        } else if (position <= 0 || position > size) {
            throw new IllegalArgumentException("Invalid Position");

        } else {

            Student temp[] = new Student[CAPACITY];
            for (int i = 0; i < position; i++) {

                temp[i] = this.student[i];
            }

            Student removed = this.student[position];

            for (int j = position + 1; j <= size; j++) {

                temp[j - 1] = this.student[j];
            }
            this.student = temp;
            size--;

            return removed;
        }

    }

    /**
     * It fetches the student Object based on room number
     *
     * @param position The room number of the student to be found
     * @return It returns the Student t be found if exists
     * @throws IllegalArgumentException This exception is thrown to ensure that
     * the position of the student is in range of occupation of the floor or in
     * the capacity of the floor
     */
    public Student getStudent(int position) throws IllegalArgumentException {

        if (position <= 0 || position > size) {

            throw new IllegalArgumentException("Invalid Position");
        } else {

            return this.student[position];
        }
    }

    /**
     * It sets the new student to the position while overriding the existing
     * student
     *
     * @param position the assigned room number by the administration
     * @param movedStudent the new student
     * @throws IllegalArgumentException
     */
    public void setStudent(int position, Student movedStudent) throws IllegalArgumentException {

        if (position <= 0 || position > size) {

            throw new IllegalArgumentException("Invalid position");
        } else {

            this.student[position] = movedStudent;
        }
    }

    /**
     * Checks to see whether the floor is empty or not
     *
     * @return It returns true when there is no student on the floor, otherwise
     * false
     */
    public boolean isFull() {

        return size == CAPACITY;
    }

    /**
     * It counts the size of the floor or the number of room already occupied
     *
     * @return It returns the number of room already occupied
     */
    public int count() {

        return size;
    }

    /**
     * This method makes deep copy of the Floor
     *
     * @return It returns floor object as deep copy
     */
    @Override
    public Floor clone() {

        Floor temp = new Floor();
        temp.size = this.size;
        for (int i = 1; i <= size; i++) {

            temp.student[i] = (Student) this.student[i].clone();
        }
        return temp;
    }

    /**
     * This Method prints out the entire entries for the floor
     */
    public void printAll() {

        Student temp;
        System.out.println("...............................................................");
        System.out.printf("%11s%20s%11s%11s\n", "Room", "Name", "ID", "WriteUps");
        for (int i = 1; i <= size; i++) {
            temp = this.student[i];
            System.out.printf("%11s%20s%11s%11s\n", i, temp.getName(), temp.getIdNumber(), temp.getNumWriteups());
        }
    }

}
