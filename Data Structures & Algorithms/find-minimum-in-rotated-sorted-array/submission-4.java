class Solution {
    // comparing with hi
    public int findMin(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;

            // right half is sorted, depression must be on the left side
            if(nums[mid] < nums[hi]){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return nums[lo];
    }
}
