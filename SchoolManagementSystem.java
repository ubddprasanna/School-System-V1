
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
                case 1 -> System.out.println("Navigating to Student Management...");
                case 2 -> System.out.println("Navigating to Teacher Management...");
                case 3 -> System.out.println("Navigating to Library Management...");
                case 4 -> System.out.println("Navigating to Library Reports...");
                case 0 -> {
                    System.out.println("Thank you for using the School Management System. Goodbye!");
                    input.close();
                    return;

                }
                default -> System.out.println("Invalid choice. Please enter a number between 0 and 4.");

            }

        }
    }
}
