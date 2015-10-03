public class Solution {
    public int findDuplicate(int[] nums) {
        //采用二分查找的方法
        int length = nums.length;
        int left = 1;
        int right = length-1;
        
        while(left<right){
            int mid = (left+right)/2;
            int count = 0;
            int base = 0;
            for(int i = 0;i<length;i++){
                if(nums[i]<mid)
                    count++;
                else if(nums[i]==mid)
                    base++;
            }
            if(base>1)
                return mid;
            else if(count+base>mid)
                right = mid-1;
            else
                left = mid+1;
        }
        return left;
    }
}