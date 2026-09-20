class KthLargest {
    PriorityQueue<Integer> minHeap;
    int heapSize;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        heapSize = k;
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > heapSize){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
