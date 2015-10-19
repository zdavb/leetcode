//真心没想到在这道题上会浪费这么长时间
//归根到底是数据结构没理清楚
//这个的结构是这样：维护两个点：左上点和右下点
//当这两个点不在一条直线时迭代
//当这两个点在一条直线时单独处理

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        if(row<=0)
            return res;
        int col = matrix[0].length;
        if(col<=0)
            return res;
            
        //init topleft node and bottomright node
        int leftRow = 0;
        int leftCol = 0;
        int rightRow = row-1;
        int rightCol = col-1;
        
        while(leftRow<rightRow && leftCol<rightCol){
            row = leftRow;
            col = leftCol;
            
            for(;col<rightCol;col++)
                res.add(matrix[row][col]);
            for(;row<rightRow;row++)
                res.add(matrix[row][col]);
            for(;col>leftCol;col--)
                res.add(matrix[row][col]);
            for(;row>leftRow;row--)
                res.add(matrix[row][col]);
            
            leftRow++;leftCol++;
            rightRow--;rightCol--;
        }
        
        if(leftRow == rightRow && leftCol == rightCol)
            res.add(matrix[leftRow][leftCol]);
        else if(leftRow == rightRow){
            for(col = leftCol;col<=rightCol;col++) 
                res.add(matrix[leftRow][col]);
        }else if(leftCol == rightCol){
            for(row = leftRow;row<=rightRow;row++)
                res.add(matrix[row][leftCol]);
        }
        return res;
    }
}