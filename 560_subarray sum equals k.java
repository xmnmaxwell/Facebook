O(n)
Input:nums = [1,1,1], k = 2 子数列和为 k 的个数 11, 11
Output: 2

这道题解法是建立一个哈希表，存每i个元素的和sum，value是sum的次数，这样如果sum-k在哈希表
里说明一定存在连续元素之和为k，数组的个数就是sum的次数。但需要先放进去一个0，这样如果sum=k，
就不会漏掉。 如果sum-k包含在哈希表里，个数需要加上哈希表里sum出现的次数。
 public int subarraySum(int[] nums, int k) {
        int count = 0;//count of the subarray to meet this requiement
        int sum = 0;//get prefix sum
        Map<Integer, Integer> map = new HashMap<>(); // map to store the prefix sum and the number of subarrays which have same prefix sum
        map.put(0,1);// for prefix == sum, value is 1.
        for (int i = 0; i < nums.length; i++){
            sum += nums[i]; // calculate prefix sum
            
            if (map.containsKey(sum-k)){
                count += map.get(sum-k); 
                //if contains sum-k, add the number 
            } 
            
            if (map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            } else {
                map.put(sum,1);
            }
        }
        return count;
    }
