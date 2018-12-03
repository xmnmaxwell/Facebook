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
        
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                num = true;
                numAfterE = true;
            } else if (ch == 'e') {
                if (e || !num) return false;
                numAfterE = false;
                e = true;
            } else if (ch == '.') {
                if (point || e) return false;
                point = true;
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else return false;
        }
        return num & numAfterE;
    }
