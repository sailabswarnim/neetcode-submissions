class Solution {
    // kadane's clean
    public int maxSubArray(int[] nums) {
        int prevSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(prevSum <= 0){
                prevSum = 0;
            }

            maxSum = Math.max(maxSum, prevSum + nums[i]);
            prevSum += nums[i];
        }

        return maxSum;
    }
}
