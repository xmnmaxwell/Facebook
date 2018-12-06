43. multiply strings 
O(mn)
num2: 321
num1: 456
  ---------
     1926
    1605
   1284    
public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null; 
        int len1 = num1.length();
        int len2 = num2.length();
        int len3 = len1 + len2;
        int product = 0;
        int[] num3 = new int[len3];// define num3 to store the 进位 and also remaining.
        int i, j;
        for(i = len1 - 1; i >= 0; i--){
            int carry = 0;
            for (j = len2 - 1; j >= 0; j--){
                
                product = carry + num3[i + j + 1] + (num1.charAt(i)- '0')*(num2.charAt(j) - '0');
                num3[i + j+ 1] = product % 10;//把余数存储在num3数组里；
                carry = product / 10;
            }
            num3[i + j + 1] = carry;// 为下一次循环引入进位数；//出了循环j又多减了1，相当于下一位存储进位。
        }
        
        StringBuilder sb = new StringBuilder();
        i = 0;
        while (i < len3 - 1 && num3[i] == 0){
            i++; // 过掉num3前面的无用的0
        }
        while(i < len3){
            sb.append(num3[i++]);
        }
        return sb.toString();
    }
