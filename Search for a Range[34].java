public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid] == target)
                break;
            else if(nums[mid]>target)
                right = mid-1;
            else
                left = mid+1;
        }
        if(nums[mid]!=target)
            return new int[]{-1,-1};
        left = mid;
        right = mid;
        while(left>=0){
            if(nums[left]!=nums[mid])
                break;
            left--;
        }
        while(right<nums.length){
            if(nums[right]!=nums[mid])
                break;
            right++;
        }
        return new int[]{left+1,right-1};
    }
}