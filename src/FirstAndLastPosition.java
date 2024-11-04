import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {5,7,7,7,7,8,8,10};
        int[] ans = {-1, -1};
        ans[0] = search(arr, 1, true);
        if (ans[0] != -1) {
            ans[1] = search(arr, 1, false);
        }
        System.out.println(Arrays.toString(ans));
    }

    static int search (int[] arr, int target, boolean IsStart) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                ans = mid;
                if (IsStart) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
