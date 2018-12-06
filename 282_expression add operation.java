282. expression add operation 给一组数字加减乘得到目标数
This problem has a lot of edge cases to be considered:
worst case O(n^3) space worst O(n)
overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
a little trick is that we should save the value that is to be multiplied in the next recursion.

Time complexity for considering all operators for all operands, O(3^N). This is O(3^N)because in the worst case scenario, 
each digit will be an operand on its own for a single expression and between every adjacent pair of digits
we have 3 different choices for operators.
Also, for each recursive call we have a for loop to consider successive digits as a single operand. 
That raises the total number of recursive calls to O(N \times 3^N)O(N×3 
For the base case we use a StringBuilder::toString operation in Java and .
join() operation in Python and that takes O(N)O(N) time. Here N represents the length of our expression. 
In the worst case, each digit would be an operand and we would have NN digits and N - 1N−1 operators. 
So O(N)O(N). This is for one expression. In the worst case, we can have O(N^2 \times 3^N)O(N 
 valid expressions.
Overall time complexity = O(N^2 \times 3^N).

// 0 2 3 4 5 24
//input nums, target value, start index, temp string we use to print. the sum and last formed number, and answer list
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
                dfs(num, target, i + 1, "" + x, x, x, ans);//
            } else {
                dfs(num, target, i + 1, str + "*" + x, sum - lastF + lastF * x, lastF * x, ans);
                //12+2*3, last word is 2, the sum has add 2, 程序不知道后面有没有乘法，所以要减2再加上2*3
                dfs(num, target, i + 1, str + "+" + x, sum + x, x, ans);
                dfs(num, target, i + 1, str + "-" + x, sum - x, -x, ans);
            }
            if (x == 0) {
                break;//break 0 是只进行一次循环就是当0只做为一个独立的个体时候，因为后续的都没用了。
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
