import java.util.Scanner;

/**
 * Problem 10: Busiest Bus Row
 * 
 * TASK:
 * A college bus records how many students sit in each seat as a 2D grid, where each row
 * is one row of seats. The transport office wants to know which row carries the most students.
 * Implement a function busiestRow(grid) that returns the index of the row with the largest
 * total and that total. If two rows tie, return the one with the smaller index.
 * 
 * CONSTRAINTS:
 * • 1 <= rows, columns <= 10
 * • 0 <= grid[i][j] <= 3
 * 
 * EXAMPLE:
 * grid = [[2, 0, 1],
 *         [3, 3, 1],
 *         [1, 1, 1]]
 * Expected Output: Row 1, Total 7
 * 
 * COMPLEXITY:
 * - Time Complexity: O(r * c), where r is the number of rows and c is the number of columns.
 *   Each element in the grid is visited exactly once.
 * - Space Complexity: O(1) additional space.
 */
public class BusiestBusRow {

    /**
     * Finds the row with the largest sum of seated students.
     * In case of a tie, the row with the smaller index is returned.
     * 
     * @param grid 2D array representing seat occupancy
     * @return int array where index 0 is bestRow and index 1 is maxTotal
     */
    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int maxRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int rowTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                rowTotal += grid[i][j];
            }

            // Strictly greater ensures the smaller row index is preserved on ties
            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                maxRow = i;
            }
        }

        return new int[]{maxRow, maxTotal};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int[][] grid = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            int[] result = busiestRow(grid);
            System.out.println("Row " + result[0] + ", Total " + result[1]);
        } else {
            // Default demo run
            System.out.println("--- Demo Run ---");
            int[][] sampleGrid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
            };
            int[] result = busiestRow(sampleGrid);
            System.out.println("Row " + result[0] + ", Total " + result[1]);
        }

        scanner.close();
    }
}
