67. add binary 两个二进制字符串相加，返回也是字符串
O(max(m,n))
  public String addBinary(String a, String b) { 
        int aLen = a.length();
        int bLen = b.length();
        int sum = 0;
        int carry = 0;
        String res = "";

        for (int i = 0; i < Math.max(aLen, bLen); i++){
            sum = getBit(a, aLen - i - 1) + getBit(b, bLen - i -1) + carry;
            carry = sum/2; 
            res = Integer.toString(sum % 2) + res;
        }
        if (carry != 0){
            res = Integer.toString(carry) + res;
        }
        return res;
    }
    private int getBit(String str, int index){
        if (index < 0 || index >= str.length()){
            return 0;
        } else if (str.charAt(index) == '0') {
            return 0;
        } else 
        return 1;
    }
