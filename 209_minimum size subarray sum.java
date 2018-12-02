209. manimum size subarray sum 
O(n)
Input: s = 7, nums = [2,3,1,2,4,3] 找最短连续子数组的总和>= s, （43）
Output: 2
public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0, j = 0；// define two pointers 
        int sum = 0, min = Integer.MAX_VALUE;// min size
        while (j < nums.length) {
               sum += nums[j++];// calculate the sum
    
            while (sum >= s) { 
            //once the sum >= s, update min, start minus nums[i] to see if still >=s
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
            return min == Integer.MAX_VALUE ? 0 : min;
}
