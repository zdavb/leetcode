public class Solution {
    private int countLiveNeigh(int[][] board,int row,int col){
        int count =  0;
        for(int i = row-1;i<=row+1;i++){
            for(int j = col-1;j<=col+1;j++){
                if(i==row && j==col)
                    continue;
                if(i>=0 && i<board.length && j>=0 && j<board[0].length && (board[i][j]==1||board[i][j]==2))//最开始状态为1的
                    count++;
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        /*
        * 0:0--->0
          1:1--->1
          2:1--->0
          3:0--->1
        */
        int rowlen = board.length;
        int collen = board[0].length;
        for(int row = 0;row<rowlen;row++){
            for(int col = 0;col<collen;col++){
                int count = countLiveNeigh(board,row,col);
                if(count == 2);
                else if(count == 3){
                    board[row][col] = board[row][col]==0?3:1;
                }else{
                    board[row][col] = board[row][col]==1?2:0;
                }
            }
        }
        for(int row = 0;row<rowlen;row++){
            for(int col = 0;col<collen;col++){
                board[row][col] %= 2;
            }
        }
    }
}