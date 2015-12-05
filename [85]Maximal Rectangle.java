//这道题比较牛逼，方法是利用上题的思路，以每行为底，求解每行的直方图，然后对每行求最大面积，然后比较返回
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0)
            return 0;
        int col = matrix[0].length;
        if(col == 0)
            return 0;
            
        //values store the height of each row
        int[][] values = new int[row][col];
        //init 1st values
        for(int j = 0;j<col;j++)
            values[0][j] = matrix[0][j] == '0'?0:1;
        
        for(int i = 1;i<row;i++){
            for(int j = 0;j<col;j++){
                if(matrix[i][j] == '0')
                    values[i][j] = 0;
                else{
                    values[i][j] = values[i-1][j] + 1;
                }
            }
        }
        
        //search every row
        int maxArea = 0;
        for(int i = 0;i < row;i++){
            int maxAreaEachRow = findAreaFromHeights(values[i]);
            if(maxAreaEachRow > maxArea)
                maxArea = maxAreaEachRow;
        }
        return maxArea;
    }
    //返回heights中的最大面积
    private int findAreaFromHeights(int[] heights){
        int length = heights.length+1;
        int[] newHeights = new int[length];
        for(int i = 0;i<length-1;i++)
            newHeights[i] = heights[i];
        newHeights[length-1] = 0;
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0;i<length;i++){
            while(!stack.isEmpty()){
                int top = stack.peek();
                if(newHeights[top] <= newHeights[i])
                    break;
               
                stack.pop();//出栈
                int area = newHeights[top] * (stack.isEmpty()?i:i-stack.peek()-1);
                if(area > max)
                    max = area;
            }
            stack.push(i);
        }
        return max;
    }
}