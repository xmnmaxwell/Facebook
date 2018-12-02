Kth largest element in an array/数组里第k大的元素
Input: [3,2,1,5,6,4] and k = 2
Output: 5
LC.215 Kth largest element in an array
Input: [3,2,1,5,6,4] and k = 2
Output: 5
quick select做法，最佳O(n)正好选中的是k 最差O(n2)，找最大值每次的pivot都是最小值
public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length -1;
        while(low <= high){  
            int pivot = nums[high];// randomly find an pivot
            int index = low-1;
            for(int i = low; i < high; i++){
                if(nums[i] > pivot){
                    swap(nums, i, ++index);// find element larger than pivot to left
                }
            }
            swap(nums, ++index, high);// change pivot to the right position
            if(index == k - 1){
                return nums[index]; // find the element
            }
            if(index < k -1){
                low = index + 1; 
            }else{
                high = index - 1;
            }
        }
        return -1;
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
********************************************************************************************************************
public class ThirdLargest {

    public int thirdLargest(int[] nums) {
        int a, b, c;
        a = b = c = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > a) {
                c = b; b = a; a = num;
            } else if (num > b) {
                c = b; b = num;
            } else if (num > c) c = num;
        }
        return c;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        ThirdLargest sol = new ThirdLargest();
        System.out.println(sol.thirdLargest(nums));
    }
}
