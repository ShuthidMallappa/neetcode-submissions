class LRUCache {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer,Node> map;
    class Node{
        int val;
        int key;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val=val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>();

        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        addToHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val=value;
            remove(node);
            addToHead(node);
        } else {
            if(map.size() == capacity){
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            addToHead(node);
            map.put(key,node);
        }
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addToHead(Node node){
        Node first = head.next;
        node.next=first;
        node.prev=head;
        head.next=node;
        first.prev=node;
    }
}
