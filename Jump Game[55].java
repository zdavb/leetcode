public class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        
        int left = 0,right = 0;
        while(right<length-1){
            int reachRight = right;
            for(int i = left;i<=right;i++){
                reachRight = Math.max(i+nums[i],reachRight);
            }
            if(reachRight<=right)
                return false;
            left = right+1;
            right = reachRight;
        }
        return true;
    }
}