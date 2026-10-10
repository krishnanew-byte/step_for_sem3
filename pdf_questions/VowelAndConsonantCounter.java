import java.util.Scanner;

/**
 * Problem 1: Vowel and Consonant Counter
 * 
 * TASK:
 * Write a program that reads a single word and then counts and prints the total
 * number of vowels and consonants in that word. Assume the input word contains
 * only alphabetic characters (case-insensitive).
 * 
 * EXAMPLE:
 * Sample Input: Programming
 * Expected Output:
 * Vowels: 3
 * Consonants: 8
 */
public class VowelAndConsonantCounter {

    public static void countVowelsAndConsonants(String word) {
        int vowels = 0;
        int consonants = 0;

        String lowerWord = word.toLowerCase();
        for (int i = 0; i < lowerWord.length(); i++) {
            char ch = lowerWord.charAt(i);
            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String word = scanner.next();
            countVowelsAndConsonants(word);
        } else {
            // Default demonstration if no interactive input is provided
            System.out.println("--- Demo Run: Programming ---");
            countVowelsAndConsonants("Programming");
        }
        scanner.close();
    }
}
