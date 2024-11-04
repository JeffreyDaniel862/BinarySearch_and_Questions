public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,11,23,45,67,89,100};
        int target = 45;
        System.out.println(binarySearchBoolean(arr, target));
    }
    static boolean binarySearchBoolean (int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] == target) {
                return true;
            } else if (arr[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return false;
    }
}