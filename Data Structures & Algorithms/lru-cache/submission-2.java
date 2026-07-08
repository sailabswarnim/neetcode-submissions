public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Node left;
    Node right;
    HashMap<Integer, Node> map;
    int cap;
    public LRUCache(int capacity) {
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.map = new HashMap<>();
        this.cap = capacity;
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void add(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        add(node);

        if(map.size() > cap){
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
