class Solution {
    // backtracking
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] chosen = new boolean[nums.length];
        Arrays.fill(chosen, false);
        permuteRec(nums, new ArrayList<>(), chosen);
        return result;
    }

    public void permuteRec(int[] nums, List<Integer> curr, boolean[] chosen){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!chosen[i]){
                chosen[i] = true;
                curr.add(nums[i]);
                permuteRec(nums, curr, chosen);
                curr.remove(curr.size() - 1);
                chosen[i] = false;
            }
        }

        return;
    }
}
