491. increasing subsequences 找所有的上升子序列全排列,序列个数最小为2
O(n^2) DFS
Input: [4, 6, 7, 7] 
recursiron order: [[4, 6], [4, 6, 7], [4, 6, 7, 7], [4, 7], [4,7,7], [6, 7], [6, 7, 7], [7,7]]

 public List<List<Integer>> findSubsequences(int[] nums) {
        ArrayList<List<Integer>> res =new ArrayList<List<Integer>>();
        helper(new ArrayList<Integer>(), 0, nums, res);// new arraylist to store comtempory list that is meet the increasing requirement
        return res;
    }
    private void helper(ArrayList<Integer> list, int index, int[] nums, ArrayList<List<Integer>> res){
    	//
        if(list.size()>1) res.add(new ArrayList<Integer>(list));//once the list size is at least two, create a new arraylist to store on solution
        Set<Integer> used = new HashSet<>();//set只存该次递归时候的重复的，因为每次递归set都重置了
        for(int i = index; i<nums.length; i++){
            if(used.contains(nums[i])) continue;// skip duplicate number
            if(list.size()==0 || nums[i]>=list.get(list.size()-1)){
            	// nums[i] is larger than the last element in the list, add this element in the set and list 
                used.add(nums[i]);
                list.add(nums[i]); 
                helper(list, i+1, nums, res);
                list.remove(list.size()-1);// if searched, remove the last element and go back to previous recursion
            }
        }
    }
