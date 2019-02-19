s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
**********************************************************************************
public class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>(); // get number
        Stack<String> result = new Stack<>(); // get answer
        int i = 0;
        result.push(""); // make sure the pop element is string
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') { //find number
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++; //if 32[a]
                count.push(Integer.parseInt(s.substring(start, i + 1))); //push number in count stack  
            } else if (ch == '[') {
                result.push(""); // make sure the pop element is string
            } else if (ch == ']') { // means we can extract the charates
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop(); // get the number 
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());  // in result, there is only one word.
            } else {
                result.push(result.pop() + ch);
            }
            i += 1;
        }
        return result.pop();
    }
}
