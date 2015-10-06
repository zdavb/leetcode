public class Solution {
    public int myAtoi(String str) {
        int index = 0;
        char[] chars = str.toCharArray();
        boolean minus = false;
        //过滤前排空格
        while(index<chars.length && chars[index] == ' ')
            index++;
        if(chars.length == index)
            return 0;
            
        if(chars[index] == '-'){
            minus = true;
            index++;
        }else if(chars[index] == '+')
            index++;
            
        long res = 0;
        for(int i = index;i<chars.length;i++){
            char val = chars[i];
            if(val>='0' && val<='9'){
                res = res*10+val-48;
            }else
                break;
            if(res>Integer.MAX_VALUE)
                return minus?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        return minus?(int)-res:(int)res;
    }
}