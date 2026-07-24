class Solution {
    // top down memoised
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return dfs(nums, 0, dp);
    }

    public boolean dfs(int[] nums, int start, Boolean[] dp){
        if(start >= nums.length - 1){
            return true;
        }

        if(dp[start] != null){
            return dp[start];
        }

        for(int end = start + 1; end < nums.length; end++){
            if(start + nums[start] >= end && dfs(nums, end, dp)){
                dp[start] = true;
                return true;
            }
        }

        dp[start] = false;
        return false;
    }
}
