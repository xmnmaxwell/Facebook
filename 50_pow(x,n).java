50. pow(x,n) 
Logn
public double myPow(double x, int n) {
        boolean isNegative = false;
        if (n < 0){
            x = 1/x;
            isNegative = true;
            n = -(n+1);// handle overflow
        }
        double res = 1;
        double temp = x;
        while (n != 0){
            if (n % 2 == 1){
                res *= temp;//遇到奇数 需要把之前的2的倍数先乘以下.因为n/2 ，n为奇数的话需要把这个因子乘在res里才不会漏掉
            }
            temp *= temp;
            n /= 2;
        }
        if (isNegative){
            res = x * res;//多乘了个x，在防止溢出时候
        }
        return res;
    }
