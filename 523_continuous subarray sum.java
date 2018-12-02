523. continuous subarray sum
O(n), O(k)
Input: [23, 2, 6, 4, 7],  k=6 是否有连续的子数组加起来是k的倍数
Output: True
Explanation: Because [23, 2, 6, 4, 7] 
is an continuous subarray of size 5 and sums up to 42.
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
这道题思想是还是取prefix sum，但是放入map的是除以k之后的余数和下标，只有当两组sum的余数相同时两者之间的元素
和才是k的倍数，并且此时还要满足两个下标之差大于1. map初始化为0，-1 因为防止比如6,6,5 k是6，其实前两个
已经是六的倍数了没有初始化，这个特例会被跳过。
O(n) time with O(k) space 
 public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // create a map to store the prefix sum%k (that is mod) and its index
        map.put(0, -1);// for prefix sum[i] == k, -1 is because the size is at least two
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];// calculate prefix sum
            if (k != 0) 
            sum = sum % k;// we get mod
            Integer prev = map.get(sum);
            // we search in the map if this mod has been in the map
            // prefixsum[i] = ak + mod, prefixsum[j] = bk + mod
            //prefixsum[j] - prefixsum[i] = (b-a)k
            if (prev != null) {
                if (i - prev > 1) return true;
            } else {
              map.put(sum, i);   //实际是放入了sum除以k的取余，加坐标
            }
        }
        return false;
    }
