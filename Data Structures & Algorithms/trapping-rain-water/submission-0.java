class Solution {
    // O(n) time and space
    public int trap(int[] height) {
        int n = height.length;
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        maxL[0] = height[0];
        maxR[n-1] = height[n-1];
        for(int i = 1; i < n; i++){
            maxL[i] = Math.max(maxL[i-1], height[i]);
            maxR[n-i-1] = Math.max(maxR[n-i], height[n-i-1]);
        }

        int result = 0;
        for(int i = 1; i < n-1; i++){
            int waterAti = Math.min(maxL[i-1], maxR[i+1]) - height[i];
            if(waterAti < 0){
                waterAti = 0;
            }

            result += waterAti;
        }

        return result;
    }
}
