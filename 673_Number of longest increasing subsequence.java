673. Number of longest increasing subsequence
O(n^2)
最大增子集的个数
Input: [1,3,5,4,7] 最大增子集有两个 1347 1357
Output: 2
num //1 2 5 4 7 7
len //1 2 3 3 4 4
cnt //1 1 1 1 2 2
 public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int res = 0;
        int max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        // len is the length of LCS which end in nums[i]
        // cnt is the number of LCS which end in nums[i]
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;// initia every element is 1.
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1)cnt[i] += cnt[j];//比如54 这个case， 7和5比较时候len是4了， 7和4比较发现 4的元素别7也少1，说明有两个最大sequence 
                    if(len[i] < len[j] + 1){// this means there is only one increasing subsequence.
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i])res += cnt[i];// if maxlen is the len of i elemnt, means we have duplicate keep adding 
            if(max_len < len[i]){ // if max len is smaller, we just exchange it with len[i] and count[i]
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
