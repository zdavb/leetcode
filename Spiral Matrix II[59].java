public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int val = 1;
        int end = n*n;
        
        int leftRow = 0;
        int rightRow = n-1;
        
        int row,col;
        while(leftRow < rightRow){
            row = leftRow;col = leftRow;
            
            for(;col<rightRow;col++)
                res[row][col] = val++;
            for(;row<rightRow;row++)
                res[row][col] = val++;
            for(;col>leftRow;col--)
                res[row][col] = val++;
            for(;row>leftRow;row--)
                res[row][col] = val++;
            
            leftRow++;rightRow--;
        }
        if(leftRow == rightRow)
            res[leftRow][leftRow] = val;
        return res;
    }
}