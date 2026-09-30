class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
        for(int i = 0; i < n; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
            minHeap.add(pairs[i]);
        }

        Stack<Double> stack = new Stack<>();
        while(!minHeap.isEmpty()){
            int[] node = minHeap.poll();
            double time = (double) (target - node[0]) / node[1];
            while(!stack.isEmpty() && stack.peek() <= time){
                stack.pop();
            }
            stack.push(time);
        }

        return stack.size();
    }
}
