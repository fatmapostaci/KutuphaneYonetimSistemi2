package utilities;

import java.util.Scanner;

/**
 * Utility class for handling user input with exception handling.
 * <p>
 * Provides methods for safely receiving and validating integer and string inputs
 * to prevent runtime errors caused by invalid user input.
 */
public class TryCatch {

    /** Scanner instance for reading user input. */
    public static Scanner scan = new Scanner(System.in);

    /**
     * Handles and validates integer input from the user.
     * <p>
     * Continuously prompts the user until a valid integer is entered.
     * If the input is invalid, an error message is displayed, and the user is prompted again.
     *
     * @return a valid integer entered by the user
     */
    public static int intInput() {
        int giris = 0;
        boolean flag = true;
        boolean flag2 = false;
        do {
            giris = 0;
            try {
                if (flag2) {
                    scan.nextLine(); // Clear invalid input
                }
                flag2 = true;
                giris = scan.nextInt();
                scan.nextLine(); // Consume the remaining newline
                flag = false;
                flag2 = false;
            } catch (Exception e) {
                System.out.println("Please enter a valid input!");
            }
        } while (flag);
        return giris;
    }

    /**
     * Handles and validates string input from the user.
     * <p>
     * Continuously prompts the user until a valid string is entered.
     * If the input is invalid, an error message is displayed, and the user is prompted again.
     *
     * @return a valid string entered by the user
     */
    public static String stringInput() {
        String giris = "";
        boolean flag = true;
        do {
            giris = "";
            try {
                giris = scan.nextLine(); // Read the next token
               // scan.nextLine(); // Consume the remaining newline
                flag = false;
            } catch (Exception e) {
                System.out.println("Please enter a valid input!");
            }
        } while (flag);
        return giris;
    }
}