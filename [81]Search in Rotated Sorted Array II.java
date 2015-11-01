public class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0;
        for(;i<nums.length;i++){
            if(nums[i] == target)
                return true;
            if(i+1 < nums.length && nums[i]>nums[i+1])
                break;
        }
        int start = i+1;
        int end = nums.length-1;
        
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
}