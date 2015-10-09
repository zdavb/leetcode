//10ms
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //先按行来检查
        for(int row = 0;row<9;row++){
            HashSet<Character> sets = new HashSet();
            for(int col = 0;col<9;col++){
                char ch = board[row][col];
                if(ch == '.')
                     continue;
                if(sets.contains(ch))
                    return false;
                sets.add(ch);
            }
        }
        //再按列来检查
        for(int col = 0;col<9;col++){
            HashSet<Character> sets = new HashSet<>();
            for(int row = 0;row<9;row++){
                char ch = board[row][col];
                if(ch == '.')
                   continue;
                if(sets.contains(ch))
                    return false;
                sets.add(ch);
            }
        }
        //遍历9个小格子
        for(int row = 0;row<3;row++){
            for(int col = 0;col<3;col++){
                HashSet<Character> sets = new HashSet<>();
                
                int beginRowIndex = row*3;
                int beginColIndex = col*3;
                for(int i = beginRowIndex;i<beginRowIndex+3;i++){
                    for(int j = beginColIndex;j<beginColIndex+3;j++){
                        char ch = board[i][j];
                        if(ch == '.')
                            continue;
                        if(sets.contains(ch))
                            return false;
                        sets.add(ch);
                    }
                }
            }
        }
        return true;
    }
}
