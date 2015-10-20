/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//my idea
//思路是将每个点单独拿出来，进行排序
//然后把中间的点删除即可
public class Solution {
    class Node{
        int val;
        boolean isLeft;
        Node(int val,boolean left){
            this.val = val;
            this.isLeft = left;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Node> nodelist = new ArrayList<>();
        List<Interval> res = new LinkedList<>();
        
        //init nodelist
        int size = intervals.size();
        if(size <= 0)
            return res;
        
        for(int i = 0;i<size;i++){
            Interval tmp = intervals.get(i);
            nodelist.add(new Node(tmp.start,true));
            nodelist.add(new Node(tmp.end,false));
        }
        //sort nodelist
        Collections.sort(nodelist,new Comparator<Node>(){
            public int compare(Node n1,Node n2){
                return n1.val - n2.val;
            }
        });
        
        Stack<Integer> stack = new Stack<>();
        size = nodelist.size();
        
        for(int i = 0;i<size-1;i++){
            Node cur = nodelist.get(i);
            Node next = nodelist.get(i+1);
            if(cur.val == next.val && !cur.isLeft && next.isLeft){
               i++;
               continue;
            }
            if(cur.isLeft)
                stack.push(cur.val);
            else{
                int top = stack.pop();
                if(stack.isEmpty()){
                    res.add(new Interval(top,cur.val));
                }
            }
        }
        res.add(new Interval(stack.pop(),nodelist.get(size-1).val));
        return res;
    }   
}

//better one
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*
    思路：先排序，然后再进行合并
    注意合并时，维护一个当前变量，然后从前向后遍历list。比较list取值与当前变量。
*/
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        int size = intervals.size();
        if(size<=0)
            return res;
        
        //排序
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a1,Interval a2){
                return a1.start - a2.start;
            }
        });
        
        Interval val = intervals.get(0);
        //合并
        for(int i = 1;i<size;i++){
            Interval next = intervals.get(i);
            if(next.start > val.end){
                res.add(val);
                val = next;
            }else{
                val.end = Math.max(next.end,val.end);
            }
        }
        res.add(val);
        return res;
    }
}