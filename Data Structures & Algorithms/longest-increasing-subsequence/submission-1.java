class Solution {
    // top down
    public int lengthOfLIS(int[] nums) {
        HashMap<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(nums, 0, Integer.MIN_VALUE, memo);
    }

    public int dfs(int[] nums, int start, int prev, HashMap<List<Integer>, Integer> memo){
        if(start >= nums.length){
            return 0;
        }

        List<Integer> key = List.of(start, prev);
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        // exclude
        int exclude = dfs(nums, start + 1, prev, memo);

        // include
        int include = 0;
        if(nums[start] > prev){
            include = 1 + dfs(nums, start + 1, nums[start], memo);
        }

        memo.put(key, Math.max(include, exclude));
        return memo.get(key);
    }
}
