Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

class Solution {
    public void moveZeroes(int[] nums) {
        int now = 0;
        for (int num : nums)
            if (num != 0)
                nums[now ++] = num;
        while (now < nums.length)
            nums[now ++] = 0;
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != 0) {
                if (i == j) j ++;
                else {
                    nums[j ++] = nums[i];
                    nums[i] = 0;
                }
            }
    }
}
