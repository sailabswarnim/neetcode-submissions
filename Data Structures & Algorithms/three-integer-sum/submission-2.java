class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int num1 = nums[i];
            int j = i + 1, k = nums.length - 1;
            int num2, num3;
            while(j < k){
                num2 = nums[j];
                num3 = nums[k];
                if(num1 + num2 + num3 == 0){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(num1);
                    curr.add(num2);
                    curr.add(num3);
                    result.add(curr);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (num1 + num2 + num3 > 0){
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
