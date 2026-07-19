class Solution {
    // top down optimised
    public int lengthOfLIS(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length + 1];
        return dfs(nums, 0, -1, memo);
    }

    public int dfs(int[] nums, int start, int prevIDX, Integer[][] memo){
        if(start >= nums.length){
            return 0;
        }

        if(memo[start][prevIDX + 1] != null){
            return memo[start][prevIDX + 1];
        }

        // exclude
        int exclude = dfs(nums, start + 1, prevIDX, memo);

        // include
        int include = 0;
        if(prevIDX == -1 || nums[start] > nums[prevIDX]){
            include = 1 + dfs(nums, start + 1, start, memo);
        }

        memo[start][prevIDX + 1] = Math.max(exclude, include);
        return memo[start][prevIDX + 1];
    }
}
