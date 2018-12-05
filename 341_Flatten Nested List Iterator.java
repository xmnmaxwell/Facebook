Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
             
A question before this is the Nested List Weight Sum, and it requires recursion to solve. 
As it carries to this problem that we will need recursion to solve it. 
But since we need to access each NestedInteger at a time, we will use a stack to help.
In the constructor, we push all the nestedList into the stack from back to front, so when we pop the stack, 
it returns the very first element. Second, in the hasNext() function, we peek the first element in stack currently, 
and if it is an Integer, we will return true and pop the element. If it is a list, we will further flatten it. 
This is iterative version of flatting the nested list. Again, we need to iterate from the back to front of the list.
Time Complexity : next - O(1), hasNext - O(m) : m is average size of nested list, Constructor : O(n) - size of input list
// new 
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i --)
            stack.push(nestedList.get(i));  // 从后往前放入栈里，先放[4,[6]]， 再放1
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();//如果hasNext valid pop出来1
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> cur = stack.pop().getList();//这时候是[4,[6]]
            for (int i = cur.size() - 1; i >= 0; i --)//栈里是[6], 4
                stack.push(cur.get(i));
        }
        return !stack.isEmpty();
    }
}
