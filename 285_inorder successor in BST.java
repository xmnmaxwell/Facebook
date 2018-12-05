Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Example 1:

Input: root = [2,1,3], p = 1

  2
 / \
1   3

Output: 2

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val >= root.val) 
            return inorderSuccessor(root.right, p);
        TreeNode tmp = inorderSuccessor(root.left, p);
        return tmp != null ? tmp : root;
    }
}

******************************************************************
iterative
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
         TreeNode ret = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                ret = root;
                root = root.left;
            }
        }
        return ret;
}
