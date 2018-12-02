f7. Reverse Integer 数字翻转（处理 overflow 问题）
O(n) time O(1) space
 public int reverse(int x) {
    int res = 0;
    while (x != 0){
    int newRes = res * 10 + x % 10;// newRes is the advanced res, if new Res is overflow so (newRes - x%10 != res)
    if ((newRes - x%10) / 10 != res)// check if overflow
        return 0;
        res = newRes;// if not overflow, real res would be newRes
        x /= 10;
    }
    return res;
}
