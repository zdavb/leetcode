public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
      
        if(prices.length <= 0)
            return sum;
            
        int min = -1;
        int prev = prices[0];
        
        for(int i = 1;i<prices.length;i++){
            if(prices[i] >= prev){
                if(min == -1)
                    min = prev;
            }else{
                if(min != -1){
                    sum += prev-min;//sell out
                }
                min = -1;
            }
             prev = prices[i];
        }
        if(min != -1)
            sum += prev-min;
        return sum;
    }
}