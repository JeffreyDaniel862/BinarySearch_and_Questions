public class GuessNumber {
    public static void main(String[] args) {
        System.out.println(guessNumber(3));
    }
    static int guessNumber(int n) {
        int start = 1;
        while (start <= n) {
            int mid = start + (n - start) / 2;

            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                n = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    static int guess(int n) {
        int pick = 2;
        return Integer.compare(pick, n);
    }
}
