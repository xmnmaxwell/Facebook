387_first unique character in a string.java
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

 public int firstUniqChar(String s) {
        int[] count = new int[26];
        int index = 0;
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
           if (count[s.charAt(i)- 'a'] == 1){
               index = i;
               return index;
           }
        }
        return -1;
    }
    
    //如果返回字符串，就Character.toString(s.charAt(i));
