//在每次更新min时，更新max为当前值
//每次更新max值时，计算最大gap
public class Solution {
    public int maxProfit(int[] prices) {
        int maxVal = 0;
        if(prices.length <= 0)
            return 0;
            
        int min = prices[0];
        int max = prices[0];
        
        for(int i = 1;i<prices.length;i++){
            if(prices[i] > max){
                max = prices[i];
                if(max-min > maxVal)
                    maxVal = max-min;
            }else if(prices[i] < min){
                max = min;
                min = prices[i];
            }    
        }
        if(max-min > maxVal)
            maxVal = max-min;
        return maxVal;
    }
}