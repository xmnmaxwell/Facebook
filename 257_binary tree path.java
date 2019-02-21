257. binary tree path 打印所有从根出发的所有路径
O(n) space: worst case O(n) recursion call best O(logn)
   1
 /   \
2     3
 \
  5
  public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();// create res to store the solution
    if (root != null) searchBT(root, "", res);
    return res;
}
//in this recursion method, we use the root, and path to record one path, and res for storing very path 
private void searchBT(TreeNode root, String path, List<String> res) {
    if (root.left == null && root.right == null) res.add(path + root.val);//set terminal condition, if both left and right have no subtree, add the path in the res

    if (root.left != null) searchBT(root.left, path + root.val + "->", res);// search the left subtree add root value and into path
    if (root.right != null) searchBT(root.right, path + root.val + "->", res);
}
