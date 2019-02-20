703. Kth Largest Element in a Stream
O(nlogk)
在一个流动的数据中找到返回第k大的数 定义一个k size的minHeap,如果pq没满继续加，满了就比较头
和新加入的谁大，val大就替换掉pq 的头
class KthLargest {
    final PriorityQueue<Integer> q;
    // define pq to store the data streaming with orders
    final int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);// define a new pq with the size k.
        for (int n : nums){
             if(q.size() < k){
                q.offer(n);
            } else if (q.peek() < n){
                q.poll();
                q.offer(n);
            } //this add function add n with ascending orders
        }
        
    }
    
    public int add(int val) {
        if (q.size() < k){
            q.offer(val); // if the q size is less than k, we add that val in q 
        } else if (q.peek() < val){
        //q.peek is the kth largest number, if q.peek<val, replace with val
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}
