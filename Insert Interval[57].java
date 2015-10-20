/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        int size = intervals.size();
        if(size <= 0){
            res.add(newInterval);
            return res;
        }
        
        int i = 0;
        for(;i < size;i++){
            Interval cur = intervals.get(i);
            if(cur.end < newInterval.start){
                res.add(cur);
            }else{
                if(cur.start <= newInterval.end){
                    newInterval.start = Math.min(newInterval.start,cur.start);
                    newInterval.end = Math.max(newInterval.end,cur.end);
                }else{
                    break;
                }
            }
        }
        res.add(newInterval);
        for(;i<size;i++)
            res.add(intervals.get(i));
            
        return res;
    }
}