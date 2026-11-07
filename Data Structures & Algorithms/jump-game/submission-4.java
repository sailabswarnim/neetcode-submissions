class Solution {
    public boolean canJump(int[] nums) {
        int left = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){
            int maxFromThis = nums[i] + i;

            if(maxFromThis >= left){
                left = i;
            }
        }

        return left == 0;
    }
}
