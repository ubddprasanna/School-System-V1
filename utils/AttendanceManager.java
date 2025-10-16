package utils;

public class AttendanceManager {

    public static void mark(int[] ID, String[] name, String[][] attendance) {
        int day = SafeInputReader.intInput("Enter the day to mark attendance for (1-30): ", 1, 30);
        for (int i = 0; i < ID.length; i++) {
            System.out.println("Student: " + name[i] + " (" + ID[i] + ")");
            attendance[i][day - 1] = SafeInputReader.strBoolInput("Present or Absent? (P/A): ", "P", "A");
        }
    }

    public static void view(String[][] attendance, int[] ID, String[] name) {
        createMockAttendance(attendance);
        System.out.println("--- Full Attendance Grid (Term 1) ---");
        for (int i = 0; i < ID.length; i++) {
            for (int j = 0; j < attendance[i].length; j++) {
                if (attendance[i][j] == null) {
                    attendance[i][j] = "-";
                }

            }
        }

        System.out.println(
                "==================================================================================+");
        System.out.printf("| %-7s | %-19s | %-7s | %-7s | %-7s | %-7s | %-7s |\n", "ID", "Name", "Day 1", "Day 2",
                "Day 3", "Day 4", "Day 5");
        System.out.println(
                "+---------+---------------------+---------+---------+---------+---------+---------+");
        for (int i = 0; i < ID.length; i++) {
            System.out.printf("| %-7d | %-19s | %-7s | %-7s | %-7s | %-7s | %-7s |\n", ID[i], name[i], attendance[i][0],
                    attendance[i][1], attendance[i][2], attendance[i][3], attendance[i][4]);

        }

        System.out.println(
                "+---------+---------------------+---------+---------+---------+---------+---------+\n");

    }

    public static void createMockAttendance(String[][] attendance) {
        for (int i = 0; i < 5; i++) {
            if (i / 3 != 0) {
                attendance[0][i] = "p";
            } else {
                attendance[0][i] = "A";
            }
        }

        attendance[1][2] = "p";
        attendance[1][4] = "p";

        for (int i = 0; i < 5; i++) {
            attendance[2][i] = "P";
        }
    }

    public static void search(int[] ID, String[] name, String[][] attendance) {

        int marked = 0;
        int unmarked = 0;
        int present = 0;
        int absent = 0;

        createMockAttendance(attendance);

        int stID = SafeInputReader.intInput("Enter the Student ID to search for: ", 1, 1000);
        System.out.println();
        int index = indexSearch(ID, stID);
        if (index == -1) {
            StudentIO.printNotFoundError(stID);
        } else {
            System.out.println(
                    "==================================================================================+");
            System.out.printf("| %-7s | %-19s | %-7s | %-7s | %-7s | %-7s | %-7s |\n", "ID", "Name", "Day 1", "Day 2",
                    "Day 3", "Day 4", "Day 5");
            System.out.println(
                    "+---------+---------------------+---------+---------+---------+---------+---------+");

            System.out.printf("| %-7d | %-19s | %-7s | %-7s | %-7s | %-7s | %-7s |\n", ID[index], name[index],
                    attendance[index][0],
                    attendance[index][1], attendance[index][2], attendance[index][3], attendance[index][4]);

            System.out.println(
                    "+---------+---------------------+---------+---------+---------+---------+---------+\n");
            System.out.println();
            System.out.println("--- Attendance Report for " + name[index] + " ---");

            for (int j = 0; j < attendance[index].length; j++) {
                if (attendance[index][j] == null) {
                    unmarked++;
                } else if (attendance[index][j].equalsIgnoreCase("p")) {
                    present++;
                } else if (attendance[index][j].equalsIgnoreCase("a")) {
                    absent++;
                }

            }

            marked = attendance[index].length - unmarked;

            double presentage = (double) present / marked * 100;

            System.out.println("Days Marked So Far: " + marked);
            System.out.println("Days Present: " + present);
            System.out.println("Days Absent: " + absent);
            System.out.println("Attendance Percentage: " + presentage + "%");

            System.out.println();

        }

    }

    public static void absentees(int[] ID, String[] name, String[][] attendance) {
        createMockAttendance(attendance);
        int date = SafeInputReader.intInput("Enter the day to check for absentees (1-5): ", 1, 5);
        System.out.println();
        System.out.println("--- Absentees on Day " + date + " ---");
        for (int i = 0; i < ID.length; i++) {
            if (attendance[i][date] == null) {
                continue;
            }
            if (attendance[i][date].equalsIgnoreCase("A")) {
                System.out.println("- " + name[i] + " (ID: " + ID[i] + " )");
            }

        }
        System.out.println();
    }

    public static int indexSearch(int[] ID, int stID) {
        int index = -1;
        for (int i = 0; i < (ID.length); i++) {
            if (ID[i] == stID) {
                index = i;
            }
        }
        return index;
    }

}
