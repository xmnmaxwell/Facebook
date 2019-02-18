92. Reverse LinkedList II （链表翻转，指定 mn位置）
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);// create a dummy node
        dummy.next = head;//dummy.next points to head
        ListNode prev = dummy;// create a pointer
        
        for (int i = 1; i < m; i++){
            if (prev==null) return null; // if not enough length return null
            prev = prev.next;    // move prev to the m posiiton pre -> 1 
        }
        ListNode premNode = prev;// fix pointer premNode -> 1
        ListNode mNode = prev.next; // moving pointer mNode -> 2
        
        ListNode nNode = mNode; //nNode ->2
        ListNode postnNode = mNode.next; // postNode -> 3
        for (int i = m; i < n; i++){ // 2->3->4 change to 4->3->2            
        	if(postnNode == null) return null;
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        premNode.next = nNode; //1 -> 4 
        mNode.next = postnNode; // 2 -> 5
        return dummy.next;
    }
