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
   *******************************************************************************
   LC.81 假设有重复元素
    public boolean search(int[] nums, int target) {
        // 这个问题在面试中不会让实现完整程序
    // 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
    // 在这种情况下是无法使用二分法的，复杂度是O(n)
    // 因此写个for循环最坏也是O(n)，那就写个for循环就好了
    //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
    //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }
    硬要用二分法
      public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            if (nums[l] < nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) r = mid;
                else l = mid + 1;
            } else if (nums[l] > nums[mid]) {
                if (target > nums[mid] && target <= nums[r - 1]) l = mid + 1;
                else r = mid;
            } else l ++;
        }
        if (l >= nums.length || nums[l] != target) return false;
        return true;
    }
    
