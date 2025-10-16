
import java.util.Scanner;
import utils.AttendanceManager;
import utils.GradeCalc;
import utils.Greeter;
import utils.SafeInputReader;
import utils.StudentIO;

public class SchoolManagementSystem {

    static int[] ID = new int[3];
    static double[] marks = new double[3];
    static int[] endXmarks = new int[3];
    static int[] midXmarks = new int[3];
    static int[] hwMarks = new int[3];
    static String[] name = new String[3];
    static public String[][] attendance = new String[3][7];

    static double finalExamW = 0.6;
    static double midExamW = 0.3;
    static double homeWorkW = 0.1;

    public static void main(String[] args) {
        Greeter.sayHello();
        createDummyData();
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
                    5. Grading Scheme Configuration
                    6. Attendance Management
                    0. Exit
                    """);

            int userInput = SafeInputReader.intInput("Enter your choice: ", 0, 6);

            switch (userInput) {
                case 1 -> {
                    System.out.println("---Navigating to Student Management ---");
                    students();
                }
                case 2 -> System.out.println("---Navigating to Teacher Management---");
                case 3 -> {
                    System.out.println("---Navigating to Library Management---");
                    System.err.println("""
                        1. Add a New Book
                        2. Borrow a Book
                        3. Return a Book
                        4. List All Books
                        5. List Available Books
                        0. Back to Main Menu
                                    """);
                    userInput = SafeInputReader.intInput("Enter your choice:", 1, 5);

                    switch (userInput) {
                        case 1 -> {
                        }
                    }

                }
                case 4 -> System.out.println("---Navigating to Reports---");
                case 5 -> {
                    System.out.println("--- Grading Scheme Setup ---");
                    System.out.println(
                            "You will define the components of the final grade. \nAll weights must sum to 1.0 (e.g., 0.6 for 60%). \n ");
                    while (true) {
                        finalExamW = SafeInputReader.floatInput("Enter weight for 'Final Exam': ", 0.0, 1.0);
                        midExamW = SafeInputReader.floatInput("Enter weight for 'Midterm Exam': ", 0.0, 1.0);
                        homeWorkW = SafeInputReader.floatInput("Enter weight for 'Home works': ", 0.0, 1.0);

                        if (finalExamW + midExamW + homeWorkW == 1.0) {
                            System.out.println("Success! Grading scheme has been configured for this session.");
                            break;
                        } else {
                            System.out.println("All weights must sum to 1.0");
                            System.out.println("Enter again.. ! \n");
                        }

                    }
                }

                case 6 -> {
                    attendance();
                }
                case 0 -> {
                    System.out.println("Thank you for using the School Management System. Goodbye!");
                    input.close();
                    return;

                }

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
            int userInput = SafeInputReader.intInput("Enter your choice:", 0, 5);
            System.out.println();

            switch (userInput) {
                case 1 -> {
                    for (int i = 0; i < (ID.length); i++) {
                        int stCount = 0;
                        while (true) {
                            if ((ID[stCount] != 0) || (name[stCount] != null) || (marks[stCount] != 0)) {
                                stCount++;
                                if (stCount == ID.length) {
                                    break;

                                }
                            } else {
                                break;
                            }
                        }

                        if (stCount < ID.length) {

                            if ((ID[i] == 0) && (name[i] == null) && (marks[i] == 0)) {
                                ID[i] = SafeInputReader.intInput("Enter Student ID: ", 1, 1000);
                                name[i] = SafeInputReader.strInput("Enter Student Name: ");
                                endXmarks[i] = SafeInputReader.intInput("Enter Student Final Exam Marks: ", 0, 100);
                                midXmarks[i] = SafeInputReader.intInput("Enter Student Mid Exam Marks: ", 0, 100);
                                hwMarks[i] = SafeInputReader.intInput("Enter Student Homw work Marks: ", 0, 100);
                                // marks[i] = (endXmarks[i] * finalExamW + midXmarks[i] * midExamW + hwMarks[i]
                                // * homeWorkW);

                                int[] studentMarks = { endXmarks[i], midXmarks[i], hwMarks[i] };

                                double[] marksWeighr = { finalExamW, midExamW, homeWorkW };

                                marks[i] = GradeCalc.main(studentMarks, marksWeighr, hwMarks.length);

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
                            StudentIO.printRow(ID[i], name[i], endXmarks[i], midXmarks[i], hwMarks[i], marks[i]);
                        }
                    }
                    StudentIO.footer();
                }

                case 3 -> {
                    System.out.print("Enter the Student ID to search for: ");
                    int stID = SafeInputReader.intInput("Enter the Student ID to search for: ", 1, 1000);
                    System.out.println();
                    int index = indexSearch(stID);
                    if (index == -1) {
                        StudentIO.printNotFoundError(stID);
                    } else {
                        StudentIO.header("Student Found");
                        StudentIO.printRow(ID[index], name[index], endXmarks[index], midXmarks[index], hwMarks[index],
                                marks[index]);
                        StudentIO.footer();
                    }
                }

                case 4 -> {

                    int stID = SafeInputReader.intInput("Enter the Student ID to update: ", 1, 1000);
                    System.out.println();
                    int index = indexSearch(stID);
                    if (index == -1) {
                        System.out.println("Error: Student with ID:" + stID + " not found.");
                    } else {
                        System.out.println("Found Student : " + name[index] + "(Current Marks: " + marks[index] + " )");
                        marks[index] = SafeInputReader.intInput("Enter new marks", 0, 100);
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

    public static int indexSearch(int stID) {
        int index = -1;
        for (int i = 0; i < (ID.length); i++) {
            if (ID[i] == stID) {
                index = i;
            }
        }
        return index;
    }

    public static void attendance() {
        boolean valid = false;
        while (!valid) {
            System.out.println("--- Attendance Management ---");
            System.out.println("""
                    1. Mark Daily Attendance
                    2. View Full Attendance Grid
                    3. Get Student Attendance Report
                    4. List Absentees for a Day
                    0. Back to Main Menu
                    """);
            int userInput = SafeInputReader.intInput("Enter Your choice : ", 0, 4);

            switch (userInput) {
                case 1 -> {
                    AttendanceManager.mark(ID, name, attendance);
                }
                case 2 -> {
                    AttendanceManager.view(attendance, ID, name);
                }
                case 3 -> {
                    AttendanceManager.search(ID, name, attendance);
                }
                case 4 -> {
                    AttendanceManager.absentees(ID, name, attendance);
                }
                case 0 -> {
                    System.out.println("Braked");
                    valid = true;
                    break;
                }
            }
        }
    }

    public static void createDummyData() {
        ID[0] = 101;
        ID[1] = 102;
        ID[2] = 103;

        name[0] = "Dil";
        name[1] = "Ozz";
        name[2] = "Bob";

        endXmarks[0] = 85;
        endXmarks[1] = 92;
        endXmarks[2] = 78;

        midXmarks[0] = 75;
        midXmarks[1] = 88;
        midXmarks[2] = 80;

        hwMarks[0] = 95;
        hwMarks[1] = 90;
        hwMarks[2] = 85;
    }

}
