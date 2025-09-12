
import java.util.Scanner;

public class SchoolManagementSystem {

    public static void main(String[] args) {

        System.out.println("Welcome to CyberCrewz Academy \nSchool Management System V1 \nCode Name River ");

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
            int userInput = input.nextInt();

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
        int[] ID = new int[3];
        int[] marks = new int[3];
        String[] name = new String[3];

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("""
                    1. Add a New Student
                    2. List All Students
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
                    System.out.println("--- Student List ---");
                    System.out.println("+---------+---------------------+---------+");
                    System.out.printf("| %-7s | %-19s | %-7s |\n", "ID", "Name", "Marks");
                    System.out.println("+---------+---------------------+---------+");
                    for (int i = 0; i < (ID.length); i++) {
                        if ((ID[i] != 0) || (name[i] != null) || (marks[i] != 0)) {
                            // System.out.println("ID: " + ID[i] + ", Name: " + name[i] + ", Marks: " +
                            // marks[i]);
                            System.out.printf("| %-7d | %-19s | %-7d |\n", ID[i], name[i], marks[i]);
                        }
                    }
                    System.out.println("+---------+---------------------+---------+");
                    System.out.println();
                }

                case 0 -> {
                    System.out.println("Exiting to main");
                    // input.close();
                    return;
                }
            }
        }

    }
}
