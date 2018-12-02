find all anagrams in a string
O(n)
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
找到一个单词 t 里所有和 s anagram的字符串的起始index

这道题思路是通用模板是先看特例，再新建一个hashmap，key是字符，value是字符出现的次数
count来记录多少不同字母出现在target里，在建立两个指针。end指针先扫，出现了在map里的
字母，value减一，直到value为0证明某个字母已经匹配全了，count减一，当count变为0之后
说明所有字符及个数已经匹配好了，当count=0时，新建一个temp存储start指针，temp如果是
map里的map的这个字母frequency+1， count+1，检查长度是否和p的长度一样，一样就说明找
到了。 此时重新循环
public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);  //将p里的字母和出现次数记录在map里 
        }
        int count = map.size();
        int start = 0, end = 0;
        
        while (end < s.length()){
            char c = s.charAt(end);
            if (map.containsKey(c)){
                map.put(c, map.get(c)-1);//s里出现一次，value减一
                if (map.get(c) == 0) count--;// value减到0说明一个字母已经匹配完了，count-1
            }
            end++;
            
            while(count == 0){
                char temp = s.charAt(start);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp)+1);//如果start包含了map里的字母，value+1，count+1 是为了新一轮的匹配这步是新一轮做准备的
                    if (map.get(temp) > 0) count++; 
                }
                if (end-start == p.length()){// end和start差值是p的长度说明找到了
                    res.add(start);
                }
                start++;
            }
        }
        return res;
    }
    ***************************************************************************************************************
    class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[26];
        int count = 0;
        for (char ch : p.toCharArray())
            if (++ cnt[ch - 'a'] == 1)
                count ++;
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (-- cnt[ch - 'a'] == 0) count --;
            if (i - p.length() >= 0)
                if (++ cnt[s.charAt(i - p.length()) - 'a'] == 1)
                    count ++;
            if (count == 0) ans.add(i - p.length() + 1);
        }
        return ans;
    }
}
