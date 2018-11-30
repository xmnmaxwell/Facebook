Binary Search Tree Iterator BST迭代器 iterator is the object enable people to traverse the container.(Inorder)
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

    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root); //stack 存root
            while (stack.peek().left != null)// 当左根一直存在时一直push
                stack.push(stack.peek().left);// stack: 4, 2, 1
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();// if stack is empty
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();// 把最左边的pop出来
        if (cur.right != null) {
            stack.push(cur.right);//如果该node有右子树
            while (stack.peek().left != null)
                stack.push(stack.peek().left);//再检查右子树是否有左子树再加进栈，其实通篇就是中序遍历
        }
        return cur.val;
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
