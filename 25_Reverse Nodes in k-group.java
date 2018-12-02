25. Reverse Nodes in k-group 翻转链表 按 k 个分组翻转链表
O(n)
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);// create a dummy
        dummy.next = head; // connect dummy node with head
        ListNode prev = dummy;// prev pointer
        while (prev != null){
            prev = reverseGroup(prev, k);
        }
        return dummy.next;
    }// write a function to reverse every k nodes
    private ListNode reverseGroup(ListNode prev, int k){
        ListNode last = prev;// define a pointer last
        for(int i = 0; i < k + 1; i++){
            last = last.next; //last points to 3
            if (i != k && last == null) return null;
        }
        ListNode tail = prev.next; //tail ->1 connect the tail to next prev
        ListNode curr = prev.next.next;// curr->2
        while (curr != last){
            ListNode temp = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = temp; // reverse the k nodes
            tail.next = temp;// tail.next(1) connect to 3 
        }
        return tail;
    }
