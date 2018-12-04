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
***********************************************************************************************************
// Use division and zero judge
class Solution { //2 5 0 3 1 4 0
    public int[] productExceptSelf(int[] nums) {
        int sum = 1, count = 0;//count is for calculate how many zero
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) count ++;
            else sum *= nums[i];   //calculator all the product of non zero element
        }
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = nums[i] == 0 ?
                (count > 1 ? 0 : sum) ://对于0元素对应的乘积，如果count>1说明除了这个元素本身还有0，那结果就是0，否的话就是所有乘积
                (count > 0 ? 0 : sum / nums[i]);//对非0元素的如果count只要有哪怕1个，结果也是0.
        }
        return nums;
    }
