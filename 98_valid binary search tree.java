98. valid binary search tree 验证是否是二叉搜索树
    4
   / \
  2   5
 / \
1   3
class ResultType {
    int maxValue, minValue;//set min and max value of subtree
    boolean isBST; //if the subtree is bst
    public ResultType(boolean isBST, int minValue, int maxValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.isBST = isBST;
    }
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST; 
    }
    
    private ResultType helper(TreeNode root){
        if (root == null) return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        //divide into two subproblems
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //what we need to return
        if (!left.isBST || !right.isBST)//if any subtree is not BST, we return false, in this case, max min is not important.
            return new ResultType(false, 0, 0);
        if (root.left!= null && left.maxValue >= root.val || root.right != null && right.minValue <= root.val) 
            return new ResultType(false, 0, 0);
        // if left subtree max value is larger than root or the min value in the right tree is less than root return false
        return new ResultType(true, Math.min(root.val, left.minValue), Math.max(root.val, right.maxValue));
        
    }
}   
    
   public boolean isValidBST(TreeNode root) {// inorder traversal right middle left
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();// build stack 
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;// keep in the left 
      }
      root = stack.pop();// root->1 stack
      if(pre != null && root.val <= pre.val) return false;
      //因为pre始终是root，root跳到了root.left, root 应该始终比pre大如果小就return false
      pre = root; //pre->1
      root = root.right; // 
   }
   return true;
}
***************************************************************************************************
// new inorder
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    
    TreeNode prev = null;
    
    private boolean helper(TreeNode root) {
        if (root == null) return true;
        if (!helper(root.left)) return false;
        if (prev != null && prev.val >= root.val) return false;
        prev = root;
        return helper(root.right);
    }
}

// new preorder
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) & helper(root.right, root.val, max);
    }
}
