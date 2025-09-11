
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

            if (userInput == 0) {
                System.out.println("Thank you for using the School Management System. Goodbye!");
                break;
            };

        }
    }
}
