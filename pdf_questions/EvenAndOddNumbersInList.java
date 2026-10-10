import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 3: Even and Odd Numbers in a List
 * 
 * TASK:
 * Given a list of integers, write a program to count how many numbers in the
 * list are even and how many are odd. Print the counts for both categories.
 * 
 * EXAMPLE:
 * Sample Input: [3, 8, 12, 5, 7, 10]
 * Expected Output:
 * Even: 3
 * Odd: 3
 * 
 * HINT:
 * Iterate through each number in the list. Use the modulo operator (%) to
 * determine if a number is even or odd.
 */
public class EvenAndOddNumbersInList {

    public static void countEvenAndOdd(int[] numbers) {
        int evenCount = 0;
        int oddCount = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            // Handle format like [3, 8, 12, 5, 7, 10] or space/comma separated numbers
            line = line.replace("[", "").replace("]", "");
            String[] tokens = line.split("[,\\s]+");
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    try {
                        list.add(Integer.parseInt(token));
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }

        if (!list.isEmpty()) {
            int[] arr = list.stream().mapToInt(i -> i).toArray();
            countEvenAndOdd(arr);
        } else {
            // Default demo run
            System.out.println("--- Demo Run: [3, 8, 12, 5, 7, 10] ---");
            countEvenAndOdd(new int[]{3, 8, 12, 5, 7, 10});
        }

        scanner.close();
    }
}
