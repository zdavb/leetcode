public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int mingap = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum>target){
                    if(sum-target<mingap){
                        mingap = sum-target;
                        res = sum;
                    }
                    right--;
                }else if(sum<target){
                    if(target-sum<mingap){
                        mingap = target-sum;
                        res = sum;                    
                    }
                    left++;
                }else{
                    return sum;
                }
            }
        }
        return res;
    }
}