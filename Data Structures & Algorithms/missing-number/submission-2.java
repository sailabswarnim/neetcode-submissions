class Solution {
    // Set solution
    public int missingNumber(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        int result = 0;
        for(int num : nums){
            numbers.add(num);
        }

        for(int i = 0; i <=nums.length; i++){
            if(!numbers.contains(i)){
                result = i;
            }
        }

        return result;
    }
}
