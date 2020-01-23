74. Search a 2D matrix 在一个矩阵该矩阵每行有序， 每列第一个总比前一列最后一个大， 
里找target，其实就是二分法，把mid转换成matrix下标 
O(logn) 
public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m*n-1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if (matrix[mid/n][mid%n] == target) return true;
            else if (matrix[mid/n][mid%n] < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start/n][start%n] == target ||matrix[end/n][end%n] == target) return true;
        
        return false;
    }
*************************************************************************************************************
240. Search a 2D matrix II 在一个矩阵里找target，这题不能用二分法，因为每行第一个数并不比前一行最后一个数大
从数列右上角开始扫描，如果target大下移一行，如果target小左移一列O（m+n）
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <=matrix.length - 1){
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
//We start search the matrix from top right corner, 
initialize the current position to top right corner, 
if the target is greater than the value in current position, 
then the target can not be in entire row of current position because the row is sorted, 
if the target is less than the value in current position, then the target can not in the entire
column because the column is sorted too. We can rule out one row or one column each time, so the time complexity is O(m+n).
******************************************************************************************************************************
public static void main(String []args){
        int[][] matrix = {{1,1,0,0,0,0}, {1,1,1,1,0,0}, {1,1,1,1,1,1}, {1,1,0,0,0,0}, {1,0,0,0,0,0}};
        System.out.println(func(matrix));
     }
     public static int func(int[][] matrix) {
         if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
             return 0;
         }
         int m = matrix.length;
         int n = matrix[0].length;
         int maxLine = 0;
         int maxOne = 0;
         int row = 0, col = 0;
         while (row < m && col < n) {
             if (matrix[row][col] == 1) {
                 maxOne++;
                 maxLine = row;
                 col++;
             } else {
                 row++;
             }
         }
         return maxOne;
     }
