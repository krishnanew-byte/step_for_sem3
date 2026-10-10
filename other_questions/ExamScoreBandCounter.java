import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 4: Exam Score Band Counter
 * 
 * TASK:
 * A university stores the marks of all students in an exam as an array sorted in
 * ascending order; marks can repeat. Faculty members frequently ask how many students
 * scored within a band [low, high], inclusive of both ends.
 * Implement a function countInBand(scores, low, high) that returns the number of
 * scores s such that low <= s <= high. The array is large (up to 10^6) and queried
 * very often, so your solution must not scan the scores one by one.
 * 
 * CONSTRAINTS:
 * • 1 <= length of scores <= 10^6
 * • scores is sorted in ascending order
 * • 0 <= low <= high <= 100
 * 
 * EXAMPLES:
 * Sample 1:
 * scores = [35, 42, 42, 50, 58, 58, 58, 63, 71, 88], low = 42, high = 58
 * Expected Output: 6
 * 
 * Sample 2:
 * scores = [35, 42, 42, 50, 58, 58, 58, 63, 71, 88], low = 90, high = 100
 * Expected Output: 0
 * 
 * COMPLEXITY REQUIREMENTS:
 * - Linear scan:
 *   Time Complexity: O(n) per query.
 *   Space Complexity: O(1).
 *   For 10^6 scores and frequent queries (e.g., 10^5 queries), this would take 10^11 ops, causing severe timeouts.
 * - Final solution (Modified Binary Search):
 *   Time Complexity: O(log n) per query.
 *   Space Complexity: O(1) auxiliary space.
 * 
 * HOW DUPLICATES AT EDGES AFFECT THE SEARCH:
 * A standard binary search terminates upon encountering any element matching the target.
 * However, because values duplicate:
 * 1. For the lower bound `low`: We cannot stop at any occurrence of `low`. We must find the
 *    *first* (leftmost) index where `score >= low`. Even if `scores[mid] == low`, we must continue
 *    searching the left half (`right = mid - 1`).
 * 2. For the upper bound `high`: Multiple occurrences of `high` may exist at the right edge.
 *    We must locate the *first* index where `score > high`. Even if `scores[mid] == high`, we must
 *    continue searching the right half (`left = mid + 1`).
 * The count of elements in [low, high] is then simply `upperBoundIndex - lowerBoundIndex`.
 */
public class ExamScoreBandCounter {

    /**
     * Finds the first index i where scores[i] >= target (Lower Bound).
     */
    public static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length - 1;
        int ans = scores.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                ans = mid;
                right = mid - 1; // Look for earlier occurrences to the left
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Finds the first index i where scores[i] > target (Upper Bound).
     */
    public static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length - 1;
        int ans = scores.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                ans = mid;
                right = mid - 1; // Look for earlier occurrences to the left
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Returns the count of scores in [low, high] in O(log n) time.
     */
    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int lower = lowerBound(scores, low);
        int upper = upperBound(scores, high);

        return Math.max(0, upper - lower);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            // Supports [35, 42, 42, 50, ...] or comma/space delimited
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

            int low = 0, high = 100;
            if (scanner.hasNextInt()) low = scanner.nextInt();
            if (scanner.hasNextInt()) high = scanner.nextInt();

            int[] scores = list.stream().mapToInt(i -> i).toArray();
            int count = countInBand(scores, low, high);
            System.out.println(count);
        } else {
            // Default demo runs
            System.out.println("--- Demo Runs ---");
            int[] demoScores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
            System.out.println("Sample 1 (low=42, high=58): " + countInBand(demoScores, 42, 58));
            System.out.println("Sample 2 (low=90, high=100): " + countInBand(demoScores, 90, 100));
        }

        scanner.close();
    }
}
