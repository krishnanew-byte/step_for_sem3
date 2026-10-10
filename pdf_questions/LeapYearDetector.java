import java.util.Scanner;

/**
 * Problem 9: Leap Year Detector
 * 
 * TASK:
 * Write a program that reads a year and determines if it is a leap year.
 * A year is a leap year if it is divisible by 4, but not by 100, unless it is
 * also divisible by 400.
 * 
 * EXAMPLE:
 * Sample Input:
 * 2024
 * 1900
 * 2000
 * Expected Output:
 * Leap year
 * Not a leap year
 * Leap year
 * 
 * HINT:
 * Formulate the conditions using logical operators (AND, OR) to implement
 * the leap year rules. Check for divisibility by 4, 100, and 400 in the correct
 * logical sequence.
 */
public class LeapYearDetector {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void checkYear(int year) {
        if (isLeapYear(year)) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            while (scanner.hasNextInt()) {
                int year = scanner.nextInt();
                checkYear(year);
            }
        } else {
            // Default demo runs
            System.out.println("--- Demo Runs ---");
            checkYear(2024);
            checkYear(1900);
            checkYear(2000);
        }
        scanner.close();
    }
}
