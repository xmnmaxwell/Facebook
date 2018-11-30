//O(m+n) store the result in nums1
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
Output: [1,2,2,3,5,6]


 public void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = m - 1, j = n - 1;// define two pointers point to the end
      int len = m + n - 1;// len to represent the total len of new arr
      while (i >= 0 && j >=0){
          if (nums1[i] > nums2[j]){
              nums1[len--] = nums1[i--];
          } else {
              nums1[len--] = nums2[j--];
          }
      }  
      while (j >= 0) nums1[len--] = nums2[j--];//if j is not zero, put the elements in nums2 in nums1 
    }
