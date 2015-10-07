public class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0,fast = 1;
        if(nums.length == 0)
            return 0;
        while(fast<nums.length){
            if(nums[slow] != nums[fast]){
                nums[slow+1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow+1;
    }
}