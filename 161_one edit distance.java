Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
********************************************************************************************
O(n)
 public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++){
            if (s.charAt(i) != t.charAt(i)){
                if (s.length() == t.length())//如果长度相同只能replace
                    return s.substring(i+1).equals(t.substring(i+1));
                else if (s.length() < t.length())
                    return s.substring(i).equals(t.substring(i+1));//t长度更长证明只能删t
                else 
                    return t.substring(i).equals(s.substring(i+1));//s更长只能删s
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
        //如果前面都一样，，还有种情况 abc abccc所以要判断两者长度是否为1
    }
