//思路：深搜
public class Solution {
    //dfs
    int total;
    int limit;
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmplist = new LinkedList<>();
        total = k;
        limit = n;
        
        dfs(res,tmplist,0);
        return res;
    }
    private void dfs(List<List<Integer>> res,List<Integer> tmplist,int index){
        if(tmplist.size() == total){
            res.add(new LinkedList<>(tmplist));
            return;
        }
        for(int i = index+1;i<=limit;i++){
            tmplist.add(i);
            dfs(res,tmplist,i);
            tmplist.remove(tmplist.size()-1);
        }
    }
}