//找到分割点
//然后在分割点两侧分别使用二分法
public class Solution {
    public int search(int[] nums, int target) {
        //find the rotated index 
        int lastIndex = 0;
        while(lastIndex<nums.length-1 && nums[lastIndex]<nums[lastIndex+1]) lastIndex++;
        
        int left,right;
        if(target>=nums[0] && target<=nums[lastIndex]){
            left = 0;
            right = lastIndex;
        }else if(lastIndex+1<=nums.length-1 && target>=nums[lastIndex+1] && target<=nums[nums.length-1]){
            left = lastIndex+1;
            right = nums.length-1;
        }else{
            return -1;
        }
        
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]>target)
                right = mid-1;
            else
                left = mid+1;
        }
        return -1;
    }
}