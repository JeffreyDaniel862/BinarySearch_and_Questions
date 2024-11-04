public class MinInRBS {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,4};
        int minIndex = findMinPivot(arr);
        System.out.println("The minimum element in the given array is " + arr[minIndex]);
    }

    static int findMinPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }

            if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid;
            }

            if (arr[end] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}
