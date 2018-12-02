Lowest Common Ancestor of a Binary Tree 二叉树找到两个指定节点的最底层的共同祖先
// worst case O(n) time O(n) stack
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        
        //divide and conqur, divide the problem into subproblem
        TreeNode left = lowestCommonAncestor(root.left, p, q); //find p q in the left subtree 
        TreeNode right = lowestCommonAncestor(root.right, p, q);//find p q in the left subtree
        
        if (left != null && right != null) return root;
        // if left and right are not null it means p q are in seperate subtree, so return the common root
        else if (left != null) return left;
        // if left is not null, means both are in the left subtree, return 
        else if (right != null) return right;
        
        return null;
    }
