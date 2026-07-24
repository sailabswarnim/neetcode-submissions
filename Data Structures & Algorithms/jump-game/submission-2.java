class Solution {
    // bottom up
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for(int i = nums.length - 2; i>=0; i--){
            int maxJumFromThisIdx = Math.min(i + nums[i], nums.length-1);
            for(int end = i + 1; end <= maxJumFromThisIdx; end++){
                if(dp[end]){
                    dp[i] = true;
                    break;
                }
            }
        }  

        return dp[0];
    }
}
