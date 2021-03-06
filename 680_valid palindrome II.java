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
**********************************************************************************************
在一个字符串里找到一个某一个字母使得删掉它就变成回文串了
int possiblePalinByRemovingOneChar(string str) 
{ 
    //  Initialize low and right by both the ends of the string 
    int low = 0, high = str.length() - 1; 
  
    //  loop untill low and high cross each other 
    while (low < high) 
    { 
        // If both characters are equal then move both pointer 
        // towards end 
        if (str[low] == str[high]) 
        { 
            low++; 
            high--; 
        } 
        else
        { 
            /*  If removing str[low] makes the whole string palindrome. 
                We basically check if substring str[low+1..high] is 
                palindrome or not. */
            if (isPalindrome(str.begin() + low + 1, str.begin() + high)) 
                return low; 
  
            /*  If removing str[high] makes the whole string palindrome 
                We basically check if substring str[low+1..high] is 
                palindrome or not. */
            if (isPalindrome(str.begin() + low, str.begin() + high - 1)) 
                return high; 
  
            return -1; 
        } 
    } 
  
    //  We reach here when complete string will be palindrome 
    //  if complete string is palindrome then return mid character 
    return -2; 
} 
