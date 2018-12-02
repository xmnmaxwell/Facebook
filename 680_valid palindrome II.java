680. valid palindrome II 一个字符串只允许删掉一个字母是否是回文串
O(n) 
Input: "abca" 删掉 b 是回文串
Output: True
Explanation: You could delete the character 'c'.
public boolean validPalindrome(String s) {
       int i = 0, j = s.length()-1;
        while (i < j){
            if (s.charAt(i) == s.charAt(j)){ // to check palindrome
                i++;
                j--;
            } else {
                return isValid(s, i, j-1) || isValid(s, i+1, j); 
            }
        }
        return true;
    }
    // write a function to check if is palinrome
    public boolean isValid(String s, int l, int r){
        while (l < r){
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
     }
