/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> oldToNew = new HashMap<>();

        return cloneGraphRec(node, oldToNew);        
    }

    public Node cloneGraphRec(Node node, HashMap<Node, Node> oldToNew){
        if(node == null){
            return null;
        }

        if(oldToNew.containsKey(node)){
            return oldToNew.get(node);
        }

        Node n = new Node(node.val);
        oldToNew.put(node, n);

        for(Node nbr : node.neighbors){
            Node newNbr = cloneGraphRec(nbr, oldToNew);
            n.neighbors.add(newNbr);
        }

        return n;
    }
}