public class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int len = 0;
        int index = chars.length-1;
    
        //去掉结尾空格
        while(index>=0){
            if(chars[index] == ' ')
                index--;
            else
                break;
        }
        while(index >= 0){
            if(chars[index] == ' ')
                break;
            len++;
            index--;
        }
        return len;
    }
}