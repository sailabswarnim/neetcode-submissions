class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        subsetsRec(nums, 0, new ArrayList<>());
        return res;
    }

    public void subsetsRec(int[] nums, int start, List<Integer> curr){
        if(start == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        // include
        curr.add(nums[start]);
        subsetsRec(nums, start + 1, curr);

        // exclude
        curr.remove(curr.size()-1);
        subsetsRec(nums, start + 1, curr);

        return;
    } 
}
