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
        HashSet<Node> visited = new HashSet<>();
        HashSet<Node> visited2 = new HashSet<>();
        dfsCreate(node, visited, oldToNew);
        dfsLink(node, oldToNew, visited2);

        return oldToNew.get(node);
    }

    public void dfsCreate(Node node, HashSet<Node> visited, HashMap<Node, Node> oldToNew){
        if(node == null){
            return;
        }

        if(visited.contains(node)){
            return;
        }

        visited.add(node);
        oldToNew.put(node, new Node(node.val));
        for(Node nbr : node.neighbors){
            if(!visited.contains(nbr)){
                dfsCreate(nbr, visited, oldToNew);
            }
        }

        return;
    }

    public void dfsLink(Node node, HashMap<Node, Node> oldToNew, HashSet<Node> visited){
        if(node == null){
            return;
        }

        if(visited.contains(node)){
            return;
        }

        visited.add(node);

        for(Node nbr : node.neighbors){
            oldToNew.get(node).neighbors.add(oldToNew.get(nbr));
            if(!visited.contains(nbr)){
                dfsLink(nbr, oldToNew, visited);
            }
        }

        return;
    }
}