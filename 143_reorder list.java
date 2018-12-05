Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

// 先找到中点，再把中点后的reverse一下,最后merge
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return ; // notice 边界条件
        ListNode middle = findMiddle(head);
        ListNode left = reverse(middle.next);
        middle.next = null;//断开连接
        ListNode right = head;
        merge(right, left);
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int count = 1;
        while (l1 != null && l2 !=null){
            if(count % 2 != 0){
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
            count++;
        }
        if (l1 != null){
            head.next = l1;
        } else if (l2 != null){
            head.next = l2;
        }
        return dummy.next;
    }
}
