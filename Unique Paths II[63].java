public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ROW = obstacleGrid.length;
        int COL = obstacleGrid[0].length;
        
        if(ROW == 1){
            for(int i = 0;i<COL;i++)
                if(obstacleGrid[0][i] == 1)
                    return 0;
                return 1;
        }
        if(COL == 1){
            for(int i = 0;i<ROW;i++)
                if(obstacleGrid[i][0] == 1)
                    return 0;
                return 1;
        }
        //init dp
        obstacleGrid[0][0] = obstacleGrid[0][0] == 1?0:1;
        for(int i = 1;i<COL;i++){
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1?0:obstacleGrid[0][i-1];
        }
        for(int i = 1;i<ROW;i++){
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1?0:obstacleGrid[i-1][0];
        }
        
        for(int row = 1;row<ROW;row++){
            for(int col = 1;col<COL;col++){
                obstacleGrid[row][col] = obstacleGrid[row][col] == 1?0:obstacleGrid[row-1][col]+obstacleGrid[row][col-1];
            }
        }
        return obstacleGrid[ROW-1][COL-1];
    }
}