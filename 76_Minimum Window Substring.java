两个字符串，找到字符串s中最短的包含target其的anagram的字符串，返回该最小字符串
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

O(n)
 public String minWindow(String s, String t) {
        if(t.length()> s.length() || s == null || t === null) return ""; // deal with exception case
        Map<Character, Integer> map = new HashMap<>();// create a map to store the characters in t and its frequency
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int counter = map.size();// we get the size of whole map
        
        int begin = 0, end = 0;// define two pointers
        int head = 0;// define the min window start position
        int len = Integer.MAX_VALUE;// define minimum len
        
        while(end < s.length()){
            char c = s.charAt(end);//先移动end指针
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);//如果在map里，map该char的value-1
                if(map.get(c) == 0) counter--;//如果value为0，说明匹配完全，counter里减掉这个char
            }
            end++;
            // if counter为0说明t里的字符全部被匹配掉了，所以从(start, end)我们已经找到了满足要求的子字符串开始移动start指针看能否缩短
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){//即使map里为0，key还在
                    map.put(tempc, map.get(tempc) + 1);//map里key的value+1
                    if(map.get(tempc) > 0){
                        counter++;//如果发现value>0, counter++
                    }
                }
                if(end-begin < len){// 如果end - begin比len小，更新len,用head记录当前最小长度的start
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }
            
        }
        if(len == Integer.MAX_VALUE) return "";//说明没找到匹配的字符
        return s.substring(head, head+len);
    }
