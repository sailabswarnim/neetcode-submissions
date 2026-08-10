class Solution {
    // top down
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<List<Integer>, Integer> memo = new HashMap<>();
        return targerSumWaysRec(nums, 0, target, memo);
    }

    public int targerSumWaysRec(int[] nums, int start, int target, HashMap<List<Integer>, Integer> memo){
        
        
        if(start == nums.length && target == 0){
            return 1;
        }

        if(start == nums.length) {
            return 0;
        }

        List<Integer> key = List.of(start, target);
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int noOfWays = 0;
        // add the number 
        noOfWays =  targerSumWaysRec(nums, start + 1, target - nums[start], memo);

        // subtract the number
        noOfWays += targerSumWaysRec(nums, start + 1, target + nums[start], memo);

        memo.put(key, noOfWays);
        return noOfWays;
    }
}
