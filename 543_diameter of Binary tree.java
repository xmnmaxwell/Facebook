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
    *************************************************************************************
    多个node
     public class TreeNode {
        int val;
        TreeNode[] children;
        TreeNode(int x, int n) { 
            val = x;
            children = new TreeNode[n];
        }
    }

    public int findDiameter(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return diameter;
    }

    int diameter = Integer.MIN_VALUE;

    private int helper(TreeNode root) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        for (TreeNode child : root.children) {
            if (child == null) continue;
            int tmp = helper(child);
            if (tmp > a) { b = a; a = tmp;}
            else if (tmp > b) b = tmp;
        }

        if (b >= 0) diameter = Math.max(diameter, a + b + 2);
        if (a >= 0) {
            diameter = Math.max(diameter, a + 1);
            return a + 1;
        }
        return 0;
    }
    
    public void test() {
        TreeNode root = new TreeNode(0, 4);
        TreeNode n1 = new TreeNode(1, 1);
        TreeNode n2 = new TreeNode(2, 0);
        TreeNode n3 = new TreeNode(3, 0);
        TreeNode n4 = new TreeNode(4, 1);
        TreeNode n5 = new TreeNode(5, 0);
        TreeNode n6 = new TreeNode(6, 0);
        root.children[0] = n1;
        root.children[1] = n2;
        root.children[2] = n3;
        root.children[3] = n4;
        n1.children[0] = n5;
        n4.children[0] = n6;
        System.out.println(findDiameter(root));
    }

    public static void main(String[] args) {
        DiameterOfTree sol = new DiameterOfTree();
        sol.test();
    }
