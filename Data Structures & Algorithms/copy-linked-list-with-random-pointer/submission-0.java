/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        HashMap<Node, Node> oldtoNew = new HashMap<>();
        Node curr = head;
        while(curr != null){
            int val = curr.val;
            Node newNode = new Node(val);
            oldtoNew.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node newNode = oldtoNew.get(curr);
            newNode.next = oldtoNew.get(curr.next);
            newNode.random = oldtoNew.get(curr.random);
            curr = curr.next;
        }

        return oldtoNew.get(head);
    }
}
