Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?
Input:
[4,3,2,7,8,2,3,1]  [-4, 3, 2,-7,8,2,-3,-1]  
Output:
[2,3]
**********************************************************************************************
public class Solution {
    // when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1; //get the nums[i]-1 index(always pos)
            if (nums[index] < 0)
                res.add(Math.abs(index+1)); 
            nums[index] = -nums[index]; // assign negative on that index
        }
        return res;
    }
}
************************************************************************************************
find elements that appear 1 time
public static List<Integer> findOnetime(int[] nums) {
         List<Integer> res = new ArrayList<>();
         for (int i = 0; i < nums.length; i++){
             int index = Math.abs(nums[i]) - 1;
             nums[index] = -nums[index];
         }
         for (int num : nums){
             if (num < 0) {
                 res.add(-num);
             }
         }
         return res;
     }
