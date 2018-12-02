maximum binary tree 输入一个数组，最大的当根，其右面的组成右树左面的组成左树
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
        
O(n^2)
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
}

TreeNode construct(int[] nums, int l, int r) {
        if (l >= r) return null;
        int maxi = l;
        for (int i = l + 1; i < r; i++) if (nums[i] > nums[maxi]) maxi = i;
        TreeNode root = new TreeNode(nums[maxi]);
        root.left = construct(nums, l, maxi);
        root.right = construct(nums, maxi + 1, r);
        return root;
}
