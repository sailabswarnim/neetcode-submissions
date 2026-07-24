class Solution {
    // greedy
    public boolean canJump(int[] nums) {
        int leftMost = nums.length - 1;
        for(int i = nums.length - 2; i>=0; i--){
            int maxJumFromThisIdx = Math.min(i + nums[i], nums.length-1);
            if(maxJumFromThisIdx >= leftMost){
                leftMost = i;
            }
        }  

        return leftMost == 0;
    }
}
