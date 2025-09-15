package utils;

import java.util.Scanner;

public class SafeInputReader {
    public static int intInput(String msg, int min, int max) {
        Scanner input = new Scanner(System.in);
        int number = 0;
        boolean valid = false;
        System.out.print(msg);

        while (!valid) {
            if (input.hasNextInt()) {
                number = input.nextInt();
                if (min <= number && number <= max) {
                    valid = true;
                } else {
                    System.out.println("Invalid choice. Number must be between " + min + " and " + max + "!");
                    System.out.print(msg);
                }
            } else {
                System.out.println("Required Integer");
                System.out.print(msg);
                input.next();
            }
        }
        return number;
    }
    public static double floatInput(String msg, double  min, double  max) {
        Scanner input = new Scanner(System.in);
        double number = 0;
        boolean valid = false;
        System.out.print(msg);

        while (!valid) {
            if (input.hasNextDouble() || input.hasNextFloat() ) {
                number = input.nextDouble();
                if (min <= number && number <= max) {
                    valid = true;
                } else {
                    System.out.println("Invalid choice. Number must be between " + min + " and " + max + "!");
                    System.out.print(msg);
                }
            } else {
                System.out.println("Required Float/Double");
                System.out.print(msg);
                input.next();
            }
        }
        return number;
    }


    public static String strInput(String msg) {
        Scanner input = new Scanner(System.in);
        String userInput = null;
        boolean valid = false;

        while (!valid) {
            System.out.print(msg);
            userInput = input.nextLine();
            if (userInput != null) {
                if (!(userInput.trim().isEmpty())) {
                    break;
                } else {
                    System.out.println("Input not be Empty whiteSpaces !");
                }

            } else {
                System.out.println("You must need Enter data !");
            }
        }
        return userInput;
    }

    

}
