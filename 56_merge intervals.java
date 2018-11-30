Merge intervals
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
O(nlogn)
按interval的start排序，然后把第一个的interval的end和后一个的start比较，如果大于
将第一个interval的end取两个end 的最大值，如果不交集res添加这个区间然后，last指向8 10

1 3
2 6
8 10
15 18
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){ // write a comparator to compare the interval.start, take O(nlogn)
               public int compare(Interval o1, Interval o2){
                     return o1.start - o2.start;
               }
        });
        
        List<Interval> res = new ArrayList<>();
        Interval last = intervals.get(0);//get the first element
        for (int i = 1; i < intervals.size(); i++){
            Interval curr = intervals.get(i);//get current element to compare the curr start time and last end time to see if there are overrlapping
            if (curr.start <= last.end){
                last.end = Math.max(last.end, curr.end);
            } else {
                res.add(last);
                last = curr;
            }
        }
        res.add(last);//最后一个元素没有添加进来要加上
        return res;
    }
}
