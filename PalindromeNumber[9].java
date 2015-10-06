public class Solution {
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int xx = x;
        while(xx>0){
            reverse = reverse*10+xx%10;
            xx = xx/10;
        }
        return reverse == x;
    }
}