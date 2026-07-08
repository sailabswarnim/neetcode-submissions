class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        combinationSumRec(nums, 0, target, curr);
        return result;
    }

    public void combinationSumRec(int[] nums, int start, int target, List<Integer> curr){
        if(start == nums.length){
            return;
        }

        if(target < 0){
            return;
        }

        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);
            combinationSumRec(nums, i, target - nums[i], curr);
            curr.remove(curr.size() - 1);
        }

        return;

    }
}
