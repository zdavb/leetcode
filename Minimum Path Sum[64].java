public class Solution {
    public int minPathSum(int[][] grid) {
        //init grid
        int ROW = grid.length;
        int COL = grid[0].length;
        
        for(int i = 1;i<COL;i++){
            grid[0][i] += grid[0][i-1];
        }
        for(int i = 1;i<ROW;i++){
            grid[i][0] += grid[i-1][0];
        }
        
        for(int row = 1;row<ROW;row++){
            for(int col = 1;col<COL;col++){
                grid[row][col] += Math.min(grid[row-1][col],grid[row][col-1]);
            }
        }
        return grid[ROW-1][COL-1];
    }
}