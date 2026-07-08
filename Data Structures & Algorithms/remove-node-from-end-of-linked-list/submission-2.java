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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode r = dummy;
        ListNode l = dummy;
        int counter = 0;
        while(counter < n){
            r = r.next;
            counter++;
        }

        while(r.next != null){
            r = r.next;
            l = l.next;
        }

        l.next = l.next.next;
        return dummy.next;


    }
}
