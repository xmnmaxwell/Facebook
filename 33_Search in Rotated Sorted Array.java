 // 针对rotated这类问题。想象在14象限的两条直线。
 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 **********************************************************************
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[start]){
                if(target < nums[mid] && target >= nums[start]){
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[end]){
                if (target <= nums[end] && target > nums[mid]){
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) return start;
        else if (nums[end] == target) return end;
        
        return -1;
   }
