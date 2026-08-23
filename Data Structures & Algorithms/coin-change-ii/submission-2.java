class Solution {
    // bottom up dp
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length + 1];
        for(int j = 0; j <= coins.length; j++){
            dp[0][j] = 1;
        }

        for(int i = 0; i <= amount; i++){
            dp[i][coins.length] = 0;
        }

        for(int i = 1; i <= amount; i++){
            for(int j = coins.length - 1; j >=0; j--){
                dp[i][j] = dp[i][j + 1];
                if(i - coins[j] >= 0){
                    dp[i][j] += dp[i - coins[j]][j];
                }
            }
        }

        return dp[amount][0];
    }
}
