110. Balanced binary tree 
a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
call depth O(n) 总共需要O(n^2)
 public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = depth(root.left);
        int r = depth(root.right);
        
        return Math.abs(l-r) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        
    }
    private int depth(TreeNode root){
        if (root == null) return 0;
        
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
