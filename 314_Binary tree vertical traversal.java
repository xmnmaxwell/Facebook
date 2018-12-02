Binary tree vertical traversal  二叉树垂直遍历
n(nlogn)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public List<List<Integer>> verticalOrder(TreeNode root) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results; // corner case
        }
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        //treemap can order the key
        Queue<Integer> qCol = new LinkedList<>();// to store the col number
        Queue<TreeNode> queue = new LinkedList<>(); // node queue
        queue.offer(root);
        qCol.offer(0);// set a basic standard
        
        while(!queue.isEmpty()) {
        	// node: 3 9 20 15 7
      // col number: 0 -1 1  0 2
            TreeNode curr = queue.poll();// get the curr node
            int col = qCol.poll();
            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>(Arrays.asList(curr.val)));
            } else {
                map.get(col).add(curr.val);
            }
            if(curr.left != null) {
                queue.offer(curr.left);
                qCol.offer(col - 1);
            }
            if(curr.right != null) {
                queue.offer(curr.right);
                qCol.offer(col + 1);
            }
        }
        for(int n : map.keySet()) {
        	// for the treemap, order through key, 
            results.add(map.get(n));
        }
        return results;
    }   
} 
/*
//只用 hashmap来解
 public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
        return res;
    }
    
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();
    Queue<Integer> cols = new LinkedList<>();

    q.add(root); 
    cols.add(0);

    int min = 0;
    int max = 0;
    
    while (!q.isEmpty()) {
        TreeNode node = q.poll();
        int col = cols.poll();
        
        if (!map.containsKey(col)) {
            map.put(col, new ArrayList<Integer>());
        }
        map.get(col).add(node.val);

        if (node.left != null) {
            q.add(node.left); 
            cols.add(col - 1);
            min = Math.min(min, col - 1);
        }
        
        if (node.right != null) {
            q.add(node.right);
            cols.add(col + 1);
            max = Math.max(max, col + 1);
        }
    }

    for (int i = min; i <= max; i++) {
        res.add(map.get(i));
    }

    return res;
}
*/
