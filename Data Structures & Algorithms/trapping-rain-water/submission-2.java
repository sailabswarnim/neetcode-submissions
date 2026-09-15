class Solution {
    // O(n) time and constant space -  two pointer
    public int trap(int[] height) {
        int n = height.length;
        int l = 1;
        int r = n-2;
        int maxL = height[0];
        int maxR = height[n-1];
        
        int result = 0;
        while(l <= r){
            int currWater = 0;
            if(maxL <= maxR){
                currWater = Math.max(0, maxL - height[l]);
                maxL = Math.max(maxL, height[l]);
                l++;
            } else {
                currWater = Math.max(0, maxR - height[r]);
                maxR = Math.max(maxR, height[r]);
                r--;
            }

            result += currWater;
        }

        return result;
    }
}
