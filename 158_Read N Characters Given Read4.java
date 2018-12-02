158 Read N Characters Given Read4 - call mutiple times
Example 1: 

Given buf = "abc"
read("abc", 1) // returns "a"
read("abc", 2); // returns "bc"
read("abc", 1); // returns ""
Example 2: 

Given buf = "abc"
read("abc", 4) // returns "abc"
read("abc", 1); // returns ""

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
         int bufSize = 0, bufPos = 0;
    char[] buffer = new char[4];
    read(abc, 1) a
    read(abc, 2) bc
    public int read(char[] buf, int n) {
        int cnt = 0;
        while (cnt < n) {
            if (bufPos == bufSize) {
                bufSize = read4(buffer);//size 3, 
                bufPos = 0;// pos 0
            }
            if (bufSize == 0) return cnt;
            while (cnt < n && bufPos < bufSize) 
                buf[cnt ++] = buffer[bufPos ++];//buf[1] = a, pos 1
        }
        return n;
    }
//call one time
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */// 一个file abcde
    public int read(char[] buf, int n) {
         char[] buf4 = new char[4];// 新建一个buffer数组
        int offset = 0;
        
        while (true) {
            int size = read4(buf4);//read4函数自动把abcd赋值给buf4,第二次循环再把e赋值进去
            for (int i = 0; i < size && offset < n; i++) {
              buf[offset++] = buf4[i];
            }
            if (size == 0 || offset == n) {
                return offset;
            }
        }
    }
}
