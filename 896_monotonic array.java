An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.

Input: [6,5,4,4]
Output: true

 public boolean isMonotonic(int[] A) {
        int len = A.length - 1;
        boolean inc = true, dec = true;
        
        for (int i = 1; i <= len; i++){
            inc &= A[i] >= A[i-1];
            dec &= A[i] <= A[i-1];
        }
        return inc || dec;
    }
