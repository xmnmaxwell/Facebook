/*Given an array of meeting time intervals consisting of start and end 
times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
O(nlogn)
讨论是否需要新的room，取决于会议开始的时间是否在结束之前，如果在之前就需要新的room
如果在之后，就可以分配已经结束的room.我们新建两个数组，存放interval的开始和结束时间
然后排序，endPtr指针指的是会议的结束时间从小到大的数组下标
||           |     |
    |     |    |     |
我们move startPtr， 如果start<end 说明需要新的room，如果start> end, 说明不需要新的
room， 用已经的结束的room就可以，但此时end指针要进一位  
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i].start; //分开存放开始和结束的时间
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts); //排序
        Arrays.sort(ends);
        
        int roomNum = 0; //需要房间数
        int endPtr = 0; 
        int startPtr = 0;
        for (startPtr = 0; startPtr < intervals.length; startPtr++){
            if (starts[startPtr] < ends[endPtr]){
                roomNum++;
            } else {
                endPtr++;// why endPtr++ because this room can be reused
            }
        }
        return roomNum;
    }
}    
f252. meeting rooms 给一堆时间段确认一个人是否可以attend all meeting
//O(nlogn)
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0 ) return true;
        
       Arrays.sort(intervals, (a, b) -> a.start - b.start);
        
        //就是保证每个会议的开始时间比上一个结束时间要晚
           for (int i = 1; i <intervals.length; i++){
               if (intervals[i].start < intervals[i-1].end)
                   return false;
           }
        return true;
    }
}
************************************************************************************************
input 是string
public class StringInput {

    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public Interval translate(String input) {
        String[] splits = input.split("-");
        String start = splits[0].trim();
        String end   = splits[1].trim();
        return new Interval(convert(start), convert(end));
    }

    private int convert(String time) {
        boolean PM = false;
        if (time.charAt(time.length() - 1) == 'p') 
            PM = true;
        time = time.substring(0, time.length() - 1);
        String[] splits = time.split(":");
        int hour = Integer.parseInt(splits[0]);
        int minute = Integer.parseInt(splits[1]);
        if (PM && hour != 12) hour += 12;
        return hour * 60 + minute;
    }

    public void test() {
        String input = "01:34p - 02:59p";
        Interval result = translate(input);
        System.out.println(result.start + " " + result.end);
    }

    public static void main(String[] args) {
        StringInput sol = new StringInput();
        sol.test();
    }
}
