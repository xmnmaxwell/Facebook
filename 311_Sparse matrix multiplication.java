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
        List<Node> listA = new ArrayList<>();
        List<Node> listB = new ArrayList<>();
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
