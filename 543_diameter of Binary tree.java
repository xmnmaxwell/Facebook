diameter of Binary tree  二叉树的直径，一个联通的树枝的最大长度， 4213 长度4
          1
         / \
        2   3
       / \     
      4   5    
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;// termination condition
        
        int left = maxDepth(root.left);//find maxdepth of left subtree
        int right = maxDepth(root.right);//find maxdepth of right subtree
        
        max = Math.max(max, left + right);//update the max with left+right
        
        return Math.max(left, right) + 1;
        //return the maxvlue of right or left tree +1 means 到这个节点算上root的深度
    }
