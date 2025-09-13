package utils;

public class StudentIO {
    public static void header(String msg) {
        System.out.println("--- "+ msg +" ---");
        System.out.println("+=========================================+");
        System.out.printf("| %-7s | %-19s | %-7s |\n", "ID", "Name", "Marks");
        System.out.println("+---------+---------------------+---------+");
    }

    public static void printRow(int ID, String name, int marks) {
        System.out.printf("| %-7d | %-19s | %-7d |\n", ID, name, marks);
    }

    public static void footer() {
        System.out.println("+---------+---------------------+---------+\n");
    }

    public static void printNotFoundError(int studentId) {
        System.out.println("Error: Student with ID " + studentId + " not found.");
    }
}
