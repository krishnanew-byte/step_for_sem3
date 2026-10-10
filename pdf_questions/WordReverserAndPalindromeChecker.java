import java.util.Scanner;

/**
 * Problem 2: Word Reverser and Palindrome Checker
 * 
 * TASK:
 * Create a program that reads a word, reverses it using a mutable text builder
 * (like StringBuilder in Java), and then prints the reversed word. Additionally,
 * determine and print whether the original word reads the same forwards and
 * backwards (is a palindrome).
 * 
 * EXAMPLE:
 * Sample Input:
 * level
 * java
 * Expected Output:
 * level - palindrome
 * avaj - not a palindrome
 * 
 * HINT:
 * Use a mutable string class to build the reversed word. Compare the original
 * string with the reversed string to check for palindrome property.
 */
public class WordReverserAndPalindromeChecker {

    public static void processWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        boolean isPalindrome = word.equalsIgnoreCase(reversed);
        if (isPalindrome) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                processWord(word);
            }
        } else {
            // Default demonstration runs
            System.out.println("--- Demo Runs ---");
            processWord("level");
            processWord("java");
        }
        scanner.close();
    }
}
