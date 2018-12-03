Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

two pass
public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) count0++;
            else if (nums[i] == 1) count1++;
            else count2++;
        }
        
        for (int i = 0; i < nums.length; i++){
            if (i <count0) nums[i] = 0;
            else if (i >= count0 && i < count1 + count0) nums[i] = 1;
            else nums[i] = 2;
        }
}

*************************************************************************************
one pass
 public void sortColors(int[] nums) {
         // 1-pass
        int red = 0, blue = nums.length - 1;
        for (int i = 0; i <= blue; i++){
            if (nums[i] == 0){
                swap(nums, i, red++);
            } else if (nums[i] == 2){
                swap(nums, i--, blue--);//i--意思是i还要回头再重新扫一遍原来的i已经被换到后面去了
            }
        }
   
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
