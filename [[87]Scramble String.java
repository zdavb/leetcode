//这道题比较难，归根到底还是使用递归的算法，不过需要进行剪枝
public class Solution {
    public boolean isScramble(String s1, String s2) {
        return dfs(s1,s2);
    }
    public boolean dfs(String s1,String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        
        if(chars1.length == 0)
            return true;
        else if(chars1.length == 1)
            return chars1[0] == chars2[0];
        else if(chars1.length == 2){
            if(chars1[0] == chars2[0] && chars1[1] == chars2[1])
                return true;
            else if(chars1[0] == chars2[1] && chars1[1] == chars2[0])
                return true;
            return false;
        }
        int length = chars1.length;
        for(int i = 1;i<length;i++){
            char[] ss11 = s1.substring(0,i).toCharArray();
            char[] ss21 = s2.substring(0,i).toCharArray();
            char[] ss31 = s2.substring(length-i).toCharArray();
            
            char[] ss12 = s1.substring(i).toCharArray();
            char[] ss22 = s2.substring(i).toCharArray();
            char[] ss32 = s2.substring(0,length-i).toCharArray();
            
            Arrays.sort(ss11);Arrays.sort(ss21);Arrays.sort(ss12);Arrays.sort(ss22);Arrays.sort(ss31);Arrays.sort(ss32);
            
            String s1substr1 = s1.substring(0,i);
            String s1substr2 = s1.substring(i);
            String s2substr1 = s2.substring(0,i);
            String s2substr2 = s2.substring(i);
            String s3substr1 = s2.substring(length-i);
            String s3substr2 = s2.substring(0,length-i);
            
            if(Arrays.equals(ss11,ss21) && Arrays.equals(ss12,ss22) && dfs(s1substr1,s2substr1) && dfs(s1substr2,s2substr2))
                return true;
            if(Arrays.equals(ss11,ss31) && Arrays.equals(ss12,ss32) && dfs(s1substr1,s3substr1) && dfs(s1substr2,s3substr2))
                return true;
        }
        return false;
    }
}