692. top k frequent words 找到字符串组中前k个最高频率出现的单词
//Map.entry 是一个map声明的接口，表示map中的一个实体，有getKey() getValue()方法
O(nlogk) O(n) space
public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        //use hashmap to store the words and its frequency
        for(int i=0; i<words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        // create a min heap 
        // in the comparator we defined, 
        // if the value is the same try to order the words through alphebetical order
        // if not, always put the smaller on in the top of the queue.

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
        	(a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        //traverse the map, add entry in the pq, if the size is larger than k, poll
        // the top element
        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
        	//0的意思是反向添加，先进去的放后面, list.add(0,a)把新来的a插入0位置
            result.add(0, pq.poll().getKey());
        
        return result;
    }
