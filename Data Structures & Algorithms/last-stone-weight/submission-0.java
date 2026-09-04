class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for(int stone : stones){
            maxHeap.add(stone);
        }

        while(maxHeap.size() >= 2){
            int bigStone = maxHeap.poll();
            int smallStone = maxHeap.poll();

            int diff = bigStone - smallStone;
            if(diff > 0){
                maxHeap.add(diff);
            }
        }

        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }
}
