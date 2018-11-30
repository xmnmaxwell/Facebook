class Solution {
    private String[] LESS_THAN_20 =  {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    //123,456
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        String res = "";
        
        /*
        boolean negative = false;
        long n = num;
        if (n < 0){
            negative = true;
            n= -n;  下面所有的num换成 (int) n, 最后的 return negative ? "Negative" + res : res;
        }
        */
        
        int i = 0;// index of Thousands array
        while (num > 0){
            if (num%1000 != 0){// 比如1,000,000 我们就是1 million, 如果不加判断条件会打印thousand出来
            res = helper(num%1000) + THOUSANDS[i] + " " +  res;// 第一次循环先处理100-以内的，这个空格在thousand之后都有用，但是个位就没用所以最后要trim掉
            }    
            num = num / 1000;// 开始处理一千以上的
            i++;
        }
        return res.trim();
    }
    // write a function to deal with number below 1000
    public String helper(int num){
        if (num == 0) return "";//null character
        if (num < 20) {
            return LESS_THAN_20[num] + " ";//加空格是因为 15 thousand 后面加空格
        } else if (num < 100) {// (20,99)
            return TENS[num/10] + " " + helper(num%10);//确认个位也有空格
        } else //（100， 999）// modulo
            return LESS_THAN_20[num/100] + " " + "Hundred " + helper(num%100);//确认末位有空格
    }
}
