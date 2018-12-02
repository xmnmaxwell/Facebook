347. Top k frequent elements 找到数组中前k个最大出现的概率
O(n)
Input: nums = [1,1,1,2,2,3], k = 2 //1 出现3次，2 出现2次，所以top2就是1和2
Output: [1,2]
  public List<Integer> topKFrequent(int[] nums, int k) {
        
        //1122234445 k = 2
        // create bucket array to record the frequency of certain number, there are n+1 possibilities
        List<Integer>[] bucket = new ArrayList[nums.length+1];//频率最大是nums的个数,出现的频率为0,1,2...nums.length
        Map<Integer, Integer> map = new HashMap<>();// use hashmap to store number and its frequency
        
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        // 1 2, 2 3, 3 1, 4 3, 5 1
        
        for (int key : map.keySet()){ // search the map
            int freq = map.get(key); // get the frequncy
            if (bucket[freq] == null){ // if bucket[fre] has no number, create a new arraylist
                bucket[freq] = new ArrayList<Integer>();// bucket[2] 1, bucket[3] 2 4, bucket[1] 3 5
            }
            bucket[freq].add(key);// add number in the bucket[freq]
        }
        
        List<Integer> res = new ArrayList<>();// create answer list
        // pos start position is all the element is the same, and also need to check res list size is less than k.
        for (int pos = nums.length; pos >=0 && res.size() < k; pos--){ //bucket.len-1就是最大出现的次数即全是一个元素
            if (bucket[pos] != null){ // if pos frequency is not empty, add all the elements
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
