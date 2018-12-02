825.  Friends Of Appropriate Ages
class Solution {
    //a request b 只在b (0.5a+7, a]范围内
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] num = new int[121], sum = new int[121];
        
        for (int i: ages){
            num[i]++;// 计算各个年龄的人数
        }
        
        for (int i = 1; i <=120; i++){
            sum[i] = num[i] + sum[i-1];//计算年龄小于等于下标的人数
        }
        
        for (int i = 15; i <= 120; i++){// 0.5a+7 <= a
            if (num[i] == 0) continue;
            int count = sum[i] - sum[i/2+7];//只在b (0.5a+7, a]范围内
            count--;// 不包含自己
            res += count*num[i];
        }
        return res;
    }
}
