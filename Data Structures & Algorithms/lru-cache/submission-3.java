class Node {
    Node prev;
    Node next;
    int val;
    int key;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    Node left;
    Node right;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.capacity = capacity;
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
        Node r = this.right.prev;
        r.next = node;
        node.prev = r;
        node.next = right;
        right.prev = node;

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
            Node node = map.get(key);
            remove(node);
        }

        Node newNode = new Node(key, value);
        add(newNode);
        map.put(key, newNode);

        if(map.size() > this.capacity){
            Node extra = this.left.next;
            remove(extra);
            map.remove(extra.key);
        }
    }
}
