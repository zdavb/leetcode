//与最大子序列和问题类似；
//只是这里要求至少包含一个数
//因此，分两步，第一步求最大子序列和，当和为0时，表示，并没有可以采取的数。即数组中全为负数，所以再选出负数中的最大值
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length<=0)
            return 0;
        
        int max = 0;
        int maxSingle = nums[0];
        int thisSum = 0;
        
        for(int i = 0;i<nums.length;i++){
            thisSum+=nums[i];
            if(thisSum<0)
                thisSum = 0;
            else if(thisSum>max)
                max = thisSum;
            
            if(nums[i]>maxSingle)
                maxSingle = nums[i];
        }
        
        if(max == 0)
            return maxSingle;
        return max;
    }
}