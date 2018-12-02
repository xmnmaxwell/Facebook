Binary tree right side view  二叉树从右侧看输出
O(n), space O(n), depending on 某一层最大的node数
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 //利用 level order，返回每行最后一个元素
public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer> ();
        if (root == null){
            return result; // deal with corner case
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode last = null;// find the last node
            for (int i = 0; i < size; i++){
                last = queue.poll();
                if (last.left != null){
                    queue.offer(last.left);
                }
                if (last.right != null){
                    queue.offer(last.right);
                }
            }
            result.add(last.val);
            //for循环每次循环完意味着这一层已经遍历完除了这个循环的last一定是这一层最后一个
        }
        return result;
    }
