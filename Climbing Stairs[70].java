public class Solution {
    public int climbStairs(int n) {
        int prevprev = 1;
        int prev = 2;
        
        if(n <= 2)
            return n;
        int cur = 3;
        int sum = 0;
        while(cur <= n){
            sum = prevprev+prev;
            cur++;
            prevprev = prev;
            prev = sum;
        }
        return sum;
    }
}