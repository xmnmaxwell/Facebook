151. Reverse Words in a String 翻转字符串里的 word， 处理空格问题
Input: "the sky is blue",-> "eulb si yks eht" -> "blue is sky the"
Output: "blue is sky the".
O(n)
 // 翻转字符串三步法，先把所有字符串reverse，再对每一个字符串逐一reverse 处理空格是最麻烦的；
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);// "eulb si yks eht"
        int start = 0;
        int index = 0; // , , ,cba, , , ...
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != ' '){
                arr[index++] = arr[i];// cba, , , , , , , ...
            } else if (i > 0 && arr[i-1] != ' '){
                reverse(arr, start, index - 1);// abc, , , , , ...
                arr[index++] = ' ';// abc , , , , , , , ...
                start = index;
            }
        }
        reverse(arr, start, index - 1);//最后一个字母后面没空格的情况，前面也满了
        return new String(arr, 0, index > 0 && arr[index - 1] == ' ' ? index - 1 : index);// 表达方式新建由char数组组成的string，后面两个参数代表新建字符串的起始位置，index后面在13行加了空格，需要判断前一个是不是空格
    }
    private char[] reverse(char[] arr, int i, int j){
        while (i < j){
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        return arr;
    }
