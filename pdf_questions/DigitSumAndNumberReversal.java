import java.util.Scanner;

/**
 * Problem 5: Digit Sum and Number Reversal
 * 
 * TASK:
 * Write a program that reads a positive integer and performs two operations:
 * it calculates and prints the sum of its digits, and it prints the number with
 * its digits reversed.
 * 
 * EXAMPLE:
 * Sample Input: 4721
 * Expected Output:
 * Sum of digits: 14
 * Reverse: 1274
 * 
 * HINT:
 * To extract digits, repeatedly use the modulo operator (%) by 10 to get the last
 * digit and integer division (/) by 10 to remove the last digit. Build the
 * reversed number by multiplying the current reversed number by 10 and adding the
 * extracted digit.
 */
public class DigitSumAndNumberReversal {

    public static void computeSumAndReverse(long n) {
        long temp = n;
        long sum = 0;
        long reversed = 0;

        while (temp > 0) {
            long digit = temp % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLong()) {
            long n = scanner.nextLong();
            computeSumAndReverse(n);
        } else {
            // Default demo run
            System.out.println("--- Demo Run: 4721 ---");
            computeSumAndReverse(4721);
        }
        scanner.close();
    }
}
