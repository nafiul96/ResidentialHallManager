
/**
 * MD NAFIUL AZIM
 * CSE214_HOMEWORK-1
 * ID#: 110548047
 */
import java.util.Scanner;

/**
 * The driver class that contains the main method
 *
 * @author MD NAFIUL AZIM
 */
public class ResidenceHallManager {

    private static Floor building[] = new Floor[4];
    private static Scanner input = new Scanner(System.in);
    private static int floorNumber = 0;

    public static void main(String[] args) {
        boolean done = false;
        for (int i = 1; i < building.length; i++) {

            building[i] = new Floor();
        }

        System.out.println("Welcome to CrazyRez");

        while (!done) {

            System.out.println("Please selected a floor:");
            floorNumber = input.nextInt();
            input.nextLine();
            if (floorNumber <= 0 || floorNumber >= building.length) {

                System.out.println("Invalid Floor Selection");
            } else {

                System.out.println("You have selecte floor " + floorNumber);
                done = true;
            }
        }
        menuDriver();
    }

    // while(selected = null){}
    /**
     * It displays the main menu on the console
     */
    public static void mainMenu() {

        System.out.println("Main Menu:");
        System.out.println("A) Add Student");
        System.out.println("R) Remove Student");
        System.out.println("S) Swap Student");
        System.out.println("Move Student");
        System.out.println("F) Select Floor");
        System.out.println("C) Copy Floor");
        System.out.println("P) Print Current Floor");
        System.out.println("W)Write Up Student");
        System.out.println("Q)Quit");
    }

    /**
     * It drives the Menu, contains the heart of the program. This method calls
     * up other methods lated described to make the program functional
     */
    public static void menuDriver() {

        boolean done = false;
        String s = "";
        int id = 0;
        int spot = 0;
        while (!done) {

            mainMenu();
            System.out.println("Select an option:");
            s = (input.next()).toLowerCase();
            input.nextLine();
            switch (s) {

                case "a":
                    addStudent();
                    break;
                case "r":
                    removeStudent();
                    break;
                case "s":
                    swapStudent();
                    break;
                case "m":
                    moveStudent();
                    break;
                case "f":
                    floorSelection();
                    break;
                case "c":
                    copyFloor();
                    break;
                case "p":
                    building[floorNumber].printAll();
                    break;
                case "w":
                    writeUps();
                    break;
                case "q":
                    done = true;
                    System.out.println("Thank you for using this Menu App");
                    break;
                default:
                    System.out.println("Not an Option. Try Again");

            }
        }
    }

    /**
     * This method performs the addStudent job once called
     */
    public static void addStudent() {
        System.out.println("Please enter the name: ");
        String name = input.nextLine();
        System.out.println("Please enter the ID number: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Please enter the positon:");
        int spot = input.nextInt();
        input.nextLine();
        Student newStudent = new Student(name, id);

        try {
            building[floorNumber].addStudent(newStudent, spot);
            System.out.println(name + " is added to room " + spot + " of floor " + floorNumber + " successfully");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        } catch (FullFloorException ex) {
            System.out.println(ex);
        }

    }

    /**
     * This method does the job of removal of student
     */
    public static void removeStudent() {

        System.out.println("Please enter the position of the student to be removed");
        int pos = input.nextInt();
        Student temp;
        try {
            temp = building[floorNumber].removeStudent(pos);
            System.out.println(temp.getName() + " has been removed from floor " + floorNumber + " room " + pos);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        } catch (EmptyFloorException ex) {
            System.out.println(ex);
        }

    }

    /**
     * This method swaps a student with another student from another floor when
     * possible
     */
    public static void swapStudent() {
        try {
            System.out.println("Please enter the source floor:");
            int source = input.nextInt();
            System.out.println("Please enter the positon: ");
            int sourcePos = input.nextInt();
            Student temp1 = building[source].getStudent(sourcePos);
            System.out.println("Please enter the desition floor: ");
            int destinition = input.nextInt();
            System.out.println("Please enter the destinition position: ");
            int destPos = input.nextInt();
            Student temp2 = building[destinition].getStudent(destPos);
            building[source].setStudent(sourcePos, temp2);
            building[destinition].setStudent(destPos, temp1);
            System.out.println(temp1.getName() + " is swapped with " + temp2.getName());
        } catch (IllegalArgumentException ex) {

            System.out.println(ex);
        }
    }

    /**
     * This method does the job of shifting student from one floor to another
     * using remove and add method concurrently
     */
    public static void moveStudent() {
        try {
            System.out.println("Please enter the source floor: ");
            int source = input.nextInt();
            System.out.println("Please enter the source room: ");
            int sourcePos = input.nextInt();
            System.out.println("Please enter the destinition floor: ");
            int destinition = input.nextInt();
            System.out.println("Please enter the destinition room: ");
            int destPos = input.nextInt();
            if (building[source].isFull() || building[destinition].isFull()) {

                System.out.println("This Moving is NOT possible");
            } else {

                building[destinition].addStudent(building[sourcePos].removeStudent(sourcePos), destPos);
                System.out.println(building[destinition].getStudent(destPos).getName() + " has been moved to floor " + destinition);
            }
        } catch (IllegalArgumentException ex) {

            System.out.println(ex);
        } catch (EmptyFloorException ex) {

            System.out.println();
        } catch (FullFloorException ex) {

            System.out.println(ex);
        }
    }

    /**
     * The method changes the floorNumber based on the validity of the floor
     * number entered
     */
    public static void floorSelection() {

        System.out.println("Please select a floor: ");
        int newFloorNumber = input.nextInt();
        if (newFloorNumber <= 0 || newFloorNumber > 3) {

            System.out.println("This floor number is not possible");
        } else {

            floorNumber = newFloorNumber;
            System.out.println("floor " + floorNumber + " is selected successfully");
        }
    }

    /**
     * This method copies a floor to paste to another when possible using deep
     * cloning implemented in Student class and Floor class
     */
    public static void copyFloor() {

        System.out.println("Enter the source floor number: ");
        int source = input.nextInt();
        System.out.println("Enter the destiniton floor number: ");
        int dest = input.nextInt();
        if ((source <= 0 || source > 3) || (dest <= 0 || dest > 3)) {

            System.out.println("Invalid floor numbers!Such copying is not possible.");
        } else {

            building[dest] = building[source].clone();
            System.out.println("Floor" + source + " is being copied to floor" + dest + " successfully");
        }

    }

    /**
     * This method changes the writeUps value of a student based on name. once
     * the writeUps reaches it's maximum value, the student is removed from the
     * particular floor entry.
     */
    public static void writeUps() {
        try {
            System.out.println("Please enter the Name of the student: ");
            String name = (input.nextLine()).toLowerCase();
            for (int i = 1; i <= building[floorNumber].count(); i++) {

                if (building[floorNumber].getStudent(i).getName().equals(name)) {

                    building[floorNumber].getStudent(i).setNumWriteups(building[floorNumber].getStudent(i).getNumWriteups() + 1);
                    int writeUp = building[floorNumber].getStudent(i).getNumWriteups();
                    System.out.println("WriteUp for" + name + " has been set to " + writeUp);
                    if (writeUp == Student.MAX_WRTIEUPS) {

                        building[floorNumber].removeStudent(i);
                    }
                    break;
                }
            }

        } catch (IllegalArgumentException ex) {

            System.out.println(ex);
        } catch (EmptyFloorException ex) {

            System.out.println(ex);
        }

    }
}
