395. Longest substring with at least k repeating character
O(n);
Input:
s = "ababdbc", k = 2 找到最长子字符串至少有 k 个, a两次b三次一共五次
Output:
5
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
