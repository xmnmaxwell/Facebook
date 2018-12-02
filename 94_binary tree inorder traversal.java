94. binary tree inorder traversal
O(n) time O(h) space
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while (!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;//先找最左的点
            }
            root = stack.pop();//从最左的开始pop
            res.add(root.val);// pop完看情况操作
            root = root.right;//再找他右边的点
        }
        return res;
    }

    // recursion
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    // method 1: recursion

    helper(root, res);
    return res;

    //helper function for method 1
    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
           }
       }
   }
