9. Palindrome Integer 回文数字 （overflow问题）
O(n)
1235321 -> 1235321
public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;// x is negative, x final digit is 0, it is false
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10; // rev: 1, 12, 123, 1235
    	x = x/10;// x:123532, 12353, 1235, 123
    }
    return (x==rev || x==rev/10);// if digit is even x == rev or odd x == rev/10
    }
