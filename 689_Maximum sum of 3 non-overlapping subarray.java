In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sum = 0;
        int[] max = new int[3];
        int[][] rec = new int[3][3];
        
        int[] sumk = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            sum += i - k >= 0 ? nums[i] - nums[i - k] : nums[i];
            sumk[i] = sum;
            
            if (i >= 3 * k - 1) {
                if (sumk[i - 2 * k] > max[0]) {
                    max[0] = sumk[i - 2 * k];
                    rec[0] = new int[]{i - 3 * k + 1, 0, 0};
                }
                if (sumk[i - k] + max[0] > max[1]) {
                    max[1] = sumk[i - k] + max[0];
                    rec[1] = new int[]{rec[0][0], i - 2 * k + 1, 0};
                }
                if (sumk[i] + max[1] > max[2]) {
                    max[2] = sumk[i] + max[1];
                    rec[2] = new int[]{rec[1][0], rec[1][1], i - k + 1};
                }
            }
        }
        return rec[2];
    }
}
