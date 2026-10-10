import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 8: Duty Roster Rotation
 * 
 * TASK:
 * A hostel rotates its cleaning duty roster every week by moving each name k places
 * to the right; names that go past the end wrap around to the front.
 * Implement a function rotateRoster(names, k) that returns the roster after rotating
 * it to the right by k places. k may be larger than the number of names.
 * 
 * CONSTRAINTS:
 * • 1 <= length of names <= 100
 * • 0 <= k <= 10^9
 * 
 * EXAMPLES:
 * Sample 1:
 * names = [A, B, C, D, E], k = 2
 * Expected Output: [D, E, A, B, C]
 * 
 * Sample 2:
 * names = [A, B, C, D, E], k = 7
 * Expected Output: [D, E, A, B, C] // 7 places is the same as 2
 * 
 * COMPLEXITY REQUIREMENTS:
 * - Time Complexity: O(n), where n is the length of names.
 * - Space Complexity: O(n) to return a new rotated array (or O(1) auxiliary space if in-place).
 * 
 * WHY ROTATING ONE PLACE AT A TIME IS SLOW:
 * If we rotate one place at a time, each single shift takes O(n) operations. Doing this k times
 * results in O(k * n) total time complexity. When k is up to 10^9 and n is 100, the total operations
 * would be approximately 10^11, leading to severe timeout (TLE).
 * Using k % n simplifies any k into an effective shift strictly less than n (effK < n),
 * allowing an optimal O(n) solution.
 */
public class DutyRosterRotation {

    /**
     * Rotates names array to the right by k positions in O(n) time.
     * 
     * @param names array of roster names
     * @param k number of places to rotate right
     * @return rotated array of names
     */
    public static String[] rotateRoster(String[] names, int k) {
        if (names == null || names.length == 0) {
            return new String[0];
        }

        int n = names.length;
        int effK = (int) (k % n);
        if (effK == 0) {
            return names.clone();
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + effK) % n] = names[i];
        }

        return rotated;
    }

    /**
     * Helper to reverse a subarray in-place.
     */
    private static void reverse(String[] arr, int start, int end) {
        while (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Optional In-place rotation using the 3-reverse technique (O(1) auxiliary space).
     */
    public static void rotateRosterInPlace(String[] names, int k) {
        if (names == null || names.length == 0) return;
        int n = names.length;
        int effK = k % n;
        if (effK == 0) return;

        // 1. Reverse entire array
        reverse(names, 0, n - 1);
        // 2. Reverse first effK elements
        reverse(names, 0, effK - 1);
        // 3. Reverse remaining n - effK elements
        reverse(names, effK, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            // Handle [A, B, C, D, E] or space-separated names
            line = line.replace("[", "").replace("]", "");
            String[] tokens = line.split("[,\\s]+");
            List<String> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    list.add(token);
                }
            }

            int k = 0;
            if (scanner.hasNextInt()) {
                k = scanner.nextInt();
            }

            String[] names = list.toArray(new String[0]);
            String[] result = rotateRoster(names, k);
            System.out.println(Arrays.toString(result));
        } else {
            // Default demo runs
            System.out.println("--- Demo Runs ---");
            String[] sample1 = {"A", "B", "C", "D", "E"};
            System.out.println("Sample 1 (k=2): " + Arrays.toString(rotateRoster(sample1, 2)));

            String[] sample2 = {"A", "B", "C", "D", "E"};
            System.out.println("Sample 2 (k=7): " + Arrays.toString(rotateRoster(sample2, 7)));
        }

        scanner.close();
    }
}
