public class Solution {
    private int charToInt(char ch){
        int base = 0;
        switch(ch){
            case 'M':return 1000;
            case 'D':return 500;
            case 'C':return 100;
            case 'L':return 50;
            case 'X':return 10;
            case 'V':return 5;
            case 'I':return 1;
        }
        return base;
    }
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int prevVal = charToInt(chars[0]);
        int res = prevVal;
        
        for(int i = 1;i<chars.length;i++){
            int curVal = charToInt(chars[i]);
            if(curVal>prevVal){
                res+=curVal-2*prevVal;
            }else{
                res += curVal;
            }
            prevVal = curVal;
        }
        return res;
    }
}