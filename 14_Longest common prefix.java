14. Longest common prefix
O(n*k)
单词的最长公共前缀
Input: ["flower","flow","flight"]
Output: "fl"
 public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";// corner case
        if (strs.length == 1) return strs[0];// there is only one string
        String res = strs[0]; // random pick a str
        for (int i = 0; i < res.length(); i++){ // search from 0 to strs[0].length
            for (int j = 1; j < strs.length; j++){ // compared with rest elements in the strs
                if (!(i < strs[j].length() && res.charAt(i) == strs[j].charAt(i)))
                //compare with each elements until it did not meet i < length of strs[j] and res.charAt(i) == strs[j].charAt(i)
                return res = res.substring(0,i);    
            }
        }
        return res;
  }
