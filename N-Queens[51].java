public class Solution {
    private boolean isValid(List<Integer> tmplist,int col){
        int row = tmplist.size();
        for(int i = 0;i<row;i++){
            int rowrow = i;
            int colcol = tmplist.get(i);
            
            if(colcol == col || Math.abs(row-rowrow) == Math.abs(col-colcol))
                return false;
        }
        return true;
    }
    private void solve(List<List<String>> res,List<Integer> tmplist,int n){
        if(tmplist.size() == n){
            List<String> list = new ArrayList<>();
            for(int i = 0;i<tmplist.size();i++){
                StringBuilder builder = new StringBuilder();
                int num = tmplist.get(i);
                for(int j = 0;j<n;j++){
                    if(num == j)
                        builder.append('Q');
                    else
                        builder.append('.');
                }
                list.add(builder.toString());
            }
            res.add(list);
            return;
        }
        for(int i = 0;i<n;i++){
            if(!isValid(tmplist,i))
                continue;
            tmplist.add(i);
            solve(res,tmplist,n);
            tmplist.remove(tmplist.size()-1);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> tmplist = new ArrayList<>();
        
        solve(res,tmplist,n);
        return res;
    }
}