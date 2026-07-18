class Solution {
    // top down solution
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount +1];
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                memo[i][j] = -1;
            }
        }
        int result = dfs(coins, 0, amount, memo);
        return (result == Integer.MAX_VALUE - 2) ? -1 : result;
    }

    public int dfs(int[] coins, int start, int amount, int[][] memo){
        if(start >= coins.length || amount < 0){
            return Integer.MAX_VALUE - 2;
        }

        if(amount == 0){
            return 0;
        }

        if(memo[start][amount] != -1){
            return memo[start][amount];
        }

        // include
        int includeWays = dfs(coins, start, amount - coins[start], memo);

        // exlude
        int excludeWays = dfs(coins, start + 1, amount, memo);

        memo[start][amount] = Math.min(1 + includeWays, excludeWays);
        return memo[start][amount];
    }
}