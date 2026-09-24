// Dequeue
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> dequeue = new LinkedList<>();
        for(int i = 0; i < k; i++){
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] <= nums[i]){
                dequeue.pollLast();
            }

            dequeue.addLast(i);
        }

        result[0] = nums[dequeue.peekFirst()];

        int i = k;
        while(i < nums.length){
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] <= nums[i]){
                dequeue.pollLast();
            }

            dequeue.addLast(i);

            while(!dequeue.isEmpty() && dequeue.peekFirst() < (i-k+1)){
                dequeue.pollFirst();
            }

            result[i-k+1] = nums[dequeue.peekFirst()];
            i++;
        }

        return result;
    }
} 