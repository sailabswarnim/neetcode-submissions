class Solution {
    // Heap Solution
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> ((a[1]-a[0]) - (b[1]-b[0])));
        PriorityQueue<int[]> queriesHeap = new PriorityQueue<>((a,b)-> (a[0] - b[0]));
        for(int i = 0; i < queries.length; i++){
            queriesHeap.add(new int[]{queries[i],i});
        }

        int[] ans = new int[queries.length];
        int intervalVisitStart = 0;
        while(!queriesHeap.isEmpty()) {
            int[] queryWithIdx = queriesHeap.poll();
            int query = queryWithIdx[0];
            int idx = queryWithIdx[1];
            for(int j = intervalVisitStart; j < intervals.length; j++){
                if(intervals[j][0] > query){
                    intervalVisitStart = j;
                    break;
                } else {
                    minHeap.add(intervals[j]);
                }
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < query){
                minHeap.poll();
            }

            ans[idx] = (minHeap.isEmpty()) ? -1 : (minHeap.peek()[1] - minHeap.peek()[0] +1);
        }

        return ans;
    }
}

