class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        if(nums.length == 0){
            return 0;
        }
        
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }
        }

        int largetSequence = Integer.MIN_VALUE;
        for(int num : nums){
            if(!set.contains(num-1)){
                int result = 0;
                while(set.contains(num)){
                    result++;
                    num++;
                }
                largetSequence = Math.max(largetSequence, result);
            }
        }

        return largetSequence;
    }
}
