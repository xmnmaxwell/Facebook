recover BST BST树里有有俩个元素位置颠倒了
O(h) space, O(n) time
    // define first and second element which needs swap
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE); 
    //以下除了两个if是inorder的traverse 模板，该方法先进入最左边的元素
    //比如6 3 4 5 2，先遍历到6，返回到3这个节点 root.val 3 lastElement 6
    //3 < 6说明第一个元素是6, 第二个元素2 <5,这样我们就找到了两个需要换的元素
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (firstElement == null && root.val < lastElement.val) {
            firstElement = lastElement;
        }
        if (firstElement != null && root.val < lastElement.val) {
            secondElement = root;
        }
        lastElement = root;
        traverse(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        // traverse and get two elements
        traverse(root);
        // swap
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
