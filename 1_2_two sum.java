1. two sum 
public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i){
                res[0] = i;
                res[1] = map.get(target-nums[i]);
            }
        }
        return res;    
    }
f2. add two numbers
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode ptr = res;
        int carry = 0;
        
        while (l1 != null || l2 != null){
            int m = (l1 != null) ? l1.val : 0;
            int n = (l2 != null) ? l2.val : 0;
            int sum = m + n + carry;
            carry = sum / 10;
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
            
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        if (carry == 1) ptr.next = new ListNode(1);
        return res.next;
    }
