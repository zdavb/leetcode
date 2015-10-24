public class Solution {
    int index = 0;
    public void sortColors(int[] nums) {
        int[] colorNums = new int[3];
        for(int i = 0;i<nums.length;i++){
            colorNums[nums[i]]++;
        }
        setArrayNum(nums,colorNums[0],0);
        setArrayNum(nums,colorNums[1],1);
        setArrayNum(nums,colorNums[2],2);
    }
    private void setArrayNum(int[] nums,int num,int value){
       for(int i = 0;i<num;i++) {
           nums[index++] = value;
       }
    }
}