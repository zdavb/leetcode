//TLE版本
//思路很简单，就是广搜；当找到满足条件的元素时一定最小
public class Solution {
    class Node{
        int word1Index;
        int word2Index;
        int level;
        
        Node(int index1,int index2,int level){
            this.word1Index = index1;
            this.word2Index = index2;
            this.level = level;
        }
    }
    int lengthOfWord1;
    int lengthOfWord2;
    
    public int minDistance(String word1, String word2) {
        lengthOfWord1 = word1.length();
        lengthOfWord2 = word2.length();
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,0));
        
        while(!queue.isEmpty()){
            Node top = queue.poll();
            int index1 = top.word1Index;
            int index2 = top.word2Index;
            int level = top.level;
            
            //从该点开始继续延伸
            while(index1 < lengthOfWord1 && index2 < lengthOfWord2 && char1[index1] == char2[index2]){
                index1++;index2++;
            }
            
            int judge = judge(index1,index2);
            if(judge == -1)
                continue;
            if(judge == 1)
                return level;
            
            queue.offer(new Node(index1+1,index2,level+1));
            queue.offer(new Node(index1,index2+1,level+1));
            queue.offer(new Node(index1+1,index2+1,level+1));
        }
        return -1;
    }
    private int judge(int index1,int index2){
        if(index1 == lengthOfWord1 || index2 == lengthOfWord2){
            if(index1 == lengthOfWord1 && index2 == lengthOfWord2)
                return 1;//find one
            return -1;//invalid
        }
        return 0;
    }
}
//使用动态规划算法
//从[0,0]位置处一直遍历到最后一个节点位置
//对于dp[i][j]，如果char1[i] == char2[j],dp[i][j] == dp[i-1][j-1]
//如果char1[i] != char2[j],dp[i][j] == min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1;
public class Solution {
    public int minDistance(String word1, String word2) {
         char[] char1 = word1.toCharArray();
         char[] char2 = word2.toCharArray();
         
         int row = char1.length;
         int col = char2.length;
         
         if(row == 0 || col == 0)
            return row > 0?row:col;
        
         int[][] dp = new int[row][col];
         if(char1[0] == char2[0])
            dp[0][0] = 0;
         else
            dp[0][0] = 1;
         
         //init first row
         for(int i = 1;i<col;i++){
             if(char1[0] == char2[i])
                dp[0][i] = i;
             else{
                 dp[0][i] = dp[0][i-1]+1;
             }
         }
         //init first col
         for(int i = 1;i<row;i++){
             if(char1[i] == char2[0])
                dp[i][0] = i;
             else
                dp[i][0] = dp[i-1][0]+1;
         }
         
         for(int i = 1;i<row;i++){
             for(int j = 1;j<col;j++){
                 if(char1[i] == char2[j])
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int min = Math.min(dp[i-1][j],dp[i][j-1]);
                    min = Math.min(dp[i-1][j-1],min);
                    dp[i][j] = min+1;
                }
             }
         }
         return dp[row-1][col-1];
    }
}