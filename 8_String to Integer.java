8. String to Integer
 public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        // start index, sign +-, resolution
        if(str.length() == 0) return 0;

        while(index < str.length() && str.charAt(index) == ' ')
            index++;// skip space

        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++; // identify the sign
        }
        
        if(index < str.length() && !Character.isDigit(str.charAt(index))) return 0;
        // if first chacter is not digit return 0.
        int result = 0;
        while(index < str.length()) {
            if(!Character.isDigit(str.charAt(index))) break;
            char current = str.charAt(index++);
            int previous = result;
            result *= 10;
            if(previous != result/10) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result += (current - '0');
            if(result < 0) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return result * sign;
    }
