//使用牛顿迭代法
public class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        double prev = 0;
        double res = 1;
        
        while(Math.abs(res-prev) >= 1){
            prev = res;
            res = (res+x/res)/2;
        }
        return (int)res;
    }
}