128. Longest consecutive Sequence 最长连续数字的长度
O(n)
Input: [100, 4, 200, 1, 3, 2]最长连续数字是 1234
Output: 4
public int longestConsecutive(int[] nums) {
        int max = 0; // max len;
        Set<Integer> set = new HashSet<Integer>();
   for (int i = 0; i < nums.length; i++) {
        set.add(nums[i]); // add every element in the set
    }
  
   for (int i = 0; i < nums.length; i++) {
        int count = 1;
        // look left
        int num = nums[i];
        while (set.contains(--num)) {
            count++; // count = 4
            set.remove(num); // remove 3, 2, 1
        }
        // look right
            num = nums[i];
        while (set.contains(++num)) {
            count++;
            set.remove(num); 
        }
            max = Math.max(max, count);
    }
            return max;
}
