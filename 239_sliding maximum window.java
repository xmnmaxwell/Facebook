Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
 // Sliding windows start with 0 and end with 0
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        //1 3 -1
        for (int i = 0; i < nums.length + k - 1; i ++) {
            if (i < nums.length) {
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                    deque.pollLast();
                deque.addLast(i);
            }
            while (!deque.isEmpty() && i - deque.peekFirst() >= k)
                deque.pollFirst();
            ans.add(nums[deque.peekFirst()]);
        }
        
        int[] rtn = new int[ans.size()];
        for (int i = 0; i < ans.size(); i ++)
            rtn[i] = ans.get(i);
        return rtn;
    }
}
