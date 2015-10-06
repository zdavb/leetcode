public class Solution {
    private int findlen(char[] chars,int left,int right){
        while(left>=0 && right < chars.length && chars[left] == chars[right]){
            left--;right++;
        }
        return right;
    }
    public String longestPalindrome(String s) {
         int max = 0;
         int left=0,right = 1;
         char[] schar = s.toCharArray();
         for(int i = 0;i<schar.length-1;i++){
             int rightEdge1 = findlen(schar,i,i);
             int rightEdge2 = findlen(schar,i,i+1);
             int count1 = (rightEdge1-i)*2-1;
             int count2 = (rightEdge2-i-1)*2;
             if(count1>max){
                 max = count1;
                 left = 2*i-rightEdge1+1;
                 right = rightEdge1;
             }
             if(count2>max){
                 max = count2;
                 left = 2*i-rightEdge2+2;
                 right = rightEdge2;
             }
         }
         return s.substring(left,right);
    }
}
//更优雅一些
public class Solution {
    class Edge{
        int left;
        int right;
        int len;
        Edge(int left,int right){
            this.left = left;
            this.right = right;
            this.len = right-left;
        }
    }
    private Edge findEdgeOfCertainNumber(char[] chars,int left,int right){
        while(left>=0 && right<chars.length && chars[left] == chars[right]){
            left--;right++;
        }
        return new Edge(left+1,right);
    }
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int left = 0,right = 1;
        
        for(int i = 0;i<chars.length-1;i++){
            Edge e1 = findEdgeOfCertainNumber(chars,i,i);
            Edge e2 = findEdgeOfCertainNumber(chars,i,i+1);
            if(e1.len>max){
                max = e1.len;
                left = e1.left;
                right = e1.right;
            }
            if(e2.len>max){
                max = e2.len;
                left = e2.left;
                right = e2.right;
            }
        }
        return s.substring(left,right);
    }
}