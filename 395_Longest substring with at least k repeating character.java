395. Longest substring with at least k repeating character
O(n);
Input:
s = "ababdbc", k = 2 找到最长子字符串至少有 k 个, a两次b三次一共五次
Output:
5
// 要求的是substring，因此，如果发现一个string中间有一个char是小于k次的，那么最长的substring只可能是这个char左右两边的两个substring
//第一步，统计当前string中每个字符出现的次数，用少于k次的字符作为分隔符，把string分割成几个substring，只有这些substring才有可能是满足条件的substring
//第二步，recurse on substrings，找到结果中最大的一个即可
//终止条件：substring长度已经小于k，substring已空，或 k<=1的时候都可以直接返回确定值了

public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (k <= 1) return s.length();
        if (s.length() < k) return 0; // dealing with some corner case
        // create a hashmap tp store every char in string and its frequency
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        } // a 2, b 2, c 1, d 1
        // create a stringbuilder, find char with less than k times, replace with ','
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < k) {
                sb.setCharAt(i, ',');
            }
        }// abab,b,
        String[] strings = sb.toString().split(",");// abab, b
        if (strings.length == 1) return strings[0].length();//if there is only one
        int longest = 0;
        for (String st: strings) {
            longest = Math.max(longest, longestSubstring(st, k));
        }
        return longest;
    }
