range sum query 一维数组// dp数组多了一位因为留着dp0 不用考虑如果首索引是0的情况

class NumArray {
    int[] dp;
    public NumArray(int[] nums) {
        dp = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++){
            dp[i+1] = dp[i] + nums[i]; 
        }
    }
    
    public int sumRange(int i, int j) {
        return dp[j+1]-dp[i];
    }
}
***************************************************************************************************
range sum query 2D
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and 
lower right corner (row2, col2).

Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]
我们要计算sum(ab,cd) 只要 sum(cd)+sum(c,d-1)+sum(c-1,d) -重叠部分 sum(ab)
sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
// new 
class NumMatrix {

    int[][] sum;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return;
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i ++)
            for (int j = 0; j < matrix[0].length; j ++)
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}
