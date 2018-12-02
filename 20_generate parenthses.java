20. generate parenthses 输入为n，有n队括号罗列所有可能的组合 backtracking
遍历顺序是((())), (()()), (())(), ()(()), ()()()
public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int lp, int rp, int max){
        // 如果str的个数为n的两倍说明括号排满了
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(lp < max)
            backtrack(list, str+"(", lp+1, rp, max);
        if(rp < lp)
            backtrack(list, str+")", lp, rp+1, max);
    }
