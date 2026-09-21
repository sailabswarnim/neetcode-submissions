class Solution {
    // bottom up solution
    public boolean canPartition(int[] nums) {
        // dp[i][target] - > can I form any subset from i -> n whose sum is target
        // dp[i][sum] = dp[i+1][sum] || dp[i+1][sum-nums[i]]

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        int n = nums.length;
        if((sum%2) != 0) return false;
        sum = sum/2;
        boolean[][] dp = new boolean[n][sum+1];
        for(int j = 0; j <= sum ; j++){
            if(nums[n-1] == j){
                dp[n-1][j] = true;
            }
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= sum; j++){
                if(j-nums[i] >= 0){
                    dp[i][j] = dp[i+1][j] || dp[i+1][j-nums[i]];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }

        return dp[0][sum];
    }
}
