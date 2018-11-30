valid Palindrome 验证一个句子是不是回文串，除数字字母以外的字符都可忽略
O(n) time O(1) space
Input: "A man, a plan, a canal: Panama" -> "amanaplanacanalpanama"
Output: true

public boolean isPalindrome(String s) {
   if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;// define two pointers
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);// find the char in index head and tail
        	cTail = s.charAt(tail);
          
        	if (!Character.isLetterOrDigit(cHead)) {// if is not letter or digit skip
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {// if is not letter or digit skip
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;// if two ends char are not same return false
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
