class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Rec(candidates, target, 0 ,curr);
        return result;
    }

    public void combinationSum2Rec(int[] candidates, int target, int start, List<Integer> curr){
        if(start > candidates.length || target < 0){
            return;
        }

        if(target == 0){
            result.add(new ArrayList<>(curr));
        }

        for(int i = start ; i < candidates.length ; i++){
            if(candidates[i] > target) {
                break;
            }

            curr.add(candidates[i]);
            combinationSum2Rec(candidates, target - candidates[i], i + 1, curr);
            curr.remove(curr.size() - 1);
            while(i < candidates.length - 1 && candidates[i] == candidates[i+1]){
                i++;
            }
        }

        return;
    }
}
