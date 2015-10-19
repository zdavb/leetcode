public class Solution {
    private boolean isValid(List<Integer> tmplist,int col){
        int row = tmplist.size();
        for(int i = 0;i<tmplist.size();i++){
            int rowrow = i;
            int colcol = tmplist.get(i);
            
            if(colcol == col || Math.abs(rowrow-row) == Math.abs(colcol-col))
                return false;
        }
        return true;
    }
    private int solve(List<Integer> tmplist,int n){
        if(tmplist.size() == n){
            return 1;
        }
        int size = 0;
        for(int i = 0;i<n;i++){
            if(isValid(tmplist,i)){
                tmplist.add(i);
                size += solve(tmplist,n);
                tmplist.remove(tmplist.size()-1);
            }
        }
        return size;
    }
    public int totalNQueens(int n) {
        List<Integer> tmplist = new ArrayList<>();
        return solve(tmplist,n);
    }
}