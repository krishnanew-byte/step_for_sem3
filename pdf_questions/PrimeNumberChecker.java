import java.util.Scanner;

/**
 * Problem 6: Prime Number Checker
 * 
 * TASK:
 * Write a program that reads a number greater than 1 and determines whether it
 * is a prime number. A prime number is a natural number greater than 1 that has
 * no positive divisors other than 1 and itself. Print whether the number is prime
 * or not.
 * 
 * EXAMPLE:
 * Sample Input:
 * 29
 * 21
 * Expected Output:
 * 29 is prime
 * 21 is not prime
 * 
 * HINT:
 * To check for primality, iterate from 2 up to the square root of the number.
 * If any number in this range divides the input number evenly, it's not prime.
 */
public class PrimeNumberChecker {

    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void checkPrime(long n) {
        if (isPrime(n)) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLong()) {
            while (scanner.hasNextLong()) {
                long num = scanner.nextLong();
                checkPrime(num);
            }
        } else {
            // Default demo runs
            System.out.println("--- Demo Runs ---");
            checkPrime(29);
            checkPrime(21);
        }
        scanner.close();
    }
}
