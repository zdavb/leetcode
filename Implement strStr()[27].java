public class Solution {
    private boolean isMatch(char[] haychars,int index,char[] needchars){
        int ptr = 0;
        while(ptr<needchars.length){
            if(haychars[index+ptr] != needchars[ptr])
                return false;
            ptr++;
        }
        return true;
    }
    public int strStr(String haystack, String needle) {
        char[] haychars = haystack.toCharArray();
        char[] needchars = needle.toCharArray();
        
        int len = haychars.length-needchars.length;
        for(int i = 0;i<=len;i++){
            if(isMatch(haychars,i,needchars))
                return i;
        }
        return -1;
    }
}