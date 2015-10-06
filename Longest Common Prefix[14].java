public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        if(strs.length == 0)
            return "";
        int length = strs[0].length();
        while(index<length){
            char ch = strs[0].charAt(index);
            int i;
            for(i = 1;i<strs.length;i++){
                if(index >= strs[i].length() || strs[i].charAt(index)!=ch)
                    break;
            }
            if(i < strs.length)
                break;
            index++;
        }
        return strs[0].substring(0,index);
    }
}