378. Kth smallest element in a sorted matrix 在排序的矩阵里找第k小的数字
nLog(n)
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
return 13.
public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int low = matrix[0][0], high = matrix[m][m];
        // use binary search, find fist element = k 
        while (low + 1< high){
            int mid = low + (high - low)/2;
           if (countLessEqual(matrix, mid) >= k){
           	// if countLessEqual >=k, high = mid
               high = mid;
           } else {
           	// if countLessEqual < k, low = mid
               low = mid;
           }
        }
        if (countLessEqual(matrix, low) >= k)// finally check 
            return low;
        
        return high;
    }
    // write a function to calculate the number of elements less or equal to target value
    private int countLessEqual(int[][] matrix, int value){
        int cnt = 0;
        int n = matrix.length;
        int i = 0, j = n - 1;
        while (i < n && j >= 0) {
        // int the 0th row, search from 0 to n-1 elements (1.5.9) 
        // if 最末尾元素不大于value，计数器加整行，i+换另一行，否则j-- 
            if (matrix[i][j] <= value) {
                cnt += j + 1;
                i++;
            } else {
                j--;
            }
        }
        
        return cnt;
    }
