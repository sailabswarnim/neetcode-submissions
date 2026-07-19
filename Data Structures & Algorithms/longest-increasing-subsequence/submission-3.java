class Solution {
    // bottom up
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        dp[n-1][0] = 1;
        for(int j = 1; j < n + 1; j++){
            if(nums[n-1] > nums[j-1]){
                dp[n-1][j] = 1;
            } else {
                dp[n-1][j] = 0;
            }
        }

        for(int i = n - 2; i >=0; i--){
            for(int j = 0; j <= i; j++){
                if(j == 0 || nums[i] > nums[j - 1]){
                    dp[i][j] = Math.max(dp[i+1][j], 1 + dp[i+1][i+1]);
                } else {
                    dp[i][j] = dp[i+1][j]; 
                }
            }
        }

        return dp[0][0];
    }
}
