public class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}


class LRUCache {

    public int cap;
    public HashMap<Integer, ListNode> cache;
    public ListNode left;
    public ListNode right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new ListNode(0, 0);
        this.right = new ListNode(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(ListNode node) {
        ListNode prv = node.prev;
        ListNode nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    public void insert(ListNode node) {
        ListNode prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        ListNode node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key));
        ListNode newNode = new ListNode(key, value);
        insert(newNode);
        cache.put(key, newNode);
        if (cache.size() > cap) {
            ListNode lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

}
