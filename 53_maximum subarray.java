53. maximum subarray // subarray 一般意思就是连续的
O(n)
Input: [-2,1,-3,4,-1,2,1,-5,4],连续子集总和最大值
Output: 6
 //    -2  1 -3 4 -1 2 1 -5 4
 //sum -2 -1 -4 0 -1 1 2 -3 1
 //max  
 //min -2 -2 -4 -4 -4 -4 -4 -4
 public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
        return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;// why we set 0, because sum all > 0, the max sum is all
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];// calculate prefix sum
            max = Math.max(max, sum - minSum);// update the max and sum-minSum
            minSum = Math.min(minSum, sum);// update minSum
        }
        return max; 
    }
