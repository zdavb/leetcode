//核心思想是：组成树的数量完全由节点的个数决定，因此可以利用动态规划法来完成
public class Solution {
    public int numTrees(int n) {
        if(n == 0)
            return 0;
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        
        for(int i = 2;i<=n;i++){
            int count = 0;
            for(int j = 1;j <= i;j++){
                int leftgap = j-1;
                int rightgap = i-j;
                count += nums[leftgap] * nums[rightgap];
                
            }
            nums[i] = count;
        }
        return nums[n];
    }
}