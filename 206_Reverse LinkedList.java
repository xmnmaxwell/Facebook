206. Reverse LinkedList 链表翻转（迭代， 递归）
iteration:
public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = null;
        while(head != null){
            ListNode temp = head.next;// create a temp to store head.next address(store 2)
            head.next = newHead; // head.next can point to prev address after store head.next address(1 point to null)
            newHead = head;//  prev pointers point to head for next iteration()
            head = temp; 
        }
        return newHead;
    }
recursion:
public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode temp = head.next;
        ListNode newHead = reverseList(temp);
        temp.next = head;
        head.next = null;
        return newHead;
    }
