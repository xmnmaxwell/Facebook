270. Closet BST value 找BST和target值最接近的node
time complexity O(h)
   5
 3   6
1 4
public int closestValue(TreeNode root, double target) {
        int closestVal = root.val; 
        while(root != null){ 
            //update closestVal if the current value is closer to target
            closestVal = (Math.abs(target - root.val) < Math.abs(target - closestVal))? root.val : closestVal;
            if(closestVal == target){   //already find the best result
                return closestVal;
            }
            root = (root.val > target)? root.left: root.right;   //binary search
        }
        return closestVal;
  }
