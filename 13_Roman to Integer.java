13. Roman to Integer
public int romanToInt(String s) {
        int res = 0;
        int[] aArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rArray = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i =0; i< rArray.length; i++){
            while (s.indexOf(rArray[i]) == 0){
                res += aArray[i];
                s = s.substring(rArray[i].length());
            }
        }
        return res;
    }
    
    
        public String intToRoman(int num) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[]  nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 13; i++){
           while (num >= nums[i]){
               sb.append(roman[i]);
               num -= nums[i];
           }
       }
        return sb.toString();
    }
