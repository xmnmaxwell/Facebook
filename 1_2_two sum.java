1. two sum 
O(n), O(n)
public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i){
                res[0] = i;
                res[1] = map.get(target-nums[i]);
            }
        }
        return res;    
    }
 ***********************************************************
 O(n), O(1)
167. two sum if array is sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        int[] res = new int[2];
        while (start < end){
            if(numbers[start] + numbers[end] == target){
                res[0] = start+1;
                res[1] = end+1;
                break;
            } else if (numbers[start] + numbers[end] < target){
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}
