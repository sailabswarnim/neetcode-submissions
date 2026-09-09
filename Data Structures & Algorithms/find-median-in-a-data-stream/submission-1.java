class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() && minHeap.isEmpty()){
            maxHeap.add(num);
        } 
        else {
            if(num < maxHeap.peek()){
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }

        // balancer
        if(Math.abs(minHeap.size() - maxHeap.size()) >= 2){
            if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            } else {
                minHeap.add(maxHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        double res;

        if(minHeap.size() == maxHeap.size()){
            res = (double) (minHeap.peek() + maxHeap.peek())/2;
        } else {
            res = (minHeap.size() > maxHeap.size()) ? (double) minHeap.peek() : (double) maxHeap.peek();
        }

        return res;
    }
}
