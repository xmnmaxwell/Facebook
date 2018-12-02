32. longgest valid parenthesis 给一个字符串找最长的有效括号返回长度
))))((())))
O(n) space : worst case O(n)
public int longestValidParentheses(String str) {
        if (str == null) {
            return 0;
        }
        int n = str.length();
        if (n == 0) {
            return 0;
        }
        int res = 0;
        本质建立一个栈，如果没有配对的右括号无脑放，看到左括号也无脑放
        除非遇到右括号，此时栈不空且有左括号可以配对，返回i-stack.peek值即为
        即时的最大长度，不断和res比较取最大值就可得到最大长度。
        // stack store the index of lef p and right p waiting for matchig
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                st.push(i);//左括号直接记录下标
            } else {  //如果找到了右括号
                if (st.empty()) {// 如果stack空
                    st.push(i);//放入stack
                } else {// 如果stack不空
                    if (str.charAt(st.peek()) == '(') {
                        st.pop();
                        res = Math.max(res, i - (st.empty() ? -1 : st.peek()));
                    } else {
                        st.push(i);
                    }
                }
            }
        }
        return res;
    }
