class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left+1;
        int maxProfit=0;
        while(right < prices.length){
            int profit = prices[right]-prices[left] ; 
            maxProfit= Math.max(profit, maxProfit);   
             while(prices[left]>prices[right]){
                left++;
             }
             right++;
        }
        return maxProfit;
    }
}
