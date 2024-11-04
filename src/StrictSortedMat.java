import java.util.Arrays;

public class StrictSortedMat {
    public static void main(String[] args) {
        int[][] grid = {
                {1},
                {3},
                {5}
        };
        System.out.println(Arrays.toString(reduceRow(grid, 0)));
    }
    static int[] reduceRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;

        // run loop until matrix is shrunk to length of 2 or element is found
        while (start < (end - 1)) {
            int midRow = start + (end - start) / 2; // finding middle row of provided matrix
            int midCol = (matrix[midRow].length - 1) / 2;
            if (matrix[midRow][midCol] == target) {
                return new int[]{midRow, midCol};
            } else if (matrix[midRow][midCol] > target) {
                end = midRow;
            } else {
                start = midRow;
            }
        }

        // if target is not found in the above loop. Target must be in anyone of this two rows.
        if (matrix[start][matrix[start].length - 1] >= target) {
            return binarySearch(matrix, start, 0, matrix[start].length - 1, target);
        } else {
            return binarySearch(matrix, end, 0, matrix[end].length - 1, target);
        }

    }
    static int[] binarySearch (int[][] matrix, int row, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            } else if (matrix[row][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
