class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node( int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    Node tail;
    Node head;
    int capacity;
    int size;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.size = 0;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n != null) {
            if (n == head) {
                return n.value;
            }
            if (tail == n) {
                tail = n.next;
                tail.prev = null;
            } else {
                n.prev.next = n.next;
                n.next.prev = n.prev;
            }
            head.next = n;
            n.prev = head;
            head = n;
            return n.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() >= capacity) {
            map.remove(tail.key);
            tail = tail.next;
            if(tail != null)
            tail.prev = null;
        }
        Node n = new Node(key, value);
        if (tail == null) {
            head = n;
            tail = head;
            tail.prev = null;
        } else {
            n.prev = head;
            head.next = n;
            head = n;
        }
        map.put(key, n);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
