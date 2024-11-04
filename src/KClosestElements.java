import java.util.Arrays;
import java.util.List;

public class KClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(findClosestElements(arr, 4, 3));
    }
    static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] result = new int[k];
        int start = 0, end = arr.length - k;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (x - arr[mid] > arr[mid + k] - x){
                start = mid + 1;
            } else{
                end = mid;
            }
        }
        System.arraycopy(arr, start, result, 0, k);
        return convertToList(result);
    }
    static List<Integer> convertToList(int[] arr) {
        return Arrays.stream(arr).boxed().toList();
    }
}
