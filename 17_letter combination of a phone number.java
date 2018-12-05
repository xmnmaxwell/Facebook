Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        char[] chars = digits.toCharArray();
        
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() == 0) return res;
        helper(res, phone, digits, "", digits.length(), 0);
        return res;
    }
    private void helper(List<String> res, String[] phone, String digits, String str, int l, int index){
        if (index == l) {
            res.add(str);
            return;
        }
        int d = digits.charAt(index) - '0';
        for (char c : phone[d].toCharArray()){
            helper(res, phone, digits, str + c, l, index + 1);
        }
    }
}
