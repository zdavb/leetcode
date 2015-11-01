//使用快慢指针
public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int slowptr = 1;
        int fastptr = 1;
        
        while(fastptr < nums.length){
            if(nums[fastptr] == nums[fastptr-1])
                count++;
            else
                count = 1;
            if(count <= 2){
                nums[slowptr] = nums[fastptr];
                slowptr++;
            }
            fastptr++;
        }
        return slowptr;
    }
}