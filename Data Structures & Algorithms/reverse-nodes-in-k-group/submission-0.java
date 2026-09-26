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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preReverse = new ListNode();
        preReverse.next = head;
        ListNode start = head;
        ListNode end = head;
        int num = k;
        while(end != null && num > 1){
            end = end.next;
            if(end == null){
                return head;
            }

            num--;
        }
        ListNode postReverse = end.next;
        ListNode newHead = end;
        while(end != null){
            postReverse = end.next;
            Pair p = reverse(start, end);
            preReverse.next = p.head;
            p.tail.next = postReverse;
            preReverse = p.tail;
            start = postReverse;
            end = start;
            for(int i = 1; i < k; i++){
                if(end == null){
                    return newHead;
                }
                end = end.next;
            }
        }

        return newHead;
    } 

    public Pair reverse(ListNode head, ListNode tail){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(prev != tail){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return new Pair(tail, head);

    }

    class Pair {
        ListNode head;
        ListNode tail;

        Pair(ListNode head, ListNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
}
