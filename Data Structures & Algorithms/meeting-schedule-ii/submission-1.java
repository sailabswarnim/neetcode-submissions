/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end - b.end);
        if(intervals.size() == 0)
            return 0;
            
        pq.add(intervals.get(0));
        for(int i = 1 ; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(!pq.isEmpty() && pq.peek().end <= curr.start){
                pq.poll();
            }
            pq.add(curr);
        }

        return pq.size();
    }
}
