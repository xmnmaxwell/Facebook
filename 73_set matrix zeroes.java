73. set matrix zeroes 如果某一元素为0， 它对应的一行一列都为0
O(mn), O(1) space
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
     int m = matrix.length, n = matrix[0].length;
     boolean row = false, col = false;
     //check corner case, the 0 is on oth row and 0th col 
     for (int i = 0; i < m; i++)
         for (int j = 0; j < n; j++){
             if (matrix[i][j] == 0) {
                 matrix[0][j] = 0;//把元素所在列的第一个元素置0
                 matrix[i][0] = 0;//把元素所在行的第一个元素置0
                 if (i == 0) row = true;
                 if (j == 0) col = true;
             }
         }
     for (int i = 1; i < m; i++){
         if (matrix[i][0] == 0){//如果某行第一个元素为0
             for (int j = 1; j < n;j++)
                 matrix[i][j] = 0;//这一行所有的都置0
         }
     }
     for (int j = 1; j < n; j++){
         if (matrix[0][j] == 0){//如果某列第一个元素为0
             for (int i = 1; i < m; i++)
                 matrix[i][j] = 0;//这一列都置0
         }
     }
     if (row){
         for (int j = 0; j < n; j++)
             matrix[0][j] = 0;//row true就把这一行所有元素置0
     }
     if (col){
         for(int i = 0; i < m; i++)
             matrix[i][0] = 0;// col true就把这一列都置0
     }
    }
