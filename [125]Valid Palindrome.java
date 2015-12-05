public class Solution {
    char[] chars;
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        chars = s.toCharArray();
        int left = 0,right = chars.length-1;
        
        while(left < right){
            if(!isValid(left))
                left++;
            else if(!isValid(right))
                right--;
            else{
                if(chars[left] != chars[right])
                    return false;
                left++;right--;
            }
        }
        return true;
    }
    private boolean isValid(int index){
        char ch = chars[index];
        if((ch>='a' && ch<='z') || (ch >='A'&&ch<='Z') || (ch>='0'&&ch<='9'))
            return true;
        return false;
    }
}