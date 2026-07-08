// dp bottom up

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sol = new int[n];
        sol[0] = nums[0];
        for(int i = 1 ; i < n; i++){
            sol[i] = Math.max(sol[i-1] + nums[i], nums[i]);
        }

        int result = Integer.MIN_VALUE;
        for(int num : sol){
            result = Math.max(result, num);
        }

        return result;
    }
}
