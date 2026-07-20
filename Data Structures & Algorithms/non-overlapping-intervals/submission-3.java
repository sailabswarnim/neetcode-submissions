class Solution {
    // recursion
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        return dfs(intervals, 0, -1);
    }

    public int dfs(int[][] intervals, int start, int prevIdx){
        if(start >= intervals.length){
            return 0;
        }

        //exclude
        int exclude = 1 + dfs(intervals, start + 1, prevIdx);

        //include
        int include = Integer.MAX_VALUE;
        if(prevIdx == -1 || intervals[prevIdx][1] <= intervals[start][0]){
            include = dfs(intervals, start + 1, start);
        }
        
        return Math.min(include, exclude);
    }
}
