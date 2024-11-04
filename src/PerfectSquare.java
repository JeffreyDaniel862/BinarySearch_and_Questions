public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(perfectSquare(808201));
    }
    static boolean perfectSquare (int num) {

        if (num == 1) {
            return true;
        }

        int start = 2;
        int end = num / 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long guessedNumber = (long) mid * mid;
            if (num == guessedNumber) {
                return true;
            } else if (num < guessedNumber) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}