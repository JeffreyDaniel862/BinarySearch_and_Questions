import java.util.Arrays;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40},
                {15,25,35,45},
                {17,27,37,47},
                {19,29,39,49}
        };
        int target = 7;
        System.out.println(Arrays.toString(search(arr, target)));
    }
    static int[] search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;

        while (row < matrix.length && col >= 0) {
            // target condition
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            }

            // shrinking search area
            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }

        }
        // if element not found return [-1, -1]
        return new int[]{-1,-1};
    }
}
