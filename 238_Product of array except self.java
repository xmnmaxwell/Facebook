238. Product of array except self// 新建一个数组每个元素是除他以外所有数乘积
Input:  [1,2,3,4]
Output: [24,12,8,6]
 //2,4,5,6,7,8
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++){
            res[i] = res[i-1] * nums[i-1]; //for the ith product, calculate the previous i-1 element product,calculate 2*4*5
        }
        int right = 1;
        for (int j = len - 1; j >=0; j--){
            res[j] *= right;     // 8*7
            right *= nums[j];   // for j-1 th elemnt
        }
        return res;
    }
