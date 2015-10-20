public class Solution {
    private boolean isDouble(String s){
        char[] chars = s.toCharArray();
        int index = 0;
        int length = chars.length;
        if(index < length && (chars[0] == '+' || chars[0] == '-'))
            index++;
        if(index>=length)
            return false;
        
        boolean hasPrefix = false,hasPostfix = false;
        boolean hasPoint = false;
        
        for(;index<chars.length;index++){
            if(chars[index] == '.'){
                if(hasPoint)
                    return false;
                hasPoint = true;
            }else if(chars[index] >= '0' && chars[index]<='9'){
                if(hasPoint)
                    hasPostfix = true;
                else
                    hasPrefix = true;
            }else
                return false;
        }
        if(!hasPrefix && !hasPostfix)
            return false;
        return true;
    }
    private boolean isInteger(String s){
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        if(index < length && (chars[index] == '+'|| chars[index] == '-'))
            index++;
            
        if(index >= length)
            return false;
            
        for(;index<chars.length;index++){
            if(chars[index] >='0' && chars[index] <='9');
            else
                return false;
        }
        return true;
    }
    public boolean isNumber(String s) {
        StringBuilder builder = new StringBuilder(s);
        //filter space from left and right
        int length = builder.length();
        while(length>0){
            char ch1 = builder.charAt(0);
            if(ch1 == ' '){
                builder.deleteCharAt(0);
                length--;
            }else 
                break;
        }
        while(length>0){
            char ch = builder.charAt(length-1);
            if(ch == ' '){
                builder.deleteCharAt(length-1);
                length--;
            }else
                break;
            
        }
        if(builder.length()<=0)
            return false;
        if(builder.charAt(builder.length()-1) == 'e')
            return false;
        String ss = builder.toString();
        
        String[] strs = ss.split("e");
        if (strs.length == 2)
            return isDouble(strs[0]) && isInteger(strs[1]);
        else if(strs.length == 1)
            return isDouble(strs[0]);
        return false;
    }
}