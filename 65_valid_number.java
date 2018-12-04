Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."

public boolean isNumber(String s) {
        
        s = s.trim();
        
        boolean e = false, point = false, num = false, numAfterE = false;
        // e:字符串里是否已经有e，字符串里是否有point了，是否有num了，e后面是否有number
        +3.5e3
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {//如果遇到数字了
                num = true; //字符串里已经有number
                numAfterE = true;//
            } else if (ch == 'e') {
                if (e || !num) return false; //字符里已经有e，或者e前面没有number
                numAfterE = false;//e后面是否有number，目前没有
                e = true;//是否有e设为true
            } else if (ch == '.') {
                if (point || e) return false;// 已经有点了，或者 e2.5这是错的
                point = true;//标记字符串里有point了
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;// 正负号前没有e的话都是false，这种情况还有一个条件默认+-号在第一个也可以
            } else return false;
        }
        return num & numAfterE;
    }
