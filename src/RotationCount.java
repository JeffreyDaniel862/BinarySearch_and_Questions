public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {15, 18, 3, 6, 12};
        System.out.println(rotationCount(arr, true));
        System.out.println(rotationCount(arr, false));
    }

    static int rotationCount(int[] arr, boolean isRight) {
        int pivot = findPivot(arr);
        if (pivot == -1) {
            return 0;
        }
        if (isRight) {
            return (arr.length - 1) - pivot;
        }
        return pivot + 1;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // middle element

            // maximum element (pivot)
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            }

            // finding sub-array to search the pivot element
            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
