3Sum
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
***************************************************************************3sum closest
class Solution {
    // 先排序，同3sum，先进行第一轮遍历i，定义另外两个元素i+1，nums.length-1，计算三个的和，定义一个最小距离mingap，不断计算sum和target的差gap，并和mingap比较，小的话把gap赋给mingap，结果就是那个和。O(n^2)
    public int threeSumClosest(int[] nums, int target) {
         if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            int j = i + 1, k = nums.length - 1;
            while (j < k){
               int sum = nums[i] + nums[j] + nums[k];
               int gap = Math.abs(sum - target); 
                if (gap < minGap){
                    minGap = gap;
                    res = sum;
                }
                if (sum > target){
                    k--;
                } else if (sum < target){
                    j++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }
     
}
