
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        if(ROW <= 0)
            return false;
        int COL = matrix[0].length;
        if(COL <= 0)
            return false;
        int row = 0;
        int col = COL-1;
        
        while(row >=0 && row < ROW && col >=0 && col<COL){
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] > target)
                col--;
            else 
                row++;
        }
        return false;
    }
}