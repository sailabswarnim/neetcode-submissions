class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];

            result = Math.max(result, Math.max(prefix, suffix));
            
            if(prefix == 0){
                prefix = 1;
            }

            if(suffix == 0){
                suffix = 1;
            }

            
        }

        return result;
    }
}

