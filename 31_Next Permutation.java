31. Next Permutation
O(n)
其实本意就是求这个排列组合下一个比他大的数
123-->132
12(3210)-->12(0123)-->130122
     指针 j |        指针 j |
321-->123 no next Permutation
1321-->2311
思路是从末位起，如果末位比上一位大很简单交换一下就可以
但是若是前位比后位一直大，我们需要先找到然后升序排列如图120123
此时其实120123是比123210小的，这样我们只能将第一个2和右侧已经排好序的数进行比较
建立一个指针j，始终好右边的元素比较，发现比他大的那个然后交换两位
所以辅助函数有两个，第一个是整列交换为第一个操作准备，第二个是两元素交换位最后一个
操作准备
public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;
        
        int i = len - 1;
        while (i > 0 && nums[i-1] >= nums[i]){ //12 4321，右位始终大于左位直到4
            i--;
        }
        swapList(nums, i, len-1);//将4321反过来排12 1234
        
        if (i != 0){  //检测4是不是最高位了？不是
            int j = i; //让新指针j指向2，因为此时i也指向2， 1 12 2 34
            while (nums[i-1] >= nums[j]) //拿2和后边比，直到找到3比他大，交换2和3的位置
                j++;
            swapItem(nums, i-1, j);
        }
        
    }
    public void swapItem(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void swapList(int[] nums, int i, int j){
        while (i < j){
            swapItem(nums, i, j);
            i++;
            j--;
        }
    }
