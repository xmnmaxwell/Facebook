Binary Search Tree Iterator BST迭代器 iterator is the object enable people to traverse the container.
call next() 返回下一个最小的数, hasNext() 是否还有下一个 时间O(1), 空间O(h)

O(1) and O(h) space
/*
I use Stack to store directed left children from root.
When next() be called, I just pop one element and process its right child as new root.
The code is pretty straightforward.
So this can satisfy O(h) memory, hasNext() in O(1) time,
But next() is O(h) time.
*/
    4
   / \
  2   5
 / \
1   3

public class BSTIterator {
    
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        // find the smallest one, stack: 4, 2, 1
        while(cur != null){
            stack.push(cur); //if curr is not null add in the stack
            if(cur.left != null)
                cur = cur.left; 
            else
                break;
        //only when we find the left subnode to find the start point
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    /*
    I directly return where the pointer pointing at, which should be the left most TreeNode I previously found. 
    What to do next? After returning the smallest TreeNode, I need to point the pointer to the next smallest TreeNode. 
    When the current TreeNode has a right branch (It cannot have left branch, remember we traversal to the left most), 
    we need to jump to its right child first and then traversal to its right child's left most TreeNode. 
    When the current TreeNode doesn't have a right branch, it means there cannot be a node with value smaller than itself father node, 
    point the pointer at its father node
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();// stack: 4, 2 把1去掉开始看2
        TreeNode cur = node;// cur -> 2
        // traversal right branch
        if(cur.right != null){
            cur = cur.right;// cur -> 3
            while(cur != null){
                stack.push(cur); //stack: 4, 3
                if(cur.left != null)// if it has the left we need to examine left node first
                    cur = cur.left;
                else
                    break;
            }
        }
        return node.val;
    }
}
*********************************************************************************************************************************
Use parent instead of stack. O(1) space
class Solution {

  static class Node {
      
    int key;
    Node left;
    Node right;
    Node parent;
    
    Node(int key) {
      this.key = key;
      left = null;
      right = null;
      parent = null;
    }
  }
  
  static class BinarySearchTree  {
    
    Node root;

    // Iterator part

    class BSTIterator implements Iterator<Node> {

        Node last = null;

        BSTIterator(Node root) {
            if (root == null) return;
            last = root;
            while (last.left != null)
                last = last.left;
        }

        public boolean hasNext() {
            return last != null;
        }

        public Node next() {
            Node cur = last;
            last = findSuccessor(last);
            return cur;
        }

        private Node findSuccessor(Node root) {
            if (root == null) return null;
            if (root.right != null) {
                Node tmp = root.right;
                while (tmp.left != null) tmp = tmp.left;
                return tmp;
            }
            Node father = root.parent;
            Node child = root;
            while (father != null && father.left != child) {
                child = father;
                father = father.parent;
            }
            return father;
        }
    }
    
    Iterator<Node> iterator() {
        BSTIterator iter = new BSTIterator(root);
        return iter;
    }

    //  Given a binary search tree and a number, inserts a new node
    //  with the given number in the correct place in the tree
    void insert(int key) {
      
      // 1. If the tree is empty, create the root
      if(this.root == null) {
        this.root = new Node(key);
        return;
      }

      // 2) Otherwise, create a node with the key
      //    and traverse down the tree to find where to
      //    to insert the new node
      Node currentNode = this.root;
      Node newNode = new Node(key); 

      while(currentNode != null) {
        if(key < currentNode.key) {
          if(currentNode.left == null) {
            currentNode.left = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.left;
          }
        } else {
          if(currentNode.right == null) {
            currentNode.right = newNode;
            newNode.parent = currentNode;
            break;
          } else {
            currentNode = currentNode.right;
          }
        }
      }
    }
    
    // Return a reference to a node in the BST by its key.
    // Use this method when you need a node to test your 
    // findInOrderSuccessor method on
    Node getNodeByKey(int key) {
      Node currentNode = this.root;
      
      while(currentNode != null) {
        if(key == currentNode.key) {
          return currentNode;
        }
        
        if(key < currentNode.key) {
          currentNode = currentNode.left;
        } else {
          currentNode = currentNode.right;
        }
      }
      
      return null; 
    }
  }
  
  /***********************************************
   * Driver program to test findInOrderSuccessor *
   ***********************************************/

  public static void main(String[] args) {
     
    Node test = null, succ = null;
     
    // Create a Binary Search Tree
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(20);
    tree.insert(9);
    tree.insert(25);
    tree.insert(5);
    tree.insert(12);
    tree.insert(11);
    tree.insert(14);

    Iterator<Node> iter = tree.iterator();
    while (iter.hasNext())
        System.out.println(iter.next().key);
    
  }
}
