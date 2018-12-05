Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

class Solution {
    public void moveZeroes(int[] nums) {
        int now = 0;
        for (int num : nums)
            if (num != 0)
                nums[now ++] = num;// search array, if the num is not 0,put the element in the array
        while (now < nums.length)
            nums[now ++] = 0;//if now is less, assign the rest element 0.
    }
}
// 1 2 3 0 2 0 //1 2 3 2 0
读取最少
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != 0) {//一开始没有0的时候，i j同步，位置不变，但凡有0了，i就会加1，j不变，
                if (i == j) j ++;
                else {
                    nums[j ++] = nums[i];//这个时候让落后的j = num[i], 然后把0放在number[i]里
                    nums[i] = 0;
                }
            }
    }
}
