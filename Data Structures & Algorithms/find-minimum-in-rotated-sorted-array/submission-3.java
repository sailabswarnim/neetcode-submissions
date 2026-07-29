class Solution {
    public int findMin(int[] nums) {
        // int lo = 0;
        // int hi = nums.length - 1;
        // while(lo < hi){
        //     int mid = lo + (hi-lo)/2;

        //     // left half is sorted, depression must be on the right side
        //     if(nums[lo] < nums[mid]){
        //         lo = mid + 1;
        //     } else {
        //         hi = mid;
        //     }
        // }

        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;

            // left half is sorted, depression must be on the right side
            if(nums[mid] < nums[hi]){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return nums[lo];
    }
}
