674. Longest continuous Increasing subsequence 
连续最大的增子集的长度
Input: [1,3,5,4,7] 最长且连续的是135，所以输出是3
Output: 3
O(n)
 public int findLengthOfLCIS(int[] nums) {
        int count = 0;// define calculate the length of the nums
        int maxLen = 0;// define maxLen to get current largest length
        for (int i = 0; i < nums.length; i++){
            if (i == 0 || nums[i] > nums[i-1]){//if ith element is larger count++
                count++;
                maxLen = Math.max(maxLen, count);// maxLen is the maximum value between
            } else {
                count = 1;// we need to calculate the count again, so we reset the count
            }
        }
        return maxLen;
    }
