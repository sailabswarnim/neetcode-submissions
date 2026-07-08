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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int v1;
        int v2;
        int carry = 0;
        while(p1 != null || p2 != null || carry == 1){
            
            if(p1 != null){
                v1 = p1.val;
                p1 = p1.next;
            } else {
                v1 = 0;
            }

            if(p2 != null){
                v2 = p2.val;
                p2 = p2.next;
            } else {
                v2 = 0;
            }

            int num = v1 + v2 + carry;
            int dig = num % 10;
            carry = num / 10;
            ListNode node = new ListNode(dig);
            curr.next = node;
            curr = node;
        }

        return dummy.next;
    }
}
