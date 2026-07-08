class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxWater = Integer.MIN_VALUE;
        while(i < j){
            int currCap = (j - i) * Math.min(heights[i], heights[j]);
            maxWater = Math.max(maxWater, currCap);
            if(heights[i] > heights[j]){
                j--;
            } else {
                i++;
            }
        }

        return maxWater;
    }
}
