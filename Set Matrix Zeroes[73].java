public class Solution {
    int ROW;
    int COL;
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        ROW = matrix.length;
        if(ROW == 0)
            return;
        COL = matrix[0].length;
        if(COL == 0)
            return;
        
        //check first row and first col
        for(int i = 0;i<COL;i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }
        for(int i = 0;i<ROW;i++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }
        //predeal
        for(int row = 1;row < ROW;row++){
            for(int col = 1;col<COL;col++){
                if(matrix[row][col] == 0){
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        //check first row and col again
        for(int i = 1;i<COL;i++){
            if(matrix[0][i] == 0)
                setMatrixZeroCol(matrix,i);
        }
        for(int i = 1;i<ROW;i++){
            if(matrix[i][0] == 0)
                setMatrixZeroRow(matrix,i);
        }
        if(firstRowZero)
            setMatrixZeroRow(matrix,0);
        if(firstColZero)
            setMatrixZeroCol(matrix,0);
    }
    private void setMatrixZeroRow(int[][] matrix,int row){
        for(int i = 0;i<COL;i++)
            matrix[row][i] = 0;
    }
    private void setMatrixZeroCol(int[][] matrix,int col){
        for(int i = 0;i<ROW;i++)
            matrix[i][col] = 0;
    }
}