20. valid parentheses     验证括号是否是valid，就是有一个左的必须有一个右的
O(n) space O(n)((((((
public boolean isValid(String s) {
        char[] strs =s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character str : strs){
            if(str == '('){
                stack.push(')');
            } else if (str == '['){
                stack.push(']');
            } else if (str == '{'){
                stack.push('}');//遇到一个左括号，就把右括号放进栈里，根据栈的特性，当遇到不是左括号时，栈顶的元素一定时最后一个左括号对应的右括号
            } else {
                if (stack.isEmpty() || stack.pop() != str){
                    return false;//如果未遍历完栈空了，或者pop出的不是元素则是false
                }
            }
        }
        return stack.isEmpty(); //最后根据对称性，栈应该是空的
    }
