//1
//2 3
//4 5 6
//7 8 9 10

// In this question each row have columns equal to row number. i.e. 1st row have 1 column, 2 row have 2 column
// number of coins will be given we should return how many COMPLETE rows we can form using those coins.


public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(numberOfRows(20));
    }
    static int numberOfRows (int num) {
        if (num < 2) {
            return num;
        }

        int start = 2;
        int end = num - 1;
        int possibleAns = 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long coinsForMid = (long) mid * (mid + 1) / 2;
            if (num == coinsForMid) {
                return mid;
            } else if (num > coinsForMid) {
                possibleAns = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return possibleAns;
    }
}
