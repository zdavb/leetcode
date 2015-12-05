//DFS 超时public class Solution {
    char[] chars;
    char[] chart;
    int row;
    int col;
    
    int[][] matrix;
    public int numDistinct(String s, String t) {
        chars = s.toCharArray();
        chart = t.toCharArray();
        col = chars.length;
        row = chart.length;
        
        if(row > col)
            return 0;
        else if(row == 0)
            return 1;
        
        matrix = new int[row][col];  
        //init matrix row
        matrix[0][0] = (chars[0]==chart[0])?1:0;
        for(int i = 1;i<col;i++){
            if(chart[0] == chars[i])
                matrix[0][i] = matrix[0][i-1]+1;
            else
                matrix[0][i] = matrix[0][i-1];
        }
       
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(chart[i] == chars[j]){
                    matrix[i][j] = matrix[i-1][j-1]+matrix[i][j-1];
                }else{//delete
                    matrix[i][j] = matrix[i][j-1];
                }
            }
        }
        return matrix[row-1][col-1];
    }
}
public class Solution {
    int count = 0;
    char[] chars;
    char[] chart;
    
    int slength;
    int tlength;
    
    public int numDistinct(String s, String t) {
        chars = s.toCharArray();
        chart = t.toCharArray();
        slength = chars.length;
        tlength = chart.length;
        
        countDistinct(0,0);
         
         return count;
    }
    private void countDistinct(int sbase,int tbase){
        if(tbase == tlength){
            count++;
            return;
        }
        if(slength - sbase < tlength - tbase)//the gap between sbase and end of s larger than tbase and end of t
            return;
        for(int i = sbase;i<slength;i++){
            while(i<slength && chars[i] != chart[tbase])
                i++;
            
            countDistinct(i+1,tbase+1);
        }
    }
}

//采用二维DP算法
//如果元素删掉的话，那么当前元素为dp[i][j-1];
//如果不删，那么元素值为dp[i-1][j-1];

public class Solution {
    char[] chars;
    char[] chart;
    int row;
    int col;
    
    int[][] matrix;
    public int numDistinct(String s, String t) {
        chars = s.toCharArray();
        chart = t.toCharArray();
        col = chars.length;
        row = chart.length;
        
        if(row > col)
            return 0;
        else if(row == 0)
            return 1;
        
        matrix = new int[row][col];  
        //init matrix row
        matrix[0][0] = (chars[0]==chart[0])?1:0;
        for(int i = 1;i<col;i++){
            if(chart[0] == chars[i])
                matrix[0][i] = matrix[0][i-1]+1;
            else
                matrix[0][i] = matrix[0][i-1];
        }
       
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(chart[i] == chars[j]){
                    matrix[i][j] = matrix[i-1][j-1]+matrix[i][j-1];
                }else{//delete
                    matrix[i][j] = matrix[i][j-1];
                }
            }
        }
        return matrix[row-1][col-1];
    }
}