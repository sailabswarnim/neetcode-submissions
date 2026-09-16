/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// heap solution
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode node : lists){
            if(node != null){
                minHeap.add(node);
            }
        }

        ListNode dummy = new ListNode();
        dummy.next = minHeap.peek();
        ListNode temp = dummy;
        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();
            temp.next = curr;
            temp = curr;
            if(curr.next != null){
                minHeap.add(curr.next);
            }
        }

        return dummy.next;
    }
}
