public class KthInteger {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(searchKthMissingElement(arr, k));
    }
    static int searchKthMissingElement (int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int missing = noOfMissing(arr[mid], mid + 1);

            if (missing < k) start = mid + 1;
            else end = mid - 1;
        }

        if (end == -1) return k;
        else return arr[end] + k - noOfMissing(arr[end], end + 1);

    }
    static int noOfMissing (int actualValue, int expectedValue) {
        return actualValue - expectedValue;
    }
}
