242. valid anagram
O(n)
验证两个单词是不是anagram
 public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;// length is not equal, return false
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for (int n : count){
            if (n != 0)
                return false;
        }
       return true;
    }
