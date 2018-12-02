91 Decode ways
'A' -> 1
'B' -> 2
...
'Z' -> 26
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
//本质就是123，我想看3的前一位是不是非0，这样3作为单独群体，2有几种编译方式3就有几种编译方式，然后看23合并，如果在10和26之间，说明他们可以作为整体，那么23的前一位有几种编译方式
//23也有几种编译方式，所以是两者之和。
O(n) time O(n) space
public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] nums = new int[s.length()+1];
        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1 : 0;// 1234056,第1位是不是0不是就有一种编译方法，nums[i]代表到达第i位一共有多少种编译方式
        for (int i = 2;i <= s.length(); i++){
           if (s.charAt(i-1) != '0'){
               nums[i] = nums[i-1]; //扫到第i位时候，如果i-1位不是0，代表的是第i位单独时候，i-1有几种组合方式，到i位就有几种123   4,4单独拉出来3这位上有几种编译方式加上4就有几种方式
           }
            
           int twoDigit = (s.charAt(i-2)-'0') * 10 + s.charAt(i-1)-'0';
           if (twoDigit >=10 && twoDigit <= 26) 
               nums[i] += nums[i-2];
        }    
        return nums[s.length()];
    }
