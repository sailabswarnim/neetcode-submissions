class Solution {
    // Top down memo
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        HashMap<String, Boolean> memo = new HashMap<>();
        return canPartitionRec(nums, 0, 0, sum/2, memo);
    }

    public boolean canPartitionRec(int[] nums, int start, int currSum, int sum, HashMap<String, Boolean> memo){

        String key = start + "-" +  currSum;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(start == nums.length){
            memo.put(key, currSum == sum);
            return currSum == sum;
        }

        boolean include = canPartitionRec(nums, start + 1, currSum + nums[start], sum, memo);
        boolean exclude = canPartitionRec(nums, start + 1, currSum, sum, memo);

        boolean res = include || exclude;
        memo.put(key, res);
        return res;

    }
}
