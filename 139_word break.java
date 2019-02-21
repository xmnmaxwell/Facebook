139. Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s c
an be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Time complexity : O(n^2)
Space complexity : O(n). Length of pp array is n+1.

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];//until now whether current string match the word in dict.
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
***********************************************************************
140. print all combination
O(n3) O(n3)
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String>[] dp = new ArrayList[s.length() + 1]; 
        //used to store every possible sentence having all valid dictionary words using the substring s[0:k-1]
        List<String> initial = new ArrayList<>();
        initial.add("");// initialize
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            List<String> list = new ArrayList<>();//store until i, valid words between (0,i) substring
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    //we have valid 
                    for (String str : dp[j]) {
                        list.add(str + (str.equals("") ? "" : " ") + s.substring(j, i));
                        //if str does not exist, use "" instead
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }
}
