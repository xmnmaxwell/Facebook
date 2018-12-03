A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.


public int findPeakElement(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] < nums[mid-1]){
                end = mid;
            } else if (nums[mid] < nums[mid + 1]){
                start = mid;
            } else {
                end = mid;
            }
        }
        return nums[start] < nums[end] ? end : start;
    }
