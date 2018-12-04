29. Divide two integers
Input: dividend = 10, divisor = 3
Output: 3
within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
O(log(dividend))
这道题主要考察数据溢出的问题，首先一种情况是除数有可能是min，被除数-1，这得到是max+1 数据溢出
排除这种情况，还有就是除数为0

将除数被除数变成long型，初始化shift为0，将shift调到最大使得  a>= b*2^shift and a < b*2^(shift+1)
a = 28, b = 3, shift = 1, res = 1
    

 public int divide(int dividend, int divisor) {
       if (dividend == 0) {
           return 0;
       }
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean isNegative = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor>0));
        long a = Math.abs((long)dividend); // a 是min，但按这个算法，a就变成max了，要用long型
        long b = Math.abs((long) divisor); // b总要向前移一位有可能会数据溢出所以要用long型
        int res = 0;
        while (a >= b){ // a = 25
            int shift = 0;
            while (a >= (b << shift)){ //if the remaining of a is still larger than b*2^shift
                shift++; 28>3, shift: 1/ 28>6, shift:2 / 28>12, shift:3 / 28>24, shift:4
            }
            a -= b << (shift-1);// a要减去没移前的位数 // b<<(4-1) = 24
            res += 1 << (shift - 1); // res = 8,
        }
     return res = isNegative ? -res : res;
    }
