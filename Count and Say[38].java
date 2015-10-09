public class Solution {
    public String countAndSay(int n) {
        StringBuilder next = new StringBuilder();
        String s = "1";
        if(n<=0)
            return "";
        
        for(int index = 1;index<n;index++){
            char[] chars = s.toCharArray();
            int count = 1;
            for(int i = 1;i<chars.length;i++){
                if(chars[i] != chars[i-1]){
                    next.append(count);
                    next.append(chars[i-1]);
                    count = 1;
                }else{
                    count++;
                }
            }
            if(count>0){
                next.append(count);
                next.append(chars[chars.length-1]);
            }
            s = next.toString();
            next = new StringBuilder();
        }
        return s;
    }
}