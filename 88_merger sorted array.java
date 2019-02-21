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
可以新建数组：

class MergeTwoSorted {
    public in[] mergeArrays(int[] arr1, int[] arr2, int n1, int n2) { 
        int i = 0, j = 0, index = 0; 
        // Traverse both array 
        while (i<n1 && j <n2) { 
            if (arr1[i] < arr2[j]) 
                arr3[index++] = arr1[i++]; 
            else
                arr3[index++] = arr2[j++]; 
        } 
        // Store remaining elements of first array 
        while (i < n1) 
            arr3[k++] = arr1[i++]; 
        // Store remaining elements of second array 
        while (j < n2) 
            arr3[k++] = arr2[j++]; 
    } 

*************************************************************************************************************
merge 三个
public class MergeThreeSortedArrays {

    public int[] merge(int[] a, int[] b, int[] c) {
        int[] ans = new int[a.length + b.length + c.length];
        int i = 0, j = 0, k = 0, cnt = 0;

        while (i < a.length && j < b.length && k < c.length) {//三个比较
            ans[cnt ++] = Math.min(a[i], Math.min(b[j], c[k]));
            if (ans[cnt - 1] == a[i]) i ++;
            else if (ans[cnt - 1] == b[j]) j ++;
            else k ++;
        }

        while (i < a.length && j < b.length) {//剩下两种时候
            if (a[i] < b[j])
                ans[cnt ++] = a[i ++];
            else ans[cnt ++] = b[j ++];
        }

        while (i < a.length && k < c.length) {
            if (a[i] < c[k])
                ans[cnt ++] = a[i ++];
            else ans[cnt ++] = c[k ++];
        }

        while (j < b.length && k < c.length) {
            if (b[j] < c[k])
                ans[cnt ++] = b[j ++];
            else ans[cnt ++] = c[k ++];
        }

        while (i < a.length) ans[cnt ++] = a[i ++];//剩下一种的时候
        while (j < b.length) ans[cnt ++] = b[j ++];
        while (k < c.length) ans[cnt ++] = c[k ++];
        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 41, 52, 84 }; 
        int[] b = { 1, 3, 41, 52, 67 }; 
        int[] c = { 1, 4, 41, 52, 67, 85 }; 
        MergeThreeSortedArrays sol = new MergeThreeSortedArrays();
        int[] ans = sol.merge(a, b, c);
        for (int num : ans)
            System.out.print(num + " ");
        System.out.println();
    }
}
***********************************************************************************************
merge k 个
public class MergeKSortedArrays {

    class Array {
        int[] array;
        int index;
        Array(int[] array, int index) {
            this.array = array;
            this.index = index;
        }
    }

    public int[] merge(int[][] arrays) {
        PriorityQueue<Array> pq = new PriorityQueue<>(new Comparator<Array>() {
            public int compare(Array a, Array b) {
                return a.array[a.index] - b.array[b.index];
            }
        });
        for (int[] array : arrays) {
            if (array.length == 0) continue;
            pq.add(new Array(array, 0));
        }
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Array cur = pq.poll();
            list.add(cur.array[cur.index]);
            if (++ cur.index < cur.array.length)
                pq.add(cur);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i ++)
            ans[i] = list.get(i);
        return ans;
    }

    public static void main(String[] args) {
        int[][] arrays = {{ 1, 2, 41, 52, 84 }, { 1, 3, 41, 52, 67 }, { 1, 4, 41, 52, 67, 85 }}; 
        MergeKSortedArrays sol = new MergeKSortedArrays();
        int[] ans = sol.merge(arrays);
        for (int num : ans)
            System.out.print(num + " ");
        System.out.println();
    }
}
