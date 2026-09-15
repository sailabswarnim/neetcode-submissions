class Solution {
    // one pass
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        int maxSoFar = prices[n-1];

        for(int i = n-2; i >=0; i--){
            int currProfit = maxSoFar - prices[i];
            maxProfit = Math.max(maxProfit, currProfit);
            maxSoFar = Math.max(maxSoFar, prices[i]);
        }

        return (maxProfit > 0) ? maxProfit : 0;
    }
}
