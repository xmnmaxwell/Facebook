binary tree zigzag level order 和层序遍历不同的是奇数行正打偶数行反打
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean order = true;

        while(!q.isEmpty()) {
             int size = q.size();
             List<Integer> tmp = new ArrayList<>();
             for(int i = 0; i < size; ++i) {
                 TreeNode curr = q.poll();
                 if(order) {
                     tmp.add(curr.val);
                 } else {
                     tmp.add(0, curr.val);
                 }
                     if(curr.left != null) q.add(curr.left);
                     if(curr.right != null) q.add(curr.right);
             }
             res.add(tmp);
             order = order ? false : true;
        }
             return res;
    }
