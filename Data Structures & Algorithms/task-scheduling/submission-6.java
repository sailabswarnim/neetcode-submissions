class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        int[] map = new int[26];
        for(char c : tasks){
            map[c-'A']++;
        }

        for(int count : map){
            if(count>0){
                maxHeap.add(count);
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll();
                count--;
                if(count > 0){
                    queue.add(new int[]{count, time + n});
                }
            }

            if(!queue.isEmpty() && time >= queue.peek()[1]){
                maxHeap.add(queue.poll()[0]);
            }
        }

        return time;
    }
}
