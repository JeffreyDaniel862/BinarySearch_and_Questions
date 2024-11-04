public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int target = 1;
        System.out.println(OABS(arr, target));
    }

    static boolean OABS (int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (arr[middle] == target) {
                return true;
            }

            if (isAsc) {
                if (arr[middle] < target) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                if (arr[middle] > target) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }

        }
        return false;
    }

}
