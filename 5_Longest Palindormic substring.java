5. Longest Palindormic substring
O(n)
Input: "babad" 最长回文子串随便输出一个
Output: "bab"
 public String longestPalindrome(String s) {
      String res = "";
        int currLength = 0;
        //every time we move to right, we only need to consider whether
        //using this new character as tail could produce new palindrome string of length (current length +1) or (current length +2)
        for(int i=0;i<s.length();i++){
        	// check if i and i - currlength-1 could form palindrome
            if(isPalindrome(s,i-currLength-1,i)){              // d cfc->d ith element is equal to 
                res = s.substring(i-currLength-1,i+1);
                currLength = currLength+2;
            }
            // check if i plus original could form palindrome
            else if(isPalindrome(s,i-currLength,i)){          // aaa->a
                res = s.substring(i-currLength,i+1);
                currLength = currLength+1;
            }
        }
        return res;
    }
    //check if the string is palindrome 
    public boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        while(begin<end){
        	if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }
