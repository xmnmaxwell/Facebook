Binary tree level order traverse 二叉树层序遍历
O(n), space O(n), depending on 某一层最大的node数
Input: [1,2,3,null,5,null,4]
Output: [[1], [2,3], [5,4]]
Explanation:

   1            
 /   \
2     3         
 \     \
  5     4       
 //利用 level order
public List<Integer> rightSideView(TreeNode root) {
        public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null){
                    q.offer(curr.left);
                }
                if (curr.right != null){
                    q.offer(curr.right);
                }
            }
            res.add(list);
        }
        return res;
    }
