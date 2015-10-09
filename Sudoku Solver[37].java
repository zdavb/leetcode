public class Solution {
    private boolean isValidSudoku(char[][] board,int row,int col){
        //check rowth row
        for(int i = 0;i<9;i++){
            if(board[row][i] != '.' && i!=col && board[row][i] == board[row][col])
                return false;
        }
        //check colth col
        for(int i = 0;i<9;i++){
            if(board[i][col] != '.' && i!=row && board[i][col] == board[row][col])
                return false;
        }
        //check the box
        int beginRowIndex = row/3*3;
        int beginColIndex = col/3*3;
        for(int i = beginRowIndex;i<beginRowIndex+3;i++){
            for(int j = beginColIndex;j<beginColIndex+3;j++){
                if(board[i][j]!='.' && board[i][j] == board[row][col])
                    if(i!=row || j!=col)
                        return false;
            }
        }
        return true;
    }
    private boolean solve(char[][] board){
        for(int row = 0;row<9;row++){
            for(int col = 0;col<9;col++){
                if(board[row][col] == '.'){
                    for(char ch = '1';ch<='9';ch++){
                        board[row][col] = ch;
                        if(isValidSudoku(board,row,col))
                            if(solve(board))
                                return true;
                        board[row][col] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}