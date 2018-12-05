Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

DFS:
class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0)
            return (s == null || s.length() == 0);
        if (p.length() == 1 || p.charAt(1) != '*')
            return (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') &&
                isMatch(s.substring(1), p.substring(1)));
        return (isMatch(s, p.substring(2)) || 
                (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p)));
    }
