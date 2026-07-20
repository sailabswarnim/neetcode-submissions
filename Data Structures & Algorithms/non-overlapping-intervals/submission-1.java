class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int removalCount = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(prevEnd <= currStart){
                prevEnd = currEnd;  
            } else {
                // overlap
                removalCount++;
            }
        }

        return removalCount;
    }
}
