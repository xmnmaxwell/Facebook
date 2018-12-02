678. valid parentesis string  验证括号，这回加上*，*表示左括号， 右括号或者空
 worst O(3^n), 
 public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }
    // write a funtion to determin if it is valid,
    //here count represent the invalid parenthesis
    //if count > 0, left p are more count < 0, right are more it is false
    private boolean check(String s, int start, int count) {
        if (count < 0) return false;
        
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                if (count <= 0) return false;
                count--;
            }
            else if (c == '*') {// three cases: add l p/add r p/add nothing 
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }
        
        return count == 0;
    }  
O(n^2)  DP解法可以优化
private Boolean[][] dp;
    public boolean checkValidString(String s) {
        dp = new Boolean[s.length() + 1][s.length() + 1];
        return check(s, 0, 0);
    }
    private boolean check(String s, int start, int count) {
        if (count < 0) return false;
        int y = count;
        if (dp[start][y] != null) return dp[start][y];
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count <= 0) return false;
                count--;
            } else if (c == '*') {
                dp[start][y] = (check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count));
                return dp[start][y];
            }
        }
        dp[start][y] = (count == 0);
        return dp[start][y];
    }    
