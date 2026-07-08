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
    public void reorderList(ListNode head) {
        ListNode slo = head;
        ListNode fast = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode lastOfNonRev = dummy;
        while(fast != null){
            slo = slo.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            lastOfNonRev = lastOfNonRev.next;
        }

        ListNode curr = slo;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        lastOfNonRev.next = null;
        
        ListNode first = head;
        ListNode second = prev;
        ListNode temp = null;
        ListNode temp2 = null;

        while(second != null && first != null){
            temp = first.next;
            temp2 = second.next;
            first.next = second;
            second.next = temp;

            first = temp;
            second = temp2;
        }

    }
}
