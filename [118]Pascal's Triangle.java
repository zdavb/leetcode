public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if(numRows == 0)
            return res;
        
        List<Integer> tmplist = new LinkedList<>();
        tmplist.add(1);
        res.add(tmplist);
        
        for(int i = 1;i<numRows;i++){
            List<Integer> newlist = new LinkedList<>();
            int prev = 0;
            
            int size = tmplist.size();
            for(int j = 0;j<size;j++){
                int num = tmplist.get(j);
                newlist.add(prev+num);
                prev = num;
            }
            newlist.add(1);
            
            res.add(newlist);
            tmplist = newlist;
        }
        return res;
    }
}