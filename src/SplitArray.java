public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int targetSplit = 2;
        System.out.println(splitArray(arr, targetSplit));
    }
    static int splitArray(int[] nums, int k) {
        // variables to hold the condition for binary search
        int start = 0;
        int end = 0;

        // loop to find the start and end value;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // find the maximum value in the array
            end += nums[i];  // find the sum of the entire array
        }

        // given array = [7,2,5,10,8], (no.of sub-array) k
        // possible minimized largest sum of splits = [start,.......,end] <-- possible-ans-array we created to find the best possible ans
        // that satisfy the K splits and minimized largest sum. USING BINARY SEARCH
        while (start < end) {

            int mid = start + (end - start) / 2; // possible minimized largest sum of the sub-array

            int sum = 0; // sum is the variable to hold the sum of sub-array
            int pieces = 1; // number of sub-arrays

            for (int num : nums) {
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            // check whether the number of sub-array (pieces) that we created with the possible minimized largest sum is exceeding K
            // the allowed splits in the  question
            if (pieces > k) {
                // if pieces exceeds K then we have to increase the possible minimized largest sum to spilt the array to K sub-arrays
                start = mid + 1;
            } else {
                // shrinking the possible-ans-array to get the minimized largest sum with K splits
                // see the line before while loop to know about possible-ans-array
                end = mid;
            }
        }
        return start;
    }
}
