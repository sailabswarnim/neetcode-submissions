class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );

        for(int i = 0; i < points.length; i++){
            pq.add(points[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] result = new int[pq.size()][2];
        for(int i = 0; i < result.length; i++){
            int[] newPoint = pq.poll();
            result[i][0] = newPoint[0];
            result[i][1] = newPoint[1];
        }

        return result;
    }
}
