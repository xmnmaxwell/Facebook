二叉树双向链表转换
convert binary tree to sorted doubly linkedlist
       4
    2     5   
 1     3

 1 2 3 4 5
 这道题的思路就是利用inorder算法，用一个prev指针来链接每个节点
 新建一个dummy，让prev指向它，然后inorder遍历，prev先利用右指针指向节点1，
 然后把1的左指针指向prev，这样实际上是dummy的右指针指向1,1的左指针指向dummy，
 然后prev跳转到1，将1的右指针指向2，将2的左指针指向了1；然后跳转到2，将2的右指针
 指向3，将3的左指针指向了2，依次类推，知道prev到了5跳出来。
 最后一步是将dummy指向的1 和prev指向的5首尾相连变成循环。将prev即5的右指针指向了dummy
 的右指针即1，然后dummy右指针即1的左指针指向了prev即5

  Node prev = null; // pre is pointer for connecting with BST
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        prev.right = dummy.right;//此时prev在5，他的右指针是可以指向dummy.right就是1
        dummy.right.left = prev;//此时dummy.right即1他的左指针是空闲的可以指向5
        
        return dummy.right;
    }
    private void helper(Node root){
        if (root == null) return;
        
        helper(root.left); // inorder traverse
        prev.right = root;
        root.left = prev;//在第一次迭代，prev还未跳到1，这时候实际就是dummy和1互指
        prev = root;
        helper(root.right);
        //后来prev不断跳到各个节点然后操纵节点的右指针指向下个元素，而让下个元素的左指针指向该节点
    }
    ************************************************************************************************
    class Node { 
    int data; 
    Node next, prev; 
  
       Node(int d){ 
          data = d; 
          next = prev = null; 
       } 
    }
    class LinkedList 
{ 
    Node head; 
  
    /* This function counts the number of nodes in Linked List 
       and then calls sortedListToBSTRecur() to construct BST */
    Node sortedListToBST() 
    { 
        /*Count the number of nodes in Linked List */
        int n = countNodes(head); 
  
        /* Construct BST */
        return sortedListToBSTRecur(n); 
    } 
  
    /* The main function that constructs balanced BST and 
       returns root of it. 
       n  --> No. of nodes in the Doubly Linked List */
    Node sortedListToBSTRecur(int n) 
    { 
        /* Base Case */
        if (n <= 0) 
            return null; 
  
        /* Recursively construct the left subtree */
        Node left = sortedListToBSTRecur(n / 2); 
  
        /* head_ref now refers to middle node, 
           make middle node as root of BST*/
        Node root = head; 
  
        // Set pointer to left subtree 
        root.prev = left; 
  
        /* Change head pointer of Linked List for parent 
           recursive calls */
        head = head.next; 
  
        /* Recursively construct the right subtree and link it 
           with root. The number of nodes in right subtree  is 
           total nodes - nodes in left subtree - 1 (for root) */
        root.next = sortedListToBSTRecur(n - n / 2 - 1); 
  
        return root; 
    } 
  
    /* UTILITY FUNCTIONS */
    /* A utility function that returns count of nodes in a 
       given Linked List */
    int countNodes(Node head) 
    { 
        int count = 0; 
        Node temp = head; 
        while (temp != null) 
        { 
            temp = temp.next; 
            count++; 
        } 
        return count; 
    } 
  
    /* Function to insert a node at the beginging of 
       the Doubly Linked List */
    void push(int new_data) 
    { 
        /* allocate node */
        Node new_node = new Node(new_data); 
  
        /* since we are adding at the begining, 
           prev is always NULL */
        new_node.prev = null; 
  
        /* link the old list off the new node */
        new_node.next = head; 
  
        /* change prev of head node to new node */
        if (head != null) 
            head.prev = new_node; 
  
        /* move the head to point to the new node */
        head = new_node; 
    } 
  
    /* Function to print nodes in a given linked list */
    void printList() 
    { 
        Node node = head; 
        while (node != null) 
        { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
  
    /* A utility function to print preorder traversal of BST */
    void preOrder(Node node) 
    { 
        if (node == null) 
            return; 
        System.out.print(node.data + " "); 
        preOrder(node.prev); 
        preOrder(node.next); 
    } 
  
    /* Drier program to test above functions */
    public static void main(String[] args) 
    { 
        LinkedList llist = new LinkedList(); 
  
        /* Let us create a sorted linked list to test the functions 
           Created linked list will be 7->6->5->4->3->2->1 */
        llist.push(7); 
        llist.push(6); 
        llist.push(5); 
        llist.push(4); 
        llist.push(3); 
        llist.push(2); 
        llist.push(1); 
  
        System.out.println("Given Linked List "); 
        llist.printList(); 
  
        /* Convert List to BST */
        Node root = llist.sortedListToBST(); 
        System.out.println(""); 
        System.out.println("Pre-Order Traversal of constructed BST "); 
        llist.preOrder(root); 
    } 
} 
