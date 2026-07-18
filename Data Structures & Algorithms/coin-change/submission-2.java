class Solution {
    // bottom up solution
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        int notPossible = amount + 1;
        // dp[i][j] is the minimum of ways I can make the j target with i as ending index of the coins array
        // dp[i][j] = Math.min(1 + dp[i][j-coins[i]], dp[i-1][j])
        for(int j = 0; j <= amount; j++){
            dp[0][j] = (j%coins[0] == 0) ? j/coins[0] : notPossible;
        }

        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i < n; i++){
           for(int j = 1; j <= amount; j++){
                if(j-coins[i]>=0){
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i]], dp[i-1][j]);
                } else {
                    dp[i][j] =  dp[i-1][j];
                }
                
            } 
        }

        return (dp[n-1][amount] != notPossible) ? dp[n-1][amount] : -1 ;
    }
}