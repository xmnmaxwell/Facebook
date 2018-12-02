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
