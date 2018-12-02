109. Convert Sorted List to Binary Search Tree 把排序链表转化为BST
Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
Time Complexity: The recursive part is O(n), because T(n)=2T(n/2)+O(1). And in each recursive call, faster pointer traverse full list of logn, which leads to O(nlogn). So the total Time Complexity is O(nlogn).
Space Complexity: O(logn)
O(nlogn)  O(logn) 

class Solution {
     public TreeNode sortedListToBST(ListNode head) {
    if(head==null) return null;
    return toBST(head,null);
}
  public TreeNode toBST(ListNode head, ListNode tail){
    ListNode slow = head;
    ListNode fast = head;
    if(head==tail) return null;
    
    while(fast!=tail&&fast.next!=tail){
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode thead = new TreeNode(slow.val);
    thead.left = toBST(head,slow);
    thead.right = toBST(slow.next,tail);
    return thead;
}
}
