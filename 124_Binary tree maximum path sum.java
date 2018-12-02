Binary tree maximum path sum 任意一条路径的最大和
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType {// create two variable to store the max value
        int root2Any, any2Any;
        ResultType(int root2Any, int any2Any){
            this.root2Any = root2Any;
            this.any2Any = any2Any;
        }
    }

public class Solution {
     public int maxPathSum(TreeNode root) {
         ResultType res = helper(root);
         return res.any2Any;
     }
    
    private ResultType helper(TreeNode root){
        if (root == null) return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int root2Any = Math.max(0, Math.max(left.root2Any, right.root2Any)) + root.val; 
        //since root2any can be negative, we compare them with 0, if Math.max(left.root2Any, right.root2Any)<0, we only take root.val
        int any2Any = Math.max(left.any2Any, right.any2Any);// first compare left and right any2any
        any2Any = Math.max(any2Any, Math.max(0, left.root2Any) + Math.max(0, right.root2Any) + root.val);
        //compare with any2any, with Math.max(0, left.root2Any) + Math.max(0, right.root2Any) + root.val
        return new ResultType(root2Any, any2Any);
    }
}
