public class Solution {
    public int reverse(int x) {
        boolean minus = false;
        if(x<0){
            minus = true;
            x = -x;
        }
        long res = 0;
        while(x>0){
            res = res*10+x%10;
            x = x/10;
        }
        if(res>Integer.MAX_VALUE)
            res = 0;
        return minus?(int)-res:(int)res;
    }
}