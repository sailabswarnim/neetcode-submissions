class Solution {
    // Stack one pass
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int start = 0;
        for(int i = 0; i < n; i++){
            start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                maxArea = Math.max(maxArea, (top[1]) * (i - top[0]));
                start = top[0];
            }

            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()){
            int[] top = stack.pop();
            maxArea = Math.max(maxArea, (top[1]) * (n - top[0]));
        }

        return maxArea;
    }
}
