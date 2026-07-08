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
            return null;
        }

        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        int counter = size - n;
        curr = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode preHead = dummy;
        while(counter > 0){
            dummy = dummy.next;
            if(curr != null)
                curr = curr.next;
            counter--;
        }

        dummy.next = curr.next;

        return preHead.next;

    }
}
