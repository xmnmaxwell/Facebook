227. basic Calculator 不加括号 实现加减乘除，里面有空格
// String/stack
    //3+5-4/6, 先在第一个数前加+，因为不可能是负数，所以sign是+
    //步骤是 3 +? -> +3,0, 5 +? -> +5, 0
    public int calculate(String s) {
       if (s == null || s.length() == 0) return 0;
       Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        
        for (int i = 0; i < s.length(); i++){
            char c =s.charAt(i);
            if (Character.isDigit(c)){
            num = num*10 + c -'0'; //if 一直检测数字，就一直叠加
            }// 累加数字
            if (c!=' ' && !Character.isDigit(c) || i + 1 == s.length()){
                if (sign == '+'){ //这里所有的符号都是前一次的，并不是现在的
                    stack.push(num);
                } else if (sign == '-'){
                    stack.push(-num);
                } else if (sign == '/'){
                    stack.push(stack.pop() / num);
                } else if (sign == '*'){
                    stack.push(stack.pop() * num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
