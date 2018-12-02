public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int i = 0, j = height.length;
        while(i < j){
            if (stack.isEmpty() || height[i] <= height[stack.peek()]){//这句话是保证潜在bottom永远比栈顶元素小才有可能形成坑
                stack.push(i++);
            } else {//代表后面的元素比目前的栈顶元素大，这样bottom比两边都小所以形成了坑
                int bottom = stack.pop();
                if(stack.isEmpty()) continue; //如果bottom 后面没有栈元素了，那形成不了坑 
                sum += (Math.min(height[i], height[stack.peek()]) - height[bottom]) * (i - stack.peek() - 1);// 坑的左右两面的高度的最小值减去bottom然后乘以两面高度的的坐标的差减一。
            }
        }
        return sum;
    }
