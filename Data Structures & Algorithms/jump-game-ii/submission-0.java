class Solution {
    // Greedy Solution
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1){
            return 0;
        }

        int l = 0;
        int r = nums[0];

        if(r >= n - 1){
            return 1;
        }
        int jumps = 1;
        while(r < n - 1){
            int farthest = Integer.MIN_VALUE;

            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }
}
