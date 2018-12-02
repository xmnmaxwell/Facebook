114. Flatten Binary tree to LinkedList 把二叉树铺平转化成链表 （先序遍历）
    1                        
   / \
  2   5            
 / \   \
3   4   6

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
public void flatten(TreeNode root) {
    if (root == null) {
            return;
        }
        //根左右
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);// root -> 1
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop(); //node -> 1 
            if (node.right != null) { 
                stack.push(node.right);//先将右元素放进去，因为左元素先出来
            }
            if (node.left != null) {
                stack.push(node.left);// stack: 5 2
            }
            
            // connect 
            node.left = null;// 1 左指针 null
            if (stack.isEmpty()) {
                node.right = null;// stack为空右指针也为空
            } else {
                node.right = stack.peek();//peek出来的是2，则1的右指针连到2
            }
        }
    }
