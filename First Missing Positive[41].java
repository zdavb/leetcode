//非常有意思的一道题
/*假设数组长度为N,那么我们可以肯定缺失的值一定在1---N+1之间
*为啥？假设缺失的值不在范围内，表示1---N+1的值都有，而数组最多只有N个，所以矛盾。假设不成立
    那既然如此，不在此范围内的值我们可以不用考虑了。
    所以遍历此数组，如果val大于等于1，小于等于length，并且num[i]!=num[val]，那么交换这两者位置（如果一样的话没有意义）
    然后再遍历一遍数组，找到第一个num[i]!=i+1的位置。并返回i+1，否则返回length+1
*/
public class Solution {
    private void swap(int[] nums,int left,int right){
        int val = nums[left];
        nums[left] = nums[right];
        nums[right] = val;
    }
    public int firstMissingPositive(int[] nums) {
        //使用桶排序
        int length = nums.length;
        for(int i = 0;i<length;i++){
            int val = nums[i];
            if(val>=1 && val<=length && nums[i]!=nums[val-1]){
                swap(nums,i,val-1);
                i--;
            }
        }
        for(int i = 0;i<length;i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return length+1;
    }
}