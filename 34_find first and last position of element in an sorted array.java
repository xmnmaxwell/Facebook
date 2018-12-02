Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
给一个有序数组查找target的第一个和最后一个index，这道题扩展为返回target出现的个数，那就是end-target+1,如果返回不等于target的个数
那就拿长度减去end-target+1
O(logn)
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

 public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1}; //如果求是target的个数，就用这两个存放target的一头一尾
        if (nums.length == 0 || nums == null) return res;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) end = mid;
            else if (nums[mid] > target) end = mid;
            else start = mid;
        }
        if (nums[start] == target) res[0] = start;
        else if (nums[end] == target) res[0] = end;
        else res[0] = -1;  
        
        start = 0;
        end = nums.length - 1;
         while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) start = mid;
            else if (nums[mid] > target) end = mid;
            else start = mid;
        }
        if (nums[end] == target) res[1] = end;
        else if (nums[start] == target) res[1] = start;
        else res[1] = -1;
        return res;
    }
