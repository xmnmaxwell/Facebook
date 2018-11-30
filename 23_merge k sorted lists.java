Merge k sorted list 合并 k 个链表
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
space: O(k), time: O(nlogk)

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;// deal with corner case
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
        public int compare(ListNode o1, ListNode o2){
            if (o1 == null) return 1;
            else if (o2 == null)  return -1;
            return o1.val - o2.val;//返回值小于0就放前面；order the val in the ascending order
        }
        });// 定义k个坑。

        for (int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                heap.add(lists[i]);// add the head of all the linkedlist in the heap and make orders in comparator
            }
        }
        ListNode dummy = new ListNode(0); //create dummy node
        ListNode tail = dummy; //arrage tail pointer 
        while(!heap.isEmpty()){
            ListNode head = heap.poll();// arrange a head pointer to get the top element in the heap 1.
            tail.next = head;//tail->1, 
            tail = head;// tail move to head
            if(head.next != null){ //while 1 has been poll out, if the next is not null, in this case 4 move to the heap
                heap.add(head.next);// put the head.next(4) in the heap
            }
        }
        return dummy.next;
    }
