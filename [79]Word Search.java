//TLE版本
//思路是：深搜+剪枝 == 回溯法
public class Solution {
    char[] wordChars = null;
    int boardRow = 0;
    int boardCol = 0;
    
    HashSet<String> sets = null;
    public boolean exist(char[][] board, String word) {
        wordChars = word.toCharArray();
        boardRow = board.length;
        if(boardRow <= 0) return false;
        boardCol = board[0].length;
        if(boardCol <= 0) return false;
        if(wordChars.length == 0) return false;
        
        sets = new HashSet<>();
        for(int i = 0;i<boardRow;i++){
            for(int j = 0;j<boardCol;j++){
                if(board[i][j] == wordChars[0]){
                    sets.clear();
                    sets.add(String.valueOf(i)+","+String.valueOf(j));
                    if(isValid(board,i,j,1))
                        return true;
                }
            }
        }
        return false;
    }
    private boolean isValid(char[][] board,int row,int col,int wordIndex){
        if(wordIndex == wordChars.length)
            return true;
            
        int[] rows = {-1,0,1,0};
        int[] cols = {0,1,0,-1};
        
        boolean res = false;
        for(int i = 0;i<4;i++){
            int newRow = row+rows[i];
            int newCol = col+cols[i];
            
            String val = String.valueOf(newRow)+","+String.valueOf(newCol);
            if(newRow>=0&&newRow<boardRow && newCol>=0&&newCol<boardCol 
                && !sets.contains(val) && board[newRow][newCol] == wordChars[wordIndex]){
                sets.add(val);
                res |= isValid(board,newRow,newCol,wordIndex+1);
                sets.remove(val);
            }
        }
        
        return res;
    }
}
//上述算法的问题在于 res |= isValid(...)处，因为这样的话，相当于即使找到了满足条件的点，这时完全可以返回了，但是
//还会继续进行搜索
public class Solution {
    int boardRow;
    int boardCol;
    
    char[] wordChars;
    boolean[][] visitedMatrix;
    
    public boolean exist(char[][] board, String word) {
        wordChars = word.toCharArray();
        if(wordChars.length == 0) return false;
        boardRow = board.length;
        if(boardRow <= 0) return false;
        boardCol = board[0].length;
        if(boardCol <= 0) return false;
        
        visitedMatrix = new boolean[boardRow][boardCol];
        
        for(int i = 0;i<boardRow;i++){
            for(int j = 0;j<boardCol;j++){
                if(board[i][j] == wordChars[0]){
                    visitedMatrix[i][j] = true;
                    if(isValid(board,i,j,1))
                        return true;
                 visitedMatrix[i][j] = false;
                }
            }
        }
        return false;
    }
    private boolean isValid(char[][] board,int row,int col,int wordIndex){
        if(wordIndex == wordChars.length)
            return true;
        
        int[] rows = new int[]{-1,0,1,0};
        int[] cols = new int[]{0,1,0,-1};
        
        for(int i = 0;i<4;i++){
            int newRow = row+rows[i];
            int newCol = col+cols[i];
            
            if(newRow >= 0 && newRow < boardRow
                && newCol >= 0 && newCol < boardCol
                && board[newRow][newCol] == wordChars[wordIndex] 
                && !visitedMatrix[newRow][newCol]){
                    visitedMatrix[newRow][newCol] = true;
                    if(isValid(board,newRow,newCol,wordIndex+1))
                        return true;
                    visitedMatrix[newRow][newCol] = false;
                }
        }
        return false;
    }
}