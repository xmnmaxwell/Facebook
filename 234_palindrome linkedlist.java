find the middle point of list, reverse from middle point, compare first half and second half are the same
***************************************************************
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        /*find middle point of liked list*/
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = reverseList(slow);
        while (head != slow) {
            if (head.val != tail.val) {return false;}
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode p = head, newHead = null;
        while (p!= null){
            ListNode temp = p.next;
            p.next = newHead;
            newHead = p;
            p = temp;
        }
        return newHead;
        
    }
}
