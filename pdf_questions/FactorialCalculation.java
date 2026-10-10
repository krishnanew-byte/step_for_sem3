import java.math.BigInteger;
import java.util.Scanner;

/**
 * Problem 7: Factorial Calculation
 * 
 * TASK:
 * Write a program that reads a non-negative integer and calculates its
 * factorial. The factorial of a non-negative integer 'n', denoted by 'n!', is
 * the product of all positive integers less than or equal to 'n'. The factorial
 * of 0 is defined as 1.
 * 
 * EXAMPLE:
 * Sample Input:
 * 5
 * 0
 * Expected Output:
 * 120
 * 1
 * 
 * HINT:
 * Use a loop to multiply numbers from 1 up to the input number. Handle the
 * special case for 0 factorial.
 */
public class FactorialCalculation {

    public static BigInteger calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            while (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                System.out.println(calculateFactorial(n));
            }
        } else {
            // Default demo runs
            System.out.println("--- Demo Runs ---");
            System.out.println(calculateFactorial(5));
            System.out.println(calculateFactorial(0));
        }
        scanner.close();
    }
}
