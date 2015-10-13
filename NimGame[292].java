//stack overflow
public class Solution {
    private boolean solve(int n,boolean isMe){
        if(n<=3){
            if(isMe)
                return true;
            return false;
        }
        for(int i = 1;i<=3;i++){
            if(solve(n-i,!isMe))
                return true;
        }
        return false;
    }
    public boolean canWinNim(int n) {
        return solve(n,true);
    }
}
//亲自画画题就会发现规律了
public class Solution {
    public boolean canWinNim(int n) {
        int val = n%4;
        if(val >= 1 && val <= 3)
            return true;
        return false;
    }
}