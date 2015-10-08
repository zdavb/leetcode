//问题描述：寻找下一自然排列的数
/*
    伪代码：
    for：index = 从后向前
        if(num[index] < num[index+1]){
            for: j = num.length-1 ---> index+1;//从后向前找到最小的一个大于当前值的元素
                if(num[j]>num[index])
                    swap(num[j],num[index]);

        }

    退出循环后
    reverse(num,index+1);//从index+1开始翻转整个数组，其实是对数组进行重排，变成升序
                        //但是由于index+1本来为降序，所以只需翻转即可
*/
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1)
            return;
        
        int last = nums.length - 2;
        while(last>=0){
            if(nums[last]<nums[last+1]){
                int val = nums[last];
                for(int i = nums.length-1;i>last;i--){
                    if(nums[i]>val){
                        //swap two number
                        nums[last] = nums[i];
                        nums[i] = val;
                        break;
                    }
                }
                break;
            }
            last--;
        }
         //reverse the last 
         int left = last+1;
         int right = nums.length-1;
         while(left<right){
             int tmpval = nums[left];
             nums[left] = nums[right];
             nums[right] = tmpval;
             left++;right--;
        }
    }
}