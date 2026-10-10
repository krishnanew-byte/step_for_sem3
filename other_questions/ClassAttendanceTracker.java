import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 6: Class Attendance Tracker
 * 
 * TASK:
 * A teacher records attendance for one student as an array of 1s (present) and 0s (absent),
 * one value per day. The teacher wants to know how many days the student was present and
 * the longest run of days the student attended without a break.
 * Implement a function attendanceSummary(days) that returns the number of present days
 * and the length of the longest unbroken run of present days.
 * 
 * CONSTRAINTS:
 * • 1 <= length of days <= 100
 * • Each value is 0 or 1
 * 
 * EXAMPLES:
 * Sample 1:
 * days = [1, 1, 0, 1, 1, 1, 0, 1]
 * Expected Output: Present: 6, Longest streak: 3
 * 
 * Sample 2:
 * days = [0, 0, 0]
 * Expected Output: Present: 0, Longest streak: 0
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) in a single pass over the array of days.
 * - Space Complexity: O(1) auxiliary space.
 * Both answers are computed simultaneously in a single pass.
 */
public class ClassAttendanceTracker {

    /**
     * Computes the total present days and longest consecutive streak in a single pass.
     * 
     * @param days array of 1s (present) and 0s (absent)
     * @return int array [totalPresent, longestStreak]
     */
    public static int[] attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return new int[]{0, 0};
        }

        int totalPresent = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{totalPresent, longestStreak};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            // Supports [1, 1, 0, 1, 1, 1, 0, 1] or raw space/comma delimited values
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
            int[] summary = attendanceSummary(arr);
            System.out.println("Present: " + summary[0] + ", Longest streak: " + summary[1]);
        } else {
            // Default demo runs
            System.out.println("--- Demo Runs ---");
            int[] sample1 = {1, 1, 0, 1, 1, 1, 0, 1};
            int[] res1 = attendanceSummary(sample1);
            System.out.println("Sample 1: Present: " + res1[0] + ", Longest streak: " + res1[1]);

            int[] sample2 = {0, 0, 0};
            int[] res2 = attendanceSummary(sample2);
            System.out.println("Sample 2: Present: " + res2[0] + ", Longest streak: " + res2[1]);
        }

        scanner.close();
    }
}
