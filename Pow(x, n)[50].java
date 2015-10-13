public class Solution {
    private int getBitSize(int n){
        int len = 0;
        for(len = 31;len>=0;len--){
            if((n & (1<<len)) != 0)
                break;
        }
        return len+1;
    }
    private boolean isset(int n,int i){
        return (n & (1<<i)) != 0;
    }
    public double myPow(double x, int n) {
        boolean minus = false;
        if(n<0){
            minus = true;
            n = -n;
        }
        int binarySize = getBitSize(n);
        if(binarySize == 0)
            return 1;
        
        double[] tmp = new double[binarySize];
        tmp[0] = x;
        for(int i = 1; i < binarySize;i++){
            tmp[i] = tmp[i-1]*tmp[i-1];
        }
        
        double res = 1.0;
        for(int i = 0;i < binarySize;i++){
            if(isset(n,i)){
                res *= tmp[i];
            }
        }
        if(minus)
            return 1.0/res;
        return res;
    }
}