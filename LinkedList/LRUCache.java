/**
 *	146. LRU Cache
 *	https://leetcode.com/problems/lru-cache/description/
 */
class LRUCache {
	
	/**
	 * Version 1: Use DFS to get all subsets starting at certain index
	 *      Time: O(n)
	 *     Space: O(1)
	 */
	class DLNode {
        int key;
        int value;
        DLNode prev;
        DLNode next;
        
        public DLNode(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    
    Map<Integer, DLNode> map;
    int capacity;
    
    // Doubly Linked List
    // Head -> LRU
    // Tail -> MRU
    DLNode head;
    DLNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DLNode>();
        head = new DLNode(-1, -1);
        tail = new DLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        // Move the node to tail
        DLNode curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        moveToTail(curr);
        
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        // When the key exists
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        
        if (map.size() == capacity) {
            DLNode toRemove = head.next;
            head.next = head.next.next;
            head.next.prev = head;
            map.remove(toRemove.key);
        }
        
        DLNode newNode = new DLNode(key, value);
        map.put(key, newNode);
        moveToTail(newNode);
    }
    
    private void moveToTail(DLNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}