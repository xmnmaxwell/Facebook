Example 1:
Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".
******************************************************************************************
class Solution {
      String IPv6char = "0123456789abcdefABCDEF";
      public boolean isIPv4(String str){
            int num = 0;
            if (str.length() == 0 || str.length() > 3) return false;
          //检查某一段的数字是否是空
            for (int j = 0; j < str.length(); j++){
                if (!Character.isDigit(str.charAt(j))) return false;
                else num = num * 10 + str.charAt(j) - '0';
            }// 检查是否有非数字，并计算段中的数字注意技巧
            if (str.length() > 1 && str.charAt(0) == '0') return false;
          // 123.0.0.1是符合的，所以如果超过1位，头数字不能为0
            if (num < 256 && num >=0 ) return true;
          //看看在不在255内
            return false;
    }
    
    public boolean isIPv6(String str){
        if(str.equals("") || str.length() > 4) {    
            return false;    
        }  
        for(int i = 0; i < str.length(); i++){
            if (IPv6char.indexOf(str.charAt(i)) == -1) return false;
            //检查字符在不在十六进制范围内，常用的检查方法要记住！！！
        }
        return true;
    }
    public int numOfToken(String IP, char token){
        int count = 0;
        for (int i = 0; i < IP.length(); i++){
            if(IP.charAt(i) == token)
                count++;
        }
        return count;
    }
    public String validIPAddress(String IP) {
       String[] IPv4 = IP.split("\\."); 
       boolean is_IPv4 = true;
        if ( IPv4.length == 4 && numOfToken(IP, '.') == 3){
            for (int i = 0; i < 4; i++){
                if (!isIPv4(IPv4[i])){
                    is_IPv4 = false;
                    break;
                }
            }
        } else {
                is_IPv4 = false;
               }
            if(is_IPv4) return "IPv4";
                             
        boolean is_IPv6 = true;
        String[] IPv6 = IP.split(":");
        if (IPv6.length == 8 && numOfToken(IP, ':') == 7){        
            for (int i = 0; i < 8; i++){
                if (!isIPv6(IPv6[i])){
                    is_IPv6 = false;
                    break;
                } 
            } 
        }  else {
                    is_IPv6 = false;
                }
        if(is_IPv6) return "IPv6";
                
        return "Neither";  
    }
}
