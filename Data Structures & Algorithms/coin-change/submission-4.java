class Solution {
    // top down solution
    public int coinChange(int[] coins, int amount) {
        int result = dfs(coins, 0, amount);
        return (result == Integer.MAX_VALUE - 2) ? -1 : result;
    }

    public int dfs(int[] coins, int start, int amount){
        if(start >= coins.length || amount < 0){
            return Integer.MAX_VALUE - 2;
        }

        if(amount == 0){
            return 0;
        }

        // include
        int includeWays = dfs(coins, start, amount - coins[start]);

        // exlude
        int excludeWays = dfs(coins, start + 1, amount);

        return Math.min(1 + includeWays, excludeWays);
    }
}
