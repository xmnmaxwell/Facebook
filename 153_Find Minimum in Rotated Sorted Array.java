Find the minimum element.
You may assume no duplicate exists in the array.
Example 1:
Input: [3,4,5,1,2] 
Output: 1
***********************************************************************
class Solution {
    // first postion 比前一个小，二分法
    // 45678123,中点和end进行比较！！！比end大，范围所小到mid，end
    // 78123456,中点和end进行比较！！！比end小，范围缩小到start，mid
    //最后在节点start和end缩小到前后两个时候，比较前后的大小，谁小输出结果就是谁
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[end]){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        else return nums[end];
        
    }
}
