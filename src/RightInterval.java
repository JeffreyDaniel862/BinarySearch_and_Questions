import java.util.Arrays;

public class RightInterval {
    public static void main(String[] args) {
        int[][] grid = {
                {1,4},
                {2,3},
                {3,4}
        };
        System.out.println(Arrays.toString(findRIS(grid)));
    }
    static int[] findRIS (int[][] matrix) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = findRI(matrix, i);
        }
        return result;
    }
    static int findRI(int[][] matrix, int row) {

        int col = matrix[row].length - 1;

        // following three variable is used to minimize the search space start -> upper bound , end -> lower bound
        int start = 0;
        int end = matrix.length - 1;

        boolean isAsc = matrix[0][0] < matrix[matrix.length - 1][0]; // isAsc value to determine the direction
        // of shrinking search space

//        [ 1 4
//          2 3
//          3 4 ]
//      the element 4 doesn't find any right interval in this ascending row of column 0. so directly returning -1
        if (isAsc) {
            if (matrix[row][col] > matrix[matrix.length - 1][0]) {
                return -1;
            }
        }

        while (start <= end) {
            int mid = start + (end - start) / 2; // mid used to find ans / further to reduce the search space
            if (matrix[row][col] == matrix[mid][0]) {
                return mid;
            }

            // reducing search space using order (ASC or DESC)
            if (isAsc) {
                if (matrix[row][col] > matrix[mid][0]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (matrix[row][col] > matrix[mid][0]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return isAsc ? start : end; // if we don't able to find the right interval start with previous ending try to find the least great number.
    }
}
