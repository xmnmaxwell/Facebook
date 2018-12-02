344. Reverse String 字符翻转
O(n) time O(n) space
public String reverseString(String s) {
        char[] str = s.toCharArray();// transfer string to char array
        int i = 0, j = s.length() - 1;// use two pointers
        while (i < j){
            char temp = str[i];//swap the two ends char element
            str[i++] = str[j];
            str[j--] = temp;
        }
        return new String(str);
    }
