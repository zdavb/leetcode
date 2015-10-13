public class Solution {
    public int jump(int[] nums) {
        int level = 0;
        int start = 0,end = 0;
        int target = nums.length - 1;
        
        while(end<target){
            level++;
            int value = end;
            for(int i = start;i<=end;i++){
                value = Math.max(value,nums[i]+i);
            }
            start = end+1;
            end = value;
        }
        return level;
    } 
}