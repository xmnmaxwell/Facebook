3. longest substring without repeating characters
O(n)
Input: "abcabcbb" 最长无重复的子字符串的长度， abc长度为3
Output: 3
 public int lengthOfLongestSubstring(String s) {
        int res = 0, left =0, right =0;
        // define the length, two pointers
        HashSet<Character> t = new HashSet<Character>();
        //create hashset to store the current maximum substring
        while (right <s.length()){// right pointers move first
            if (!t.contains(s.charAt(right))){
            	// if t does not contain charAt(right)
                t.add(s.charAt(right++));//add it 
                res = Math.max(res, t.size());// update res.
            } else{
            	// if contains, remove the left element, left pointer++
                t.remove(s.charAt(left++));
            }
        }
        return res;
    }
