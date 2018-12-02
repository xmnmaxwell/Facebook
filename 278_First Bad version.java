278. First Bad version
Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
This is find the first version that is true; 
O(logn)

public int firstBadVersion(int n) {
        int start = 1, end = n; //define two pointers
        while (start + 1 < end){
            int mid = start + (end - start)/2; //find middle index
            if (isBadVersion(mid)) end = mid; //if mid is true, end point to mid
            else
                start = mid;
        }
        if (isBadVersion(start)) return start;//need to check if start is true first
        else return end;
    }
