647. Palindromic substring 回文串子串
O(n^2)
Input: "aaa" 回文子串的数量
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa"
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        // we search every element in the string use it as mid point to extend 
        int count = 0;
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            count += extendPalindrome(s, i, i); // odd length;
            count += extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private int extendPalindrome(String s, int left, int right) {
    	int count = 0;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
        return count;
    }
