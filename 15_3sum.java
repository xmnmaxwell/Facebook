3Sum
/*
iven an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
O(n^2)
先排序， 然后开始第一层遍历，记为i，记住先去重，那么第二层遍历从i+1到末尾，
用双指针，前后夹击看能否找到target，如果找到了，要检查两个指针的前后是否重复，
复的话要加一

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums); // 先排序
        
        for (int i = 0; i <= nums.length - 3; i++){
            if( i > 0 && nums[i] == nums[i-1]) continue;// skip the duplicate number
            int j = i + 1, k = nums.length - 1, sum = -nums[i];
            while(j < k){
                if(nums[j] + nums[k] == sum) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                } else if (nums[j] + nums[k] < sum){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
