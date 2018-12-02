325. maximum size subarray sum equals k
O(n)
Input: nums = [1, -1, 5, -2, 3], k = 3 总和为 k 的子数列最大长度
Output: 4 
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
// prefix sum: (abc)-> sum-k  (def)-> k (abcdef)-> sum 
public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // create a map to store the prefix sum and the start index
        int maxLen = 0;
        int sum = 0;
        map.put(0,-1);// key = 0, for special case prefix sum == k, -1 we can get length 1 if nums[0] == k
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];// prefix sum
            if (map.containsKey(sum-k)){
                maxLen = Math.max(maxLen, i - map.get(sum-k));
                // update the maxLen with tracking 
            }
            if (!map.containsKey(sum))
            map.put(sum, i);
            // if map did not contain sum, sum appear first time add sum and first index 
        }
        return maxLen;
    }
// 不用map， 用指针做 O(n^2)
     public int subarrySum(int[] nums, int k) {
        if (k <= 0) return 0;
        int j = 0, sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            while (sum > k) sum -= nums[j ++];
            if (sum == k) ans ++;
        }
        return ans;
    }
