public class NearNumbers {
    public static void main(String[] args) {
        int[] arr = {1,4,6,8,10,11,17,18,20};
        int target = 15;
        System.out.println(ceil(arr, target));
        System.out.println(floor(arr, target));
    }

    static int ceil(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        if (target > arr[arr.length - 1]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        if (target < arr[0]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}
