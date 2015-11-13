//O(n2)复杂度
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        if(nums.length <= 1)
            return nums.length;
            
        for(int i = 0;i<nums.length;i++){
            int cur = nums[i];
            int count = 0;
            
            int left = i-1,right = i+1;
            int leftVal = cur,rightVal = cur;
            //左移
            while(left >= 0){
                if(nums[left] < leftVal){
                    count++;
                    leftVal = nums[left];
                }
                left--;
            }
            //右移
            while(right < nums.length){
                if(nums[right] > rightVal){
                    count++;
                    rightVal = nums[right];
                }
                right++;
            }
            if(count > max)
                max = count;
        }
        return max+1;
    }
}
//O(nlogn)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
            
        return binarySearch(nums,0,nums.length-1);
    }
    private int binarySearch(int[] nums,int left,int right){
        if(left == right)
            return 1;
        if(right - left == 1){
            if(nums[right] > nums[left])
                return 2;
            else if(nums[right] == nums[left])
                return 1;
            else
                return 0;
        }
        int mid = (left+right)/2;
        int leftlen = binarySearch(nums,left,mid);
        int rightlen = binarySearch(nums,mid,right);
        
        int count = 1;
        int leftVal = nums[mid],rightVal = nums[mid];
        int leftIndex = mid-1;
        int rightIndex = mid+1;
        
        while(leftIndex >= 0){
            if(nums[leftIndex] < leftVal){
                count++;
                leftVal = nums[leftIndex];
            }    
            leftIndex--;
        }
        while(rightIndex < nums.length){
            if(nums[rightIndex] > rightVal){
                count++;
                rightVal = nums[rightIndex];
            }
            rightIndex++;
        }
        
        int tmpMax = Math.max(leftlen,rightlen);
        return Math.max(tmpMax,count);
    }
}