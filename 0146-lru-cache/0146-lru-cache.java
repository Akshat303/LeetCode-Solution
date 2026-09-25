import java.util.HashMap;

class LRUCache {

    // Node for Doubly Linked List
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    // Key -> Node
    private HashMap<Integer, Node> map;

    // Dummy nodes
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        // Key not present
        if (!map.containsKey(key)) {
            return -1;
        }

        // Get node
        Node node = map.get(key);

        // Mark as recently used
        remove(node);
        addToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            // Update value
            node.value = value;

            // Mark as recently used
            remove(node);
            addToFront(node);

            return;
        }

        // Create new node
        Node node = new Node(key, value);

        // Store in HashMap
        map.put(key, node);

        // Add to front
        addToFront(node);

        // Capacity exceeded
        if (map.size() > capacity) {

            // Least Recently Used node
            Node lru = tail.prev;

            // Remove from list
            remove(lru);

            // Remove from map
            map.remove(lru.key);
        }
    }

    // Add node just after head
    private void addToFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Remove node from linked list
    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna