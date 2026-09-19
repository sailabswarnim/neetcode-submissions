class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 0 -> buy , 1 -> sell
        dp[n-1][0] = 0;
        dp[n-1][1] =  prices[n-1];

        for(int i = n - 2; i >= 0; i--){
            for(int buying = 1; buying >= 0; buying--){
                if(buying == 1){
                    dp[i][0] = Math.max(dp[i+1][1] - prices[i], dp[i+1][0]);
                } else {
                    if(i+2 < n){
                        dp[i][1] = Math.max(dp[i+2][0] + prices[i], dp[i+1][1]);
                    } else {
                        dp[i][1] = Math.max(prices[i], dp[i+1][1]);
                    }
                }
            }
        }

        return dp[0][0];
    }
}
