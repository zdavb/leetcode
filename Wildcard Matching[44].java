//TLE版本
public class Solution {
    private boolean match(char[] char1,char[] char2,int leftIndex,int rightIndex){//leftIndex mean char1 index; while rightIndex mean char2 
        while(leftIndex<char1.length && rightIndex<char2.length && (char1[leftIndex] == char2[rightIndex] || char2[rightIndex] == '?')){
            leftIndex++;rightIndex++;
        }
        //index;
        if(leftIndex == char1.length || rightIndex == char2.length){
            if(leftIndex == char1.length && rightIndex == char2.length)
                return true;
            return false;
        }
        if(char2[rightIndex] != '*')
            return false;
        else{
            for(int len = 0;len<char1.length-rightIndex;len++){
                if(match(char1,char2,leftIndex+len,rightIndex+1))
                   return true;
            } 
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        char[] char1 = s.toCharArray();
        char[] char2 = p.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i<char2.length;i++){
            if(char2[i] == '*'){
                if(i-1>=0 && char2[i-1] == '*');
                else
                    builder.append(char2[i]);
            }else
                builder.append(char2[i]);
        }
        char2 = builder.toString().toCharArray();
        boolean res = match(char1,char2,0,0);
        return res;
    }
}

//AC版本
//注意到*的作用就是类似于分割线一样，只要我们能在源字符串中按序找到分割的字符串
//那么就已经找到了。
//正是这个原因，所以当有多个*的时候，后面的*其实是可以替代前面的*的。
//详情请见csdn博客http://blog.csdn.net/zdavb/article/details/49099149
public class Solution {
    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        
        int ss = -1,pp = -1;
        int sIndex = 0,pIndex = 0;
        
        while(sIndex<chars.length){
            if(pIndex == charp.length){//false，回溯
                if(pp == -1) return false;
                
                pIndex = pp+1; sIndex = ss++;
            }
            else if(charp[pIndex] == '?' || chars[sIndex] == charp[pIndex]){//相同
                pIndex++;sIndex++;
            }else if(charp[pIndex] == '*'){
                pp = pIndex;ss = sIndex;pIndex = pp+1;
            }else{
                if(pp == -1) return false;
                pIndex = pp+1;sIndex = ss++;
            }
        }
        while(pIndex<charp.length){
            if(charp[pIndex] != '*')
                break;
            pIndex++;
        }
        return pIndex == charp.length; 
    }
}