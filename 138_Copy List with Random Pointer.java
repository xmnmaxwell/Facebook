A linked list is given such that each node contains an additional random pointer which could point to any node in the
list or null.
public RandomListNode copyRandomList(RandomListNode head) {
         if (head == null) return null;
  // key is original list, value is the new copied list
  Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
  
  // loop 1. copy all the nodes
  RandomListNode node = head;
  while (node != null) {
    map.put(node, new RandomListNode(node.label)); //copy the node val.
    node = node.next;
  }
  
  // loop 2. assign next and random pointers
  node = head;
  while (node != null) {
    map.get(node).next = map.get(node.next); // copy the next pointer
    map.get(node).random = map.get(node.random); // copy the random node
    node = node.next;
  }
  
  return map.get(head);

    }
