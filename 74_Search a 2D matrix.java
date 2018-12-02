74. Search a 2D matrix 在一个矩阵该矩阵每行有序， 每列第一个总比前一列最后一个大， 
里找target，其实就是二分法，把mid转换成matrix下标 
O(logn) 
public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
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
        if (matrix[start/n][start%n] == target) return true;
        else if (matrix[end/n][end%n] == target) return true;
        
        return false;
    }
