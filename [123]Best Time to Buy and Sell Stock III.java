//这道题非常好，两次交易如何达到最大值呢？
//提示上说是利用DP算法，但是DP算法并不是核心
//考虑下，两次交易肯定不能重叠，也就是说前一次卖之后才能买
//因此，利用两个数组，第一个是从左到右的，比如到某天时，最大能收益额
//第二个数组，是从右向左的，比如从某天起的最大收益额
public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0)
            return 0;
            
        int sum = 0;
        
        int[] leftProfit = new int[length];
        int[] rightProfit = new int[length];
        
        leftProfit[0] = 0;
        int min = prices[0];
        //calulate leftProfit
        for(int i = 1;i<length;i++){
           int val = 0;
           if(prices[i] < min){
               min = prices[i];
           }else{
               val = prices[i] - min;
           }
            leftProfit[i] = Math.max(leftProfit[i-1],val);
        }
        //calcalate rightProfit
        int max = prices[length-1];
        rightProfit[length-1] = 0;
        for(int i = length-2;i>=0;i--){
            int val = 0;
            if(max > prices[i]){
                val = max-prices[i];
            }else{
                max = prices[i];
            }
             rightProfit[i] = Math.max(rightProfit[i+1],val);
        }
        
        //calcalate total
        for(int i = 0;i<length;i++){
            int total = leftProfit[i] + rightProfit[i];
            if(total > sum)
                sum = total;
        }
        return sum;
    }
}