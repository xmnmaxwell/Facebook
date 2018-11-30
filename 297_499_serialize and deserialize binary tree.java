serialize and deserialize binary tree/BST 二叉树和字符串相互转化（BFS）
O(n)
    1
   / \
  2   3
     / \
    4   5
 public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { // if root is null
            return "{}";// return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();// List<String> list = new ArrayList<>();
        // build a string to store the serialized tree
        queue.offer(root);
        sb.append("{");
        
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head == null) {
                sb.append("null");// list.add("null");
            } else {
                sb.append(head.val); // queue: 1 2 3, null, null, 4, 5
                queue.offer(head.left); // list.add(Integer.toString(head.val))
                queue.offer(head.right);
            }
            
            if (!queue.isEmpty()) {
                sb.append(",");// add ',' to split
            }
        }
        
        sb.append("}");// add to close the string.
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("{}")) {
            return null;
        }
        //data {1,2,3,null,null,4,5}
        String[] val = data.substring(1, data.length() - 1).split(",");
        //去掉两边括号分割
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));// TreeNode(Integer.parseInt(list.get(0)));
        //create a new treenode with val[0]
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftChild = true;//设置这个的意义是如果否就把下一个元素put到右边
        
        for (int i = 1; i < val.length; i++) {
            if (!val[i].equals("null")) {
                TreeNode child = new TreeNode(Integer.parseInt(val[i]));
                // if is not null create a treenode child with the val[i]
                if (isLeftChild) {
                    queue.peek().left = child;//if yes 放到左边
                } else {
                    queue.peek().right = child;//放到右边
                }
                
                queue.offer(child);
            }
            
            if (!isLeftChild) {
            // 如果切换到右边模式， 说明2下面已经放完了，切换到下一个
                queue.poll();
            }
            isLeftChild = !isLeftChild;
        }
        
        return root;
    }
