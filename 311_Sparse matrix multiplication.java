311. Sparse matrix multiplication 两个稀疏矩阵运算
O(mn)
A = [
  [ 1, 0, 0],//此处的1， -1列数为0， 只要和B中行数是1的乘
  [-1, 0, 3] //此处的3列数为2，只要和B中行数是2的乘
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]
class Solution {
    class Node {
        int x;
        int y;
        Node (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] multiply(int[][] A, int[][] B) {
        // define the result matrix
        int[][] result = new int[A.length][B[0].length];
        List<Node> listA = new ArrayList<>(); //record the nonzero in a
        List<Node> listB = new ArrayList<>(); //record the nonzero in b
        for (int i=0;i<A.length;i++) {
            for (int j=0; j<A[0].length; j++) {
                if (A[i][j]!=0) listA.add(new Node(i,j));
                //find non-zero element index in listA
            }
        }
        for (int i=0;i<B.length;i++) {
            for (int j=0;j<B[0].length;j++) {
                if (B[i][j]!=0) listB.add(new Node(i,j));
                //find non-zero element index in listB
            }
        }

        for (Node nodeA : listA) {
            for (Node nodeB: listB) {
                if (nodeA.y==nodeB.x) {// if A的y下标等于B的x下标
                    result[nodeA.x][nodeB.y] += A[nodeA.x][nodeA.y] * B[nodeB.x][nodeB.y];
                }
            }
        }

        return result;
    }
}
**********************************************************************************************
向量点乘
1. use hashmap
public int[] dotHash(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i ++)
            if (a[i] > 0)
                map.put(i, a[i]);//当a[i]>0,key是index, value是a[i]
        int[] c = new int[a.length];
        for (int i = 0; i < b.length; i ++)
            if (b[i] > 0 && map.containsKey(i))
                c[i] = b[i] * map.get(i);
        return c;
    }
******************************************************************************    
 2.binary search
private class Vector {
        int index, value;
        public Vector(int index, int value){
            this.index = index;
            this.value = value;
        }
    } // define a vector class with index and its value

    private int binarySearch(List<Vector> a, int target) {
        int l = 0, r = a.size();
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (a.get(mid).index == target)
                return a.get(mid).value;
            else if (a.get(mid).index < target)
                l = mid + 1;
            else r = mid;
        }
        if (l >= a.size() || a.get(l).index != target) return 0;
        return a.get(l).value;
    } // this function find the target index in O(logn) time， 返回值是value of this index
    
     public int[] dotList(int[] va, int[] vb) {
        List<Vector> a = new ArrayList<>();
        for (int i = 0; i < va.length; i ++)
            if (va[i] > 0)
                a.add(new Vector(i, va[i]));//将不为0的元素放进vector里变成vector a
        List<Vector> b = new ArrayList<>();
        for (int i = 0; i < vb.length; i ++)
            if (vb[i] > 0)
                b.add(new Vector(i, vb[i]));//
        int[] c = new int[va.length];
         /* two pointer
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            while (i < a.size() && a.get(i).index < b.get(j).index) i ++;
            if (i == a.size()) break;
            while (j < b.size() && a.get(i).index > b.get(j).index) j ++;
            if (j == b.size()) break;
            c[a.get(i).index] = a.get(i ++).value * b.get(j ++).value;
        }
        */
         for (int i = 0; i < b.size(); i ++) {//将不为0的元素放进vector里变成vector b
            int tmp = binarySearch(a, b.get(i).index);//binaryseach在a里有没有b.get(i)的下标
            if (tmp != 0) {
                tmp *= b.get(i).value;// tmp
                c[b.get(i).index] = tmp;
            }
        }
        return c;
}
