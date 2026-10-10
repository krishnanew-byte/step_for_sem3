import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 7: Second-Best Score
 * 
 * TASK:
 * A quiz app stores the scores of all players in an array. Prizes go to the top two
 * different scores, so the app needs the second-highest distinct score. If every player
 * has the same score, there is no second-highest score.
 * Implement a function secondHighest(scores) that returns the second-highest distinct
 * score, or -1 if it does not exist.
 * 
 * CONSTRAINTS:
 * • 1 <= length of scores <= 1000
 * • 0 <= scores[i] <= 100
 * • Do not sort the array
 * 
 * EXAMPLES:
 * Sample 1:
 * scores = [45, 78, 92, 78, 60]
 * Expected Output: 78
 * 
 * Sample 2:
 * scores = [50, 50, 50]
 * Expected Output: -1
 * 
 * COMPLEXITY:
 * - Single Pass (Our Solution):
 *   Time Complexity: O(n) visiting each score exactly once.
 *   Space Complexity: O(1) storing two scalar variables (highest and second).
 * 
 * - Comparison with Sorting:
 *   Sorting takes O(n log n) time and O(n) or O(log n) extra space.
 *   Furthermore, the problem constraint explicitly forbids sorting the array.
 *   A single-pass linear scan is both asymptotically superior and adheres to all constraints.
 */
public class SecondBestScore {

    /**
     * Finds the second-highest distinct score in O(n) time and O(1) space without sorting.
     * 
     * @param scores array of player scores
     * @return second highest distinct score, or -1 if none exists
     */
    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                // New distinct highest found: demote previous highest to second
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                // Score is strictly between highest and second
                second = score;
            }
            // If score == highest or score <= second, do nothing (skip duplicates)
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
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
            int[] scores = list.stream().mapToInt(i -> i).toArray();
            System.out.println(secondHighest(scores));
        } else {
            // Default demo runs
            System.out.println("--- Demo Runs ---");
            int[] sample1 = {45, 78, 92, 78, 60};
            System.out.println("Sample 1: " + secondHighest(sample1));

            int[] sample2 = {50, 50, 50};
            System.out.println("Sample 2: " + secondHighest(sample2));
        }

        scanner.close();
    }
}
