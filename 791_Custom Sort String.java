S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
************************************************************************************************************************
class Solution {
    public String customSortString(String S, String T) {
        int[] bucket = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c: T.toCharArray()) bucket[c-'a']++;// bucket存储每个字母的频率
        
        for (char c: S.toCharArray()){
            for (int i = 0; i < bucket[c-'a']; i++){
                sb.append(c); //按S的顺序，把桶里面的字母都放进sb里
            }
            bucket[c-'a'] = 0; //放完桶被清零
        }
        
        for (int i = 0; i < 26; i++){
            for (int j = 0; j < bucket[i]; j++){
                sb.append((char) ( 'a'+ i));// 将桶里面没有清零的字母再放进sb里
            }
        }
        return sb.toString();
    }
}
