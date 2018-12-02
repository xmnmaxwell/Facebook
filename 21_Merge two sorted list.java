21. Merge two sorted list 合并两个排序链表
O(m+n)
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);// create a dummy node
        ListNode head = dummy;// define a pointer head to dummy
        while(l1 != null && l2 != null) {// while l1 and l2 are not null
            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
         if (l1 == null) {// if either l1 and l2 is not null
             head.next = l2; 
             } else if (l2 == null){
             head.next = l1;   
         }
        return dummy.next;
    }
