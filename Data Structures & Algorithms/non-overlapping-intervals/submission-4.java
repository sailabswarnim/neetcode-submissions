class Solution {
    // recursion top down memoised
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int[][] memo = new int[n][n+1];
        for (int[] row : memo) {
             Arrays.fill(row, -1);
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        return dfs(intervals, 0, -1, memo);
    }

    public int dfs(int[][] intervals, int start, int prevIdx, int[][] memo){
        if(start >= intervals.length){
            return 0;
        }

        if(memo[start][prevIdx + 1] != -1){
            return memo[start][prevIdx + 1];
        }

        //exclude
        int exclude = 1 + dfs(intervals, start + 1, prevIdx, memo);

        //include
        int include = 1_000_000;
        if(prevIdx == -1 || intervals[prevIdx][1] <= intervals[start][0]){
            include = dfs(intervals, start + 1, start, memo);
        }
        
        memo[start][prevIdx + 1] = Math.min(include, exclude);
        return Math.min(include, exclude);
    }
}
