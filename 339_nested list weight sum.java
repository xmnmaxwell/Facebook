 Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 Input: [1,[4,[6]]]
Output: 27 

Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    private int helper(List<NestedInteger> list, int depth){
        int res = 0;
        for (NestedInteger e : list){
            res += e.isInteger() ? e.getInteger() * depth : helper(e.getList(), depth+1);//我们get出来的是数字直接乘以深度，如果不是getlist
        }
        return res;
    }
    ******************************************************************
    自己打印出来
    class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> lists, int depth) {
        int sum = 0;
        for (int i = 0; i < lists.size(); i ++) {
            NestedInteger list = lists.get(i);
            
            if (depth > 1 && i == 0) System.out.print("(");
            if (i > 0) System.out.print(" + ");
            
            if (list.isInteger()) {
                sum += list.getInteger() * depth;
                System.out.print(list.getInteger());
            } else sum += helper(list.getList(), depth + 1);
            
            if (depth > 1 && i == lists.size() - 1)
                System.out.print(") * " + depth);
        }
        return sum;
    }
