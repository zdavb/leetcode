public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if(length <= 0)
            return new int[]{1};
        
        int prev = 0;
        for(int i = length-1;i>=0;i--){
            int val = digits[i]+1;
            if(val < 10){
                digits[i] = val;
                return digits;
            }
            prev = 1;
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        System.arraycopy(digits,0,res,1,digits.length);
        return res;
    }
}