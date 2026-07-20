class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();

        // intervals before newInterval
        int i  = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            resultList.add(intervals[i]);
            i++;
        }

        while(i < intervals.length && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        resultList.add(newInterval);

        while(i < intervals.length){
            resultList.add(intervals[i]);
            i++;
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}
