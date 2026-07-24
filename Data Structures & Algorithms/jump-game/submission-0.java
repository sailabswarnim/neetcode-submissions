class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }

    public boolean dfs(int[] nums, int start){
        if(start >= nums.length - 1){
            return true;
        }

        for(int end = start + 1; end < nums.length; end++){
            if(start + nums[start] >= end && dfs(nums, end)){
                return true;
            }
        }

        return false;
    }
}
