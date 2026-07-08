class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        int l = 0, r = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        while(r < nums.length){
            if(currSum + nums[r] > 0){
                currSum += nums[r];
            } else {
                l = r + 1;
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
            r++;
        }

        if(maxSum == 0){
            Arrays.sort(nums);
            if(nums[nums.length - 1] < 0){
                return -1;
            }
        }
        return maxSum;
    }
        
}
