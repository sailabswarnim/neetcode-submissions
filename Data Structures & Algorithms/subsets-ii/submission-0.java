class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(),result);

        return result;
    }

    public void dfs(int[] nums, int start, List<Integer> currSet, List<List<Integer>> result){
        if(start == nums.length){
            List<Integer> copyCurr = List.copyOf(currSet);
            result.add(copyCurr);
            return;
        }

        // include 
        currSet.add(nums[start]);
        dfs(nums, start + 1, currSet, result);

        //exclude
        currSet.remove(currSet.get(currSet.size() - 1));
        while(start + 1 < nums.length && nums[start] == nums[start + 1]){
            start++;
        }
        dfs(nums, start + 1, currSet, result);

        return;
    }
}
