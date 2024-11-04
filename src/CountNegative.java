public class CountNegative {
    public static void main(String[] args) {
        int[][] matrix = {
                {4,  3,  2, -1},
                {3,  2,  1, -1},
                {1,  1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(findAndCountNeg(matrix));
    }
    static int findAndCountNeg(int[][] matrix) {
        int row = 0;
        int col = matrix[row].length - 1;
        int count = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < 0) {
                count += matrix.length - row;
                col--;
            } else {
                row++;
            }
        }
        return count;
    }
}
