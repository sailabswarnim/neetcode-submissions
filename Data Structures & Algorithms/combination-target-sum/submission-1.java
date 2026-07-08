class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combinationSumRec(nums, target, 0, curr, result);

        return result;
    }

    public void combinationSumRec(int[] nums, int target, int start, List<Integer> curr, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || start >= nums.length){
            return;
        }

        //include
        curr.add(nums[start]);
        combinationSumRec(nums, target - nums[start], start, curr, result);

        //backtrack because curr is a shared memory and needs to be cleaned up
        curr.remove(curr.size() - 1);

        // exclude
        combinationSumRec(nums, target, start + 1, curr, result);
    }
}
