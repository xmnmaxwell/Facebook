300. Longetst Increasing subsequence
最大的增子集的长度（上题是连续的这题可以不连续）
Input: [10,9,2,5,3,7,101,18] 最大的长度是2 3 7 101 所以是4
Output: 4 
O(n^2) O(n) space
// 10 9 2 5 3 7 3 18
// 1  1 1 2 2 3 2  4
public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int[] list = new int[nums.length]; //create an array to store the current longest increasing subsequence 
        for (int i = 0; i < nums.length; i++){
            list[i] = 1; // every element in the array set to 1.
            for (int j = 0; j < i; j++){ // we search every elements before the index i
                if (nums[j] < nums[i]){// 计算第i个元素之前升序的个数，动态规划的思想,比如7在7前所有比7小的list中的最大个数，最后加个1意思包括7
                    list[i] = Math.max(list[i], list[j] + 1);
                }
            }
        }
        
        int maxLen = 0; // define the result
        for (int num : list){
            maxLen = Math.max(maxLen, num);
        }
        return maxLen;
    }
**************************************************************************************************
O(nlogn)
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> rec = new ArrayList<Integer>();
        rec.add(Integer.MIN_VALUE);
        for (int num : nums) {
            int l = 0, r = rec.size();
            while (l < r - 1) {
                int mid = l + (r - l) / 2;
                if (rec.get(mid) < num) l = mid;
                else r = mid;
            }
            if (++ l < rec.size()) {
                if (num < rec.get(l))
                    rec.set(l, num);
            } else rec.add(num);
        }
        return rec.size() - 1;
    }
}
