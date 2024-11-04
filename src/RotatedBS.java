public class RotatedBS {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 4;
        int pivot = findPivot(arr);
        int ans = -1;
        if (pivot == -1) {
            ans = binarySearch(arr, target, 0, arr.length - 1);
        }

        if (arr[pivot] == target) {
            ans = pivot;
        } else if (arr[0] <= target ) {
            ans = binarySearch(arr, target, 0, pivot - 1);
        } else {
            ans = binarySearch(arr, target, pivot + 1, arr.length - 1);
        }

        System.out.println(ans);
    }
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // if number after middle element is less than middle then middle is the pivot
            // [4,5,6,7,0,1,2,3]
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // if number before the middle element is greater than middle then the number before middle is the pivot
            // [5,6,7,1,2,3,4]
            if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            }

            // if the middle element is lesser than the start element then pivot should anywhere between the start and number preceding the middle
            // [5,6,0,1,2,3,4] here 5 is start 1 is mid, 6 is the pivot
            if(arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            // if middle element is greater than start then we can say pivot is between successor of middle element and the end of the array
            // [4,5,6,7,8,1,2,3] here 4 is start 7 is mid, pivot is 8
        }

        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
