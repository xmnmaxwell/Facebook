282. expression add operation 给一组数字加减乘得到目标数
This problem has a lot of edge cases to be considered:
worst case O(n^3) space worst O(n)
overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
a little trick is that we should save the value that is to be multiplied in the next recursion.

 void dfs(String num, int target, int start, String str, long sum, long lastF, List<String> ans) {
        if (start == num.length()) {
            if (sum == target) {
                ans.add(str);
            }
            return;
        }
        for (int i = start; i < num.length(); i++) {
            long x = Long.parseLong(num.substring(start, i + 1));

            if (start == 0) {
                dfs(num, target, i + 1, "" + x, x, x, ans);
            } else {
                dfs(num, target, i + 1, str + "*" + x, sum - lastF + lastF * x, lastF * x, ans);
                dfs(num, target, i + 1, str + "+" + x, sum + x, x, ans);
                dfs(num, target, i + 1, str + "-" + x, sum - x, -x, ans);
            }
            if (x == 0) {
                break;
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        // Write your code here
        List<String> ans = new ArrayList<>();
        dfs(num, target, 0, "", 0, 0, ans);
        return ans;
    }
    ******************************************************************************************
    简单版只有+-
      public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<String>();
        search(0, 0, target, "", num, ans);
        return ans;
    }
    
    private void search(int index, long sum, int target, String prefix, String s, List<String> ans) {
        if (index == s.length()) {
            if (sum == target)
                ans.add(prefix);
            return;
        }
        
        long num = 0;
        for (int i = index; i < s.length(); i ++) {
            num = num * 10 + s.charAt(i) - '0';
            if (index == 0)
                search(i + 1, num, target, "" + num, s, ans);
            else {
                search(i + 1, sum + num, target, prefix + "+" + num, s, ans);
                search(i + 1, sum - num, target, prefix + "-" + num, s, ans);
            }
            if (num == 0) break;
        }
    }
