import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 4: In-Place Array Reversal
 * 
 * TASK:
 * Write a program that reverses the order of token numbers stored in a list.
 * The reversal must be done 'in-place', meaning you should modify the original
 * list directly without creating a second list.
 * 
 * EXAMPLE:
 * Sample Input: [11, 22, 33, 44]
 * Expected Output: [44, 33, 22, 11]
 * 
 * HINT:
 * Use two pointers, one starting from the beginning and one from the end of the
 * array. Swap the elements at these pointers and move them towards the center
 * until they meet or cross.
 */
public class InPlaceArrayReversal {

    /**
     * Reverses the given array in-place using two pointers.
     */
    public static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap elements at left and right
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            // Handle [11, 22, 33, 44] or space/comma separated numbers
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
            reverseInPlace(arr);
            System.out.println(Arrays.toString(arr));
        } else {
            // Default demo run
            System.out.println("--- Demo Run: [11, 22, 33, 44] ---");
            int[] demo = {11, 22, 33, 44};
            reverseInPlace(demo);
            System.out.println(Arrays.toString(demo));
        }

        scanner.close();
    }
}
