382. linkedlist random node
Given a singly linked list, return a random node's value from the linked list.
Each node must have the same probability of being chosen.

public class Solution {    
    ListNode head;
    Random random;
    
    public Solution(ListNode h) {
        head = h;       
        random = new Random();        
    }
    
    public int getRandom() {
        ListNode node = head;
        int r = node.val;
        for(int i = 1; node.next != null; i++){
            node = node.next;
            if(random.nextInt(i + 1) == i) r = node.val; // 1: 1*1/2*2/3, 2: 1/2*2/3, 3:1/3              
        }
        return r;
    }
}
