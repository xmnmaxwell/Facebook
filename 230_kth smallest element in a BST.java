230. kth smallest element in a BST BST里的第k小的数
//中序遍历每pop出一个数字k就-1
 public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();//每pop一次k要减1
            if (--k == 0) break; 
            root = root.right;
        }
        return root.val;
    }
