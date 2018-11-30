Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

我的思路是首先找到括号中多余的 '( '和 ‘)’的数目， 分别为l 和 r 然后DFS， 
dfs(res, s, l, r, start)其中start为删除指针起点 dfs内有for loop每次
遍历一个字符，start 开始看string 的字符，如果发现不是括号就跳过，如果发现是括号但是是前面
已经出现过的，也跳过，因为遇到连续相同的括号时候只要删掉第一个就可以达到效果
如果发现是左括号，那么如果l > 0，那么就在Sring上操作把这个括号删了，然后start指针转移到被删括号的下一个位置，继续递归操作删除括号。右括号同理。
递归的控制条件是 r == 0 && l == 0 && 此时的s 是一个有效的括号组
判断有效就是整个字符串的前部分必须左括号大于等于右括号，凡是出现右括号多的情况肯定不是有效，最后再看看整体左右括号是否相等
时间复杂度就是O 2^(l + r)  2 power of (l+r)
public List<String> removeInvalidParentheses(String s) {
    O(nm) m是total recursion call 
        List<String> results = new ArrayList<>();
        int[] res = getLeftRightCount(s);//得到的是多余的括号 不valid的
        dfs(s, 0, res[0], res[1], results);//input: string, index, invalid left, invalid right, res 
        
        return results;
    }
    private void dfs(String s, int startIndex, int leftCount, int rightCount, List<String> results){
       if(leftCount == 0 && rightCount == 0 && isStringValid(s)) {
            results.add(s);  //check the terminate condition add it in the list
            return;
        } 
         for(int i = startIndex; i < s.length(); i++) {
            if(i > startIndex && s.charAt(i) == s.charAt(i - 1)) { // ((()) we only need to reomve the first p, we just skip the same 
                continue;
            }
            
            if(leftCount > 0 && s.charAt(i) == '(') {// if the invalid leftcout> 0, we encounter the (, we delete it with leftcount -1 
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount - 1, rightCount, results);
            }
            
            if(rightCount > 0 && s.charAt(i) == ')') {//if invalid rightcount >0. we encounter the ), we delete it with rightcout-1
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount, rightCount - 1, results);
            }
        }
    }
    // if string is valid, both res[0],res[1] should be 0
    private boolean isStringValid(String s){
        int[] result = getLeftRightCount(s);
        return result[0] == 0 && result[1] == 0;
    } 
    //define function for invalid count the left and right 括号 
    ))()( count[0] 1 count[1] 2
    ()())     count[0] 0 count[1] 1
    ((())     count[0] 1 count[1] 0
    private int[] getLeftRightCount(String s) {
        int[] count = new int[]{0, 0};
        for (char c : s.toCharArray()){
            if (c == '(') count[0]++;
            if (c == ')') {
                if (count[0] > 0) {
                    count[0]--;
                } else {
                    count[1]++;
                }
            }
        }
        return count;
    }
