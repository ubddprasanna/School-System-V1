
import java.util.Scanner;
import utils.Greeter;
import utils.StudentIO;

public class SchoolManagementSystem {

    static int[] ID = new int[3];
    static int[] marks = new int[3];
    static String[] name = new String[3];

    public static void main(String[] args) {

        Greeter.sayHello();
        menu();

    }

    public static void menu() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("""
                    1. Student Management
                    2. Teacher Management
                    3. Library Management
                    4. Reports
                    0. Exit
                    """);

            System.err.print("Enter your choice: ");
            int userInput = safeInt();

            switch (userInput) {
                case 1 -> {
                    System.out.println("---Navigating to Student Management ---");
                    students();
                }
                case 2 -> System.out.println("---Navigating to Teacher Management---");
                case 3 -> System.out.println("---Navigating to Library Management---");
                case 4 -> System.out.println("---Navigating to Library Reports---");
                case 0 -> {
                    System.out.println("Thank you for using the School Management System. Goodbye!");
                    input.close();
                    return;

                }
                default -> System.out.println("Invalid choice. Please enter a number between 0 and 4.");

            }

        }
    }

    public static void students() {

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("""
                    1. Add a New Student
                    2. List All Students
                    3. Search for a Student by ID
                    4. Update a Student's Marks
                    5. Delete a Student
                    0. Back to Main Menu
                    """);
            System.out.print("Enter your choice:");
            int userInput = input.nextInt();
            System.out.println();

            switch (userInput) {
                case 1 -> {
                    // ................ Debuging codes......
                    // System.out.println("switch (userInput) : case 1 Entered ");
                    // ...............................
                    for (int i = 0; i < (ID.length); i++) {
                        int stCount = 0;
                        while (true) {
                            if ((ID[stCount] != 0) || (name[stCount] != null) || (marks[stCount] != 0)) {
                                stCount++;
                                if (stCount == ID.length) {
                                    // ................ Debuging code/s......
                                    // System.out.println("Array already Full. loop going to safe break, Final
                                    // stCount " + stCount);
                                    // .....................................
                                    break;

                                }
                                // ................ Debuging code/s......
                                // System.out.println("stCount Entered " + stCount);
                                // ................ Debuging code/s......
                            } else {
                                // ................ Debuging code/s......
                                // System.out.println("sys going to brake, Final stCount " + stCount);
                                // ..........................
                                break;
                            }
                        }
                        // ................ Debuging code/s......
                        // System.out.println("stCount < ID.length = " + stCount + "<" + ID.length);
                        // ............................

                        if (stCount < ID.length) {
                            // ................ Debuging codes......
                            // System.out.println("switch (userInput) : case 1 : for (int i = 0; i < (100);
                            // i++) Entered ");
                            // System.out.println("ID: " + ID[i] );
                            // .......................................
                            if ((ID[i] == 0) && (name[i] == null) && (marks[i] == 0)) {
                                System.out.print("Enter Student ID: ");
                                ID[i] = input.nextInt();
                                input.nextLine();

                                System.out.print("Enter Student Name: ");
                                name[i] = input.nextLine();

                                System.out.print("Enter Student Marks: ");
                                marks[i] = input.nextInt();
                                System.out.println();
                                break;
                            }
                        } else {
                            System.err.println("Error: Cannot add more students. The database is full.");
                        }

                    }
                }

                case 2 -> {
                    StudentIO.header("Student List");
                    for (int i = 0; i < (ID.length); i++) {
                        if ((ID[i] != 0) || (name[i] != null) || (marks[i] != 0)) {
                            StudentIO.printRow(ID[i], name[i], marks[i]);
                        }
                    }
                    StudentIO.footer();
                }

                case 3 -> {
                    System.out.print("Enter the Student ID to search for: ");
                    int stID = safeInt();
                    System.out.println();
                    int index = indexSearch(stID);
                    if (index == -1) {
                        StudentIO.printNotFoundError(stID);
                    } else {
                        StudentIO.header("Student Found");
                        StudentIO.printRow(ID[index], name[index], marks[index]);
                        StudentIO.footer();
                    }

                }

                case 4 -> {
                    System.out.print("Enter the Student ID to update: ");
                    int stID = safeInt();
                    System.out.println();
                    int index = indexSearch(stID);
                    if (index == -1) {
                        System.out.println("Error: Student with ID:" + stID + " not found.");
                    } else {
                        System.out.println("Found Student : " + name[index]+ "(Current Marks: " + marks[index]+ " )");
                        System.out.print("Enter new marks: ");
                        marks[index] = safeInt();
                        System.out.println();
                        System.out.println("Student marks updated successfully!");
                        System.out.println();
                    }
                }

                case 0 -> {
                    System.out.println("Exiting to main");
                    // input.close();
                    return;
                }
            }

        }

    }

    public static int safeInt() {
        Scanner input = new Scanner(System.in);
        int number = 0;
        boolean valid = false;

        while (!valid) {
            if (input.hasNextInt()) {
                number = input.nextInt();
                valid = true;
            } else {
                System.out.println("Required Integer");
                input.next();
            }
        }

        return number;
    }

    public static int indexSearch(int stID) {
        int index = -1;
        for (int i = 0; i < (ID.length); i++) {
            if (ID[i] == stID) {
                index = i;
            }
        }
        return index;
    }

}
